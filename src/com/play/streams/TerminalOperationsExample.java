package com.play.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * References:
 * https://dev.java/learn/api/streams/
 * java.util.stream.Stream
 */
public class TerminalOperationsExample {

    public static void main(String[] args) {

//         forEachExample();
//         findFirstAndFindAnyExample();
//         matchOperationsExample();
//         countExample();
//         minMaxExample();
//         reduceExample();
//         collectToListExample();
//         collectToMapExample();
    }

    /**
     * forEach triggers execution.
     * Order not guaranteed in parallel streams.
     */
    static void forEachExample() {

        List<String> names = List.of("Java", "Streams", "API");

        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    /**
     * findFirst preserves encounter order.
     * findAny may return any element, faster in parallel streams.
     */
    static void findFirstAndFindAnyExample() {

        List<Integer> numbers = List.of(10, 20, 30, 40);

        Optional<Integer> first =
                numbers.stream().findFirst();

        Optional<Integer> any =
                numbers.parallelStream().findAny();

        System.out.println("findFirst: " + first.orElse(-1));
        System.out.println("findAny: " + any.orElse(-1));
    }

    /**
     * anyMatch, allMatch, noneMatch
     * Short-circuiting terminal operations.
     */
    static void matchOperationsExample() {

        List<Integer> numbers = List.of(2, 4, 6, 8);

        boolean anyOdd = numbers.stream()
                .anyMatch(n -> n % 2 != 0);

        boolean allEven = numbers.stream()
                .allMatch(n -> n % 2 == 0);

        boolean noneNegative = numbers.stream()
                .noneMatch(n -> n < 0);

        System.out.println(anyOdd);
        System.out.println(allEven);
        System.out.println(noneNegative);
    }

    /**
     * count returns number of elements after pipeline execution.
     */
    static void countExample() {

        long count = IntStream.range(1, 10)
                .filter(n -> n > 5)
                .count();

        System.out.println(count);
    }

    /**
     * min/max rely on Comparator.
     */
    static void minMaxExample() {

        List<String> names = List.of("Java", "Go", "Python");

        Optional<String> longest =
                names.stream()
                        .max(Comparator.comparingInt(String::length));

        longest.ifPresent(System.out::println);
    }

    /**
     * reduce combines elements using an associative function.
     */
    static void reduceExample() {

        int sum = IntStream.rangeClosed(1, 5)
                .reduce(0, Integer::sum);

        System.out.println("Sum = " + sum);
    }

    /**
     * collect transforms stream into a container.
     */
    static void collectToListExample() {

        List<String> upper =
                List.of("java", "stream")
                        .stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());

        System.out.println(upper);
    }

    /**
     * toMap requires unique keys or merge function.
     */
    static void collectToMapExample() {

        List<String> names = List.of("Java", "Go", "Python");

        var map =
                names.stream()
                        .collect(Collectors.toMap(
                                name -> name,
                                String::length
                        ));

        System.out.println(map);
    }

}
