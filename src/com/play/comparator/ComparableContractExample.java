package com.play.comparator;

import java.util.List;

/**
 * Demonstrates natural ordering using Comparable.
 */
public class ComparableContractExample {

    public static void main(String[] args) {
         naturalOrderingExample();
    }

    static void naturalOrderingExample() {

        List<Version> versions =
                List.of(
                        new Version(2),
                        new Version(1),
                        new Version(3)
                );

        versions.stream()
                .sorted()
                .forEach(System.out::println);
    }

    static class Version implements Comparable<Version> {

        private final int value;

        Version(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Version other) {
            return Integer.compare(this.value, other.value);
        }

        @Override
        public String toString() {
            return "Version " + value;
        }
    }
}
