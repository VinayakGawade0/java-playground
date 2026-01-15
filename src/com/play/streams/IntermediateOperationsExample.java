package com.play.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * References:
 * https://dev.java/learn/api/streams/
 * java.util.stream.Stream
 */
public class IntermediateOperationsExample {

    public static void main(String[] args) {

//         filterExample();
//         mapExample();
//         flatMapExample();
//         distinctExample();
//         sortedNaturalOrderExample();
//         sortedWithComparatorExample();
//         limitAndSkipExample();
         peekExample();
    }

    /**
     * Stream#filter(Predicate)
     * Lazy, stateless, non-interfering.
     */
    static void filterExample() {

        List<Integer> numbers = List.of(10, 15, 20, 25);

        numbers.stream()
                .filter(n -> n > 15)
                .forEach(System.out::println);
    }

    /**
     * Stream#map(Function)
     * Used for projection and transformation.
     */
    static void mapExample() {

        List<String> names = List.of("java", "stream");

        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    /**
     * Stream#flatMap(Function<T, Stream<R>>)
     * Avoids nested streams.
     */
    static void flatMapExample() {

        List<List<String>> teams = List.of(
                List.of("A", "B"),
                List.of("C", "D")
        );

        teams.stream()
//                .peek(System.out::println)
                .flatMap(List::stream)
                .forEach(System.out::println);
    }

    /**
     * Stream#distinct()
     * Uses equals() and hashCode().
     */
    static void distinctExample() {

        Stream.of(1, 2, 2, 3, 3)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * Stream#sorted()
     * Uses natural ordering (Comparable).
     */
    static void sortedNaturalOrderExample() {

        List<Integer> numbers = List.of(5, 1, 3);

        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * Stream#sorted(Comparator)
     * Externalized comparison logic.
     */
    static void sortedWithComparatorExample() {

        List<String> names = List.of("Java", "Go", "Python");

        names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }

    /**
     * limit and skip are useful for pagination.
     */
    static void limitAndSkipExample() {

        Stream.iterate(1, n -> n + 1)
                .skip(2)
                .limit(3)
                .forEach(System.out::println);
    }

    /**
     * Stream#peek()
     * Intended for debugging, not business logic.
     */
    static void peekExample() {

        List<Integer> numbers = List.of(1, 2, 3);

        numbers.stream()
                .peek(n -> System.out.println("Before map: " + n))
                .map(n -> n * 2)
                .forEach(System.out::println);
    }

}
