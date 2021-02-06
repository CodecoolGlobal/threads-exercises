package com.codecool.threads.collections.synchronised;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CollectionDemo {

    public static void main(String[] args) throws InterruptedException {
        removeElementsFromStandardList();
        removeElementsFromSynchronizedList();
    }

    private static void removeElementsFromSynchronizedList() throws InterruptedException {
        List<Integer> integers = new ArrayList<>();
        List<Integer> list = Collections.synchronizedList(integers);
        Collections.addAll(list, new Integer[10000]);
        removeElementsFromList(list);
    }

    private static void removeElementsFromStandardList() throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, new Integer[10000]);
        removeElementsFromList(list);
    }

    private static void removeElementsFromList(List<Integer> list) throws InterruptedException {
        System.out.println("initial size: " + list.size());

        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            executorService.execute(() -> list.remove(0));
        }
        executorService.shutdown();
        executorService.awaitTermination(1000, TimeUnit.SECONDS);
        System.out.println(list.size());//should be zero
    }

}
