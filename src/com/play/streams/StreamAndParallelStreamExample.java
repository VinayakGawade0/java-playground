package com.play.streams;

import java.util.List;
import java.util.stream.IntStream;

/**
 * References:
 * dev.java -> Streams API (real-world usage)
 * java.util.stream.Stream (Java SE API Docs)
 */
public class StreamAndParallelStreamExample {
    public static void main(String[] args) {

//         sequentialStreamExample();
//         parallelStreamExample();
//         orderingDifferenceExample();
//         performanceMisuseExample();
         sideEffectDangerExample();
    }

    /**
     * Stream pipeline executed sequentially on a single thread.
     * Predictable ordering.
     */
    static void sequentialStreamExample() {

        List<Integer> numbers = IntStream.rangeClosed(1, 5).boxed().toList();

        numbers.stream()
                .map(n -> {
                    System.out.println("Processing " + n +
                            " on thread " + Thread.currentThread().getName());
                    return n * 2;
                })
                .forEach(System.out::println);
    }

    /**
     * Parallel stream splits work across ForkJoinPool.commonPool.
     * Order is NOT guaranteed unless explicitly requested.
     */
    static void parallelStreamExample() {

        List<Integer> numbers = IntStream.rangeClosed(1, 5).boxed().toList();

        numbers.parallelStream()
                .map(n -> {
                    System.out.println("Processing " + n +
                            " on thread " + Thread.currentThread().getName());
                    return n * 2;
                })
                .forEach(System.out::println);
    }

    /**
     * forEach vs forEachOrdered difference in parallel streams.
     */
    static void orderingDifferenceExample() {

        List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().toList();

        System.out.println("forEach:");
        numbers.parallelStream()
                .forEach(System.out::print);

        System.out.println("\n\nforEachOrdered:");
        numbers.parallelStream()
                .forEachOrdered(System.out::print);
    }

    /**
     * Parallel streams are NOT always faster.
     * Overhead can dominate for small workloads.
     */
    static void performanceMisuseExample() {

        long start = System.currentTimeMillis();

        IntStream.range(0, 1_000)
                .parallel()
                .map(n -> n * n)
                .sum();

        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end - start) + " ms");
    }

    /**
     * Demonstrates why stateful operations are dangerous
     * in parallel streams.
     */
    static void sideEffectDangerExample() {

        List<Integer> numbers = IntStream.rangeClosed(1, 1_000).boxed().toList();
        int[] sum = new int[1]; // mutable shared state

        numbers.parallelStream() // Sum = 500500
                .forEach(n -> sum[0] += n);

        System.out.println("Sum = " + sum[0]);
    }

}
