package org.binknight.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(){
            public void run(){
                System.out.println(Thread.currentThread().getName() + " running 1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " done");
                latch.countDown();
        }}.start();

        new Thread(){
            public void run(){
                System.out.println(Thread.currentThread().getName() + " running 2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " done");
                latch.countDown();
            }}.start();

        System.out.println("waiting task done");
        latch.await();
        System.out.println("task done");
        System.out.println("继续执行主线程");
    }

}
