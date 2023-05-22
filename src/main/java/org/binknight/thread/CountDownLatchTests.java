package org.binknight.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTests {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start....");
        CountDownLatch cd = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                System.out.println("sub tasking running");
                cd.countDown();
            } ).start();
        }
        //cd.await();
        System.out.println("main done");
    }
}
