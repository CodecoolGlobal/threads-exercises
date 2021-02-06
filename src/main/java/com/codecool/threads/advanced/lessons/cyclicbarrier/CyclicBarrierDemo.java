package com.codecool.threads.advanced.lessons.cyclicbarrier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int numberOfPartialResults = 3;
        int numberOfThreads = 5;
        List<List<Integer>> partialResults = Collections.synchronizedList(new ArrayList<>());

        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfThreads,
                new AggregatorThread(numberOfThreads, numberOfPartialResults, partialResults));

        System.out.println("Spawning " + numberOfThreads
                + " worker threads to compute "
                + numberOfPartialResults + " partial results each");

        for (int i = 0; i < numberOfThreads; i++) {
            Thread worker = new Thread(new NumberCruncherThread(numberOfPartialResults, partialResults, cyclicBarrier));
            worker.setName("Thread " + i);
            worker.start();
        }
    }


}
