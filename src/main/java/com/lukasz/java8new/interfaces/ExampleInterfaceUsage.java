package com.lukasz.java8new.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleInterfaceUsage {
    private static Logger log = LoggerFactory.getLogger(ExampleInterfaceUsage.class);
    public static void main(String[] args) {
        SimpleInterface obj = () -> log.debug("Let's do something");
        obj.doSomething();

        SimpleInterfaceArgs obj2 = (v1, v2) -> {
            int result = v1 + v2;
            log.debug("The result of {} + {} = {}", v1, v2, result);
        };

        obj2.calculate(10, 5);
    }
}
