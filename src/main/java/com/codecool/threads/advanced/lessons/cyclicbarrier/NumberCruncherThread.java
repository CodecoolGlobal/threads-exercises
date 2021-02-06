package com.codecool.threads.advanced.lessons.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class NumberCruncherThread implements Runnable {

    private final int numberOfPartialResults;
    private final List<List<Integer>> partialResults;
    private final Random random = new Random();
    private final CyclicBarrier cyclicBarrier;

    public NumberCruncherThread(int numberOfPartialResults,
                                List<List<Integer>> partialResults,
                                CyclicBarrier cyclicBarrier) {
        this.numberOfPartialResults = numberOfPartialResults;
        this.partialResults = partialResults;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        String thisThreadName = Thread.currentThread().getName();
        List<Integer> partialResult = new ArrayList<>();

        // Crunch some numbers and store the partial result
        for (int i = 0; i < numberOfPartialResults; i++) {
            Integer num = random.nextInt(10);
            System.out.println(thisThreadName
                    + ": Crunching some numbers! Final result - " + num);
            partialResult.add(num);
        }

        partialResults.add(partialResult);
        try {
            System.out.println(thisThreadName + " waiting for others to reach barrier.");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("Getting into problem here");
        }
    }
}
