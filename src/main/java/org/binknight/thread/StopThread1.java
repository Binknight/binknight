package org.binknight.thread;

public class StopThread1 {
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        mythread.start();
        try{
            Thread.sleep(10);
            mythread.shutdownThread();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Mythread extends Thread{
        private volatile boolean flag = true;

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " working, flag = " + flag);
            int i = 0;
            while (flag){
                System.out.println("do something " + i++);
            }
        }

        public void shutdownThread() {
            this.flag = false;
            System.out.println(Thread.currentThread().getName()+ " flag = " + flag + " thread will shutdown");
        }
    }
}
