package org.binknight.netty;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

public class Test {
    public static volatile int count;
    public static Vector<Object> s = new Vector<>();
    public static int add(){
        Vector<Object> v = new Vector<>();
        int i = count;
        synchronized (Test.class){
            if(i==count){
                return ++count;
            }else {
                return add();
            }
        }
    }

    public static synchronized int add1(){
        return ++count;
    }
    public static void main (String[] args) throws InterruptedException {
        int ii = 150;
        ThreadPoolExecutor pool = new ThreadPoolExecutor(ii,
                ii,
                4000L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        long l = System.currentTimeMillis();

        List<Future<?>> list = new ArrayList<>();
        for (int i = 0; i < ii; i++) {
            list.add(pool.submit(() -> createRequest(l)));
        }
        while(list.stream().anyMatch((n -> !n.isDone()))){}
        System.out.println(System.currentTimeMillis()-l + "ms");
        System.out.println("count = " + count);
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }
    }

    private static void createRequest(long l){
        while(Test.count < 1000){
            try {
                synchronized (Object.class){
                    int count = Test.add();
                    s.add(count);
                    Thread.sleep(5);
                    System.out.println(Thread.currentThread().getName() + ": 发起第"+ count  +"个请求" );
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
