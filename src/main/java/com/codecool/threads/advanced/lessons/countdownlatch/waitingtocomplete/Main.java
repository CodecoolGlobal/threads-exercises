package com.codecool.threads.advanced.lessons.countdownlatch.waitingtocomplete;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);

        List<Runnable> checkers = Arrays.asList(
                new CacheHealthChecker(countDownLatch),
                new DatabaseHealthChecker(countDownLatch),
                new NetworkHealthChecker(countDownLatch)
        );

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (Runnable checker : checkers) {
            executorService.execute(checker);
        }

        countDownLatch.await();
        System.out.println(countDownLatch.getCount());
        executorService.shutdownNow();
    }
}
