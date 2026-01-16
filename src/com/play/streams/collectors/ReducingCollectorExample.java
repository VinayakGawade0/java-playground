package com.play.streams.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * reducing collector is collector-form of reduce().
 */
public class ReducingCollectorExample {

    public static void main(String[] args) {
         simpleReducingExample();
         reducingWithGroupingExample();
    }

    static void simpleReducingExample() {

        int sum =
                List.of(1, 2, 3)
                        .stream()
                        .collect(Collectors.reducing(
                                0,
                                Integer::sum
                        ));

        System.out.println(sum);
    }

    static void reducingWithGroupingExample() {

        List<String> names = List.of("Java", "Go", "Python");

        Map<Integer, Integer> lengthSumBySize =
                names.stream()
                        .collect(Collectors.groupingBy(
                                String::length,
                                Collectors.reducing(
                                        0,
                                        String::length,
                                        Integer::sum
                                )
                        ));

        System.out.println(lengthSumBySize);
    }
}