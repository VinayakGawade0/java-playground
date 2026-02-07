package com.play.streams.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates toMap usage and merge function.
 */
public class ToMapExample {

    public static void main(String[] args) {
         simpleToMapExample();
         toMapWithMergeExample();
    }

    static void simpleToMapExample() {

        Map<String, Integer> map =
                List.of("Java", "Go", "Python")
                        .stream()
                        .collect(Collectors.toMap(
                                name -> name,
                                String::length
                        ));

        System.out.println(map);
    }

    static void toMapWithMergeExample() {

        Map<Character, String> map =
                List.of("Java", "JavaScript", "Go")
                        .stream()
                        .collect(Collectors.toMap(
                                s -> s.charAt(0),
                                s -> s,
                                (existing, replacement) -> existing
                        ));

        System.out.println(map);
    }
}