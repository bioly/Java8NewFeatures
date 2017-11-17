package com.lukasz.java8new.lambdas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UseComparators {

    private static Logger log = LoggerFactory.getLogger(UseComparators.class);

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("FFF");
        strings.add("111");
        strings.add("aaa");
        strings.add("AAA");
        strings.add("BBB");
        strings.add("bbb");
        strings.add("ggg");
        strings.add("HHH");

        log.debug("**** Simple Sort ****");
        Collections.sort(strings);
        strings.stream().forEach(log::debug);

        log.debug("**** custom Comparator ****");
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        strings.stream().forEach(log::debug);

        log.debug("**** Using lambdas ****");
        Collections.sort(strings, (str1, str2) ->{
            return str1.compareToIgnoreCase(str2);
        });
        strings.stream().forEach(log::info);

    }
}
