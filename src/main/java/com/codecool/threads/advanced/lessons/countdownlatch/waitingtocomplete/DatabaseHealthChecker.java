package com.codecool.threads.advanced.lessons.countdownlatch.waitingtocomplete;

import java.util.concurrent.CountDownLatch;

public class DatabaseHealthChecker implements Runnable {

    private final CountDownLatch countDownLatch;

    public DatabaseHealthChecker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Checking Database connection...");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Database is UP!");
        countDownLatch.countDown();
    }
}
