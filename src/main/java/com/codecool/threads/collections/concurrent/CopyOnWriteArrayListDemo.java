package com.codecool.threads.collections.concurrent;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});

        Iterator<Integer> iterator = numbers.iterator();
        numbers.add(10);

        List<Integer> firstList = new LinkedList<>();
        iterator.forEachRemaining(firstList::add);

        System.out.println(firstList);


        Iterator<Integer> iterator2 = numbers.iterator();

        List<Integer> secondList = new LinkedList<>();
        iterator2.forEachRemaining(secondList::add);

        System.out.println(secondList);
    }

}
