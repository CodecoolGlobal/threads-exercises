package com.codecool.threads.advanced.lessons.cyclicbarrier;

import java.util.List;

public class AggregatorThread implements Runnable {

    private final int numberOfThreads;
    private final int numberOfPartialResults;
    private final List<List<Integer>> partialResults;

    public AggregatorThread(int numberOfThreads, int numberOfPartialResults, List<List<Integer>> partialResults) {
        this.numberOfThreads = numberOfThreads;
        this.numberOfPartialResults = numberOfPartialResults;
        this.partialResults = partialResults;
    }

    @Override
    public void run() {
        String thisThreadName = Thread.currentThread().getName();

        System.out.println(
                thisThreadName + ": Computing sum of " + numberOfThreads
                        + " threads, having " + numberOfPartialResults + " results each.");
        int sum = 0;

        for (List<Integer> threadResult : partialResults) {
            System.out.print("Adding ");
            for (Integer partialResult : threadResult) {
                System.out.print(partialResult + " ");
                sum += partialResult;
            }
            System.out.println();
        }
        System.out.println(thisThreadName + ": Final result = " + sum);
    }
}