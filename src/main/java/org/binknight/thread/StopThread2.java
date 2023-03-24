package org.binknight.thread;

public class StopThread2 {

    public static void main(String[] args) {

        WorkThread workThread = new WorkThread("workThread");
        workThread.start();

        try {
            // 模拟主线程的业务
            System.out.println(Thread.currentThread().getName() + " working...");
            Thread.sleep(3_000);

            // 假设触发了某种条件，需要中断workThread线程的执行 调用interrupt
            workThread.interrupt();
            System.out.println(Thread.currentThread().getName() + " received  interrupt signal...");



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread interrupt...");

    }


    static class WorkThread extends Thread {

        public WorkThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " working ");
            // 死循环
            while (true) {
                // 判断 该线程是否被打断
                if (Thread.interrupted()) {
                    System.out.println("workThread interrupt...");
                    // break (break的话  还会执行 assume some logic is here的代码)
                    // 或者
                    // return (return 的话，如果有后面还有代码的话就不会执行后续的代码了)
                    break;
                }
                // assume some logic is here
            }
        }
    }

}
