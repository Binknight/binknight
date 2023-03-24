package org.binknight.threadpool;

import sun.java2d.pipe.SpanShapeRenderer;

import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) {
        //1 固定数线程池
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        //2 缓存线程池
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        //3 周期性线程池
        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        //4 单线程池
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        //自定义线程池
        LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();
        ThreadFactory factory = null;
        ThreadPoolExecutor threadPool =
                new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, queue, factory,null);
    }

}
