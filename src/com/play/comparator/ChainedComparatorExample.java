package com.play.comparator;

import java.util.Comparator;
import java.util.List;

/**
 * Demonstrates comparator chaining.
 */
public class ChainedComparatorExample {

    public static void main(String[] args) {
         chainedComparatorExample();
    }

    static void chainedComparatorExample() {

        List<String> names = List.of("Java", "Go", "Python", "C");

        names.stream()
                .sorted(
                        Comparator.comparingInt(String::length)
                                .thenComparing(Comparator.naturalOrder())
                )
                .forEach(System.out::println);
    }
}
