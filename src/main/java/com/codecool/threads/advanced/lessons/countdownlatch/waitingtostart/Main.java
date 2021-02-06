package com.codecool.threads.advanced.lessons.countdownlatch.waitingtostart;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(2);
        CountDownLatch doneSignal = new CountDownLatch(4);

        Worker worker = new Worker(startSignal, doneSignal);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.execute(worker);
        }

        System.out.println("Main Thread started working");
        sleep(5000);
        startSignal.countDown();

        doneSignal.await();
        executorService.shutdownNow();
    }
}
