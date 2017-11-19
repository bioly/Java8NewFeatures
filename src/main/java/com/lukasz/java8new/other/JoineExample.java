package com.lukasz.java8new.other;

import java.util.Arrays;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

public class JoineExample {

    public static void main(String[] args) {
        String stooges = String.join(",","Larry", "Curly", "Moe");
        System.out.println(stooges);

        String[] states = {"California", "Oregon", "Washington"};
        String stateList = String.join(",", states);
        System.out.println(stateList);

        StringJoiner sj = new StringJoiner(",","{","}");
        sj.setEmptyValue("empty value");
        System.out.println(sj);
        Arrays.asList(states).forEach(sj::add);
        System.out.println(sj);

        StringJoiner sj2 = new StringJoiner(",");
        sj2.add("Texas").add("Memphis");

        sj.merge(sj2);

        System.out.println(sj);

        Set<String> set = new TreeSet<>();
        set.add("Saturn 1");
        set.add("Saturn 2");
        set.add("Saturn 3");
        StringJoiner sj3 = new StringJoiner(" and ");
        set.forEach(sj3::add);
        System.out.println(sj3);
    }
}
