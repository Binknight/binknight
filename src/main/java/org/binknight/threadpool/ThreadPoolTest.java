package org.binknight.threadpool;


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
        /**   向线程池添加一个任务时
         * 1. 有空闲线程，直接执行任务
         * 2. 没空闲线程，如果运行线程数 < 核心线程数，则创建新线程执行任务
         * 3. 没空闲线程，如果运行线程数 = 核心线程数，且队列未满，将任务加入队列等待
         * 4. 没空闲线程，如果队列已满，运行线程数 < 最大线程数，则创建新线程执行任务
         * 5. 没空闲线程，如果队列已满，运行线程数 = 最大线程数，则按照拒绝策略拒绝新任务
         */
        LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(100);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                1,
                1,
                1,
                TimeUnit.SECONDS,
                queue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }

}
