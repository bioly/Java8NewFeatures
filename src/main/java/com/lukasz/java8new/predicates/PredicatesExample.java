package com.lukasz.java8new.predicates;

import com.lukasz.java8new.domain.Person;

import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicatesExample {

    public static Stream<Person>  streamOf(final long qty) {
        return Stream.generate(supplier).limit(qty);
    }

    public static Supplier<Person> supplier = () ->
            getPerson();

    public static Random random = new Random();

    private static Person getPerson() {
        String namesString = "abdasfrkjgjbnlsjnveufbkajbchbdvrksbglanvljdbavuevalvnalevbalca";

        char c = namesString.toCharArray()[random.nextInt(namesString.length() - 1)];
        String name = String.valueOf(c);

        return new Person(name, random.nextInt(100));
    }

    public static void main(String[] args) {
//        Stream<Person> persons = streamOf(10);
//        persons.forEach(System.out::println);

        Predicate<Person> prep =
                new Predicate<Person>() {
                    @Override
                    public boolean test(Person person) {
                        return person.getAge() > 30;
                    }
                };


        for(Person p : streamOf(100).collect(Collectors.toList())){
            if(prep.test(p)){
                System.out.println(p);
            }
        }


        System.out.println("**********************");
        // now in using lambda
        Predicate<Person> predOlder = (p) -> {
            return p.getAge() > 90;
        };

        streamOf(100).forEach(person -> {
            if(predOlder.test(person)){
                System.out.println(person);
            }
        });

        System.out.println("**********************");
        streamOf(100).filter(predOlder)
                .forEach(System.out::println);

        System.out.println("**********************");

        Stream<Integer> intStream = Stream.of(1,2,3,4);
        intStream.forEach(System.out::println);
    }
}
