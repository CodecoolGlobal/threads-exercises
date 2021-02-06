package com.codecool.threads.collections.synchronised;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Producer extends Thread {

    private final List<Integer> collection;
    private final List<Integer> numbersToAdd = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public Producer(List<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public void run() {
        collection.addAll(numbersToAdd);
    }
}
