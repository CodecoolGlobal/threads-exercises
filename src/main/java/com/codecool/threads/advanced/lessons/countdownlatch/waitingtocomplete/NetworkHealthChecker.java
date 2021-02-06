package com.codecool.threads.advanced.lessons.countdownlatch.waitingtocomplete;

import java.util.concurrent.CountDownLatch;

public class NetworkHealthChecker implements Runnable {

    private final CountDownLatch countDownLatch;

    public NetworkHealthChecker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Checking Network Service connection...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Network Service is UP!");
        countDownLatch.countDown();
    }
}
