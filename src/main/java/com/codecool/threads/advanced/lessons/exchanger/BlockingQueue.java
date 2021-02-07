package com.codecool.threads.advanced.lessons.exchanger;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private final Queue<String> queue = new LinkedList<>();

    public String take() {
        return queue.remove();
    }

    public void put(String packet) {
        queue.add(packet);
    }

    public boolean nonEmpty() {
        return !queue.isEmpty();
    }

}
