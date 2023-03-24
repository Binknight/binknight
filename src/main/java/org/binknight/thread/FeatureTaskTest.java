package org.binknight.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FeatureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1创建FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(()-> 1+2);

        // 2创建线程池
        ExecutorService es = Executors.newCachedThreadPool();

        // 3提交FutureTask
        es.submit(futureTask);

        // 4获取计算结果
        Integer result = futureTask.get();
        System.out.println(result);

        // 5关闭线程池
        es.shutdown();
    }
}
