package com.codecool.threads.advanced.lessons.executorservice.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class App {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> tasks = getTasks();
        List<Future<Integer>> futures = executorService.invokeAll(tasks);

        sleep(200);

        int sum = futures.stream()
                .mapToInt(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException e) {
                        return 0;
                    }
                })
                .sum();

        System.out.println(sum);

        executorService.shutdownNow();
    }

    private static List<Callable<Integer>> getTasks() {
        List<Callable<Integer>> tasks = new ArrayList<>();

        int numberOfTasks = 10;
        while (numberOfTasks > 0) {
            tasks.add(() -> new Random().nextInt(50));
            numberOfTasks--;
        }

        return tasks;
    }

}
