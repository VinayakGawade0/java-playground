package com.play.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * References:
 * <a href="https://dev.java/learn/api/streams/">dev.java/streams</a>
 * java.util.stream.Stream (Java SE API)
 */
public class StreamSourceExample {

    public static void main(String[] args) {

//         collectionStreamExample();
//         streamOfExample();
//         arraysStreamExample();
//         iterateExample();
//         generateExample();
//         primitiveStreamExample();
        lazinessProof();
    }

    /**
     * Most common stream source.
     * Ordered, finite, predictable.
     */
    static void collectionStreamExample() {

        List<String> names = List.of("Amit", "Neha", "Ravi");

        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    /**
     * Creates a stream from explicit values.
     * Useful for small, known datasets.
     */
    static void streamOfExample() {

        Stream.of(10, 20, 30)
                .map(n -> n * 2)
                .forEach(System.out::println);
    }

    /**
     * Specialized stream creation for arrays.
     * Preferred over Stream.of(array).
     */
    static void arraysStreamExample() {

        int[] numbers = {1, 2, 3, 4};

        Arrays.stream(numbers)
                .map(n -> n * n)
                .forEach(System.out::println);
    }

    /**
     * Creates an infinite, ordered stream.
     * Must be bounded using limit().
     */
    static void iterateExample() {

        Stream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(System.out::println);

        Stream.iterate(1, n -> n <= 5, n -> n + 1)
                .forEach(System.out::println);
    }

    /**
     * Generates values using Supplier.
     * No ordering guarantee.
     */
    static void generateExample() {

        Random random = new Random();

        Stream.generate(random::nextInt)
                .limit(5)
                .forEach(System.out::println);
    }

    /**
     * Avoids boxing/unboxing overhead.
     * Preferred for numeric computations.
     */
    static void primitiveStreamExample() {

        int sum = IntStream.rangeClosed(1, 10)
                .sum();

        System.out.println("Sum = " + sum);
    }

    static void lazinessProof() {

        Stream.of(1, 2, 3)
                .map(n -> {
                    System.out.println("Mapping " + n);
                    return n * 2;
                });

        // No terminal operation → nothing executes
    }

}
