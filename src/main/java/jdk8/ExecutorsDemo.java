package jdk8;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());

        int initialDelay = 0;
        int period = 1;
//        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);

        ScheduledExecutorService executorService2 = Executors.newScheduledThreadPool(4);
        Runnable runnable = () -> {

            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        Runnable runnable1 = () -> {

            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Scheduling1: " + System.nanoTime());
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

//        executorService2.scheduleWithFixedDelay( runnable,0,1,TimeUnit.SECONDS);
//        executorService2.scheduleWithFixedDelay( runnable1,0,1,TimeUnit.SECONDS);


        System.out.println((byte)11);


    }
}
