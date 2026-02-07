package com.play.streams.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * groupingBy is the most frequently tested collector.
 */
public class GroupingByExample {

    public static void main(String[] args) {
         simpleGroupingExample();
         groupingWithCountExample();
    }

    static void simpleGroupingExample() {

        List<String> names = List.of("Java", "Go", "Java", "Python");

        Map<String, List<String>> grouped =
                names.stream()
                        .collect(Collectors.groupingBy(name -> name));

        System.out.println(grouped);
    }

    static void groupingWithCountExample() {

        List<String> names = List.of("Java", "Go", "Java", "Python");

        Map<String, Long> frequency =
                names.stream()
                        .collect(Collectors.groupingBy(
                                name -> name,
                                Collectors.counting()
                        ));

        System.out.println(frequency);
    }
}