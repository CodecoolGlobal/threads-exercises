package com.codecool.threads.advanced.lessons.semaphore;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);

        Incrementer incrementer = new Incrementer(semaphore);
        Decrementer decrementer = new Decrementer(semaphore);

        incrementer.start();
        decrementer.start();

        incrementer.join();
        decrementer.join();

        System.out.println("count: " + Shared.count);
    }


}
