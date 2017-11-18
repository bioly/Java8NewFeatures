package com.lukasz.java8new.domain;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Person {

    public static Stream<Person> streamOf(final long qty) {
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

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static int compareAges(Person p1, Person p2){
        Integer age1 = p1.getAge();
        return age1.compareTo(p2.getAge());
    }
}
