package com.lukasz.java8new.lambdas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdaWithThreadsUsage {

    private static Logger log = LoggerFactory.getLogger(LambdaWithThreadsUsage.class);

    private static void oldWay() {
        class MyRunnable implements Runnable{
            @Override
            public void run() {
                log.debug("OldWay Runs");
            }
        }

        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

    private static void betterWay() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.debug("BetterWay Runs");
            }
        }).start();
    }

    private static void newWay() {
        new Thread(()->{
            log.debug("NewWay Runs");
        }).start();
    }

    public static void main(String[] args) {
        log.debug("Let's start ...");
        oldWay();
        betterWay();
        newWay();
    }
}
