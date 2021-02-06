package com.codecool.threads.advanced.lessons.countdownlatch.waitingtostart;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class Worker implements Runnable {

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " entered run");
            startSignal.await();

            System.out.println(Thread.currentThread().getName() + " is working run");
            sleep(4000);
            doneSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
