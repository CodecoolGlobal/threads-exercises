package com.codecool.threads.advanced.lessons.exchanger;

import java.util.concurrent.Exchanger;

public class Consumer implements Runnable {

    private BlockingQueue blockingQueue;
    private final Exchanger<BlockingQueue> exchanger;
    private int PACKETS_LIMIT = 10;

    public Consumer(Exchanger<BlockingQueue> exchanger, BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (PACKETS_LIMIT > 0) {
            if (blockingQueue.nonEmpty()) {
                try {
                    String packet = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + " consumes: " + packet);
                    exchanger.exchange(blockingQueue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                PACKETS_LIMIT--;
            }
        }
    }
}
