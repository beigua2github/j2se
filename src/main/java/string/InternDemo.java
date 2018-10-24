package string;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InternDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        int count = 2;
        while (count >= 0) {
            executorService.submit(() -> Intern1.doSomeStuff());
            executorService.submit(() -> Intern2.doSomeStuff());
            count--;
        }

        executorService.shutdown();
    }
}

class Intern1 {
    private static final String LOCK1 = "LOCK";

    public static void doSomeStuff() {
        synchronized (LOCK1) {
            System.out.println("Intern--1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Intern2 {
    private static final String LOCK2 = "LOCK";

    public static void doSomeStuff() {
        synchronized (LOCK2) {
            System.out.println("Intern--2");
        }
    }
}