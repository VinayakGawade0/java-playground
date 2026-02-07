package com.play.comparator;

import java.util.Comparator;
import java.util.List;

/**
 * Comparator defines external ordering logic.
 */
public class ComparatorBasicsExample {

    public static void main(String[] args) {
         lengthComparatorExample();
    }

    static void lengthComparatorExample() {

        List<String> names = List.of("Java", "Go", "Python");

        names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }
}
