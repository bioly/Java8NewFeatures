package com.lukasz.java8new.aggregation;

import com.lukasz.java8new.domain.Person;

import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AggregationExample {

    public static Random random = new Random();

    public static Stream<Integer> streamOf(final long qty) {
        return Stream.generate(supplier).limit(qty);
    }

    public static Supplier<Integer> supplier = () -> random.nextInt(1000);

    public static void main(String[] args) {

        Stream <Integer> myStreamOfInts = streamOf(1000);
        List<Integer> myListOfInts = myStreamOfInts.collect(Collectors.toList());
        Collections.sort(myListOfInts);

        long count = myListOfInts.stream().count();

        System.out.println("Number of items in the list: " + count);

        List<Person> people =
                Person.streamOf(5).collect(Collectors.toList());

        int ageSum =
                people.stream()
                .mapToInt(p -> p.getAge())
                .sum();

        System.out.println("The sum of age of following people: ");
        people.stream().forEach(System.out::println);
        System.out.println("TOTAL AGE SUM: " + ageSum);

        OptionalDouble avg = people.stream()
                .mapToInt(p -> p.getAge())
                .average();

        System.out.println("AVERAGE AGE: " + avg.orElse(0.0));
    }
}
