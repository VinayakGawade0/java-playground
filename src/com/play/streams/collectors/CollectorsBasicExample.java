package com.play.streams.collectors;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * References:
 * https://dev.java/learn/api/streams/
 * java.util.stream.Collectors
 */
public class CollectorsBasicExample {

    public static void main(String[] args) {
         toListExample();
         toSetExample();
         joiningExample();
    }

    static void toListExample() {

        List<String> result =
                List.of("java", "streams")
                        .stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());

        System.out.println(result);
    }

    static void toSetExample() {

        Set<Integer> result =
                List.of(1, 2, 2, 3)
                        .stream()
                        .collect(Collectors.toSet());

        System.out.println(result);
    }

    static void joiningExample() {

        String result =
                List.of("Java", "Stream", "API")
                        .stream()
                        .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}