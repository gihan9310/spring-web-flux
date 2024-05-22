package com.gihanz.utils;

import java.time.Duration;

public class ThreadSleepUtils {

    public  static void  sleepSeconds(int seconds){
        try {
            Thread.sleep(Duration.ofSeconds(seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
