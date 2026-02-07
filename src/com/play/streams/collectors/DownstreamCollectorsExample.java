package com.play.streams.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates downstream collectors.
 */
public class DownstreamCollectorsExample {

    public static void main(String[] args) {
         groupingWithMappingExample();
         groupingWithSummingExample();
    }

    static void groupingWithMappingExample() {

        List<String> names = List.of("Java", "Go", "Python");

        Map<Integer, List<String>> result =
                names.stream()
                        .collect(Collectors.groupingBy(
                                String::length,
                                Collectors.mapping(
                                        String::toUpperCase,
                                        Collectors.toList()
                                )
                        ));

        System.out.println(result);
    }

    static void groupingWithSummingExample() {

        List<String> names = List.of("Java", "Go", "Python");

        Map<Integer, Integer> totalLengthBySize =
                names.stream()
                        .collect(Collectors.groupingBy(
                                String::length,
                                Collectors.summingInt(String::length)
                        ));

        System.out.println(totalLengthBySize);
    }
}