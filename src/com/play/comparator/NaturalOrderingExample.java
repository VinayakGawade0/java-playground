package com.play.comparator;

import java.util.List;

/**
 * sorted() relies on Comparable when no Comparator is provided.
 */
public class NaturalOrderingExample {

    public static void main(String[] args) {
         naturalOrderExample();
    }

    static void naturalOrderExample() {

        List<Integer> numbers = List.of(5, 1, 3);

        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }
}