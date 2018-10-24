package multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    static ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(1);
    static ExecutorService threadPoolExecutor2 = Executors.newFixedThreadPool(1);


    static  ThreadLocal<String> local = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        local.set("value-set-in-parent");


        Runnable t1 = () -> {
            System.out.println(ThreadLocalDemo.local.get());

            ThreadLocalDemo.local.set("kobe-1");

            System.out.println(ThreadLocalDemo.local.get());
        };

        Runnable t2 = () -> {

            System.out.println(ThreadLocalDemo.local.get());

            ThreadLocalDemo.local.set("kobe-2");

            System.out.println(ThreadLocalDemo.local.get());
        };

        threadPoolExecutor.submit(t1);
        threadPoolExecutor.submit(t2);


        sleep();

        System.out.println(ThreadLocalDemo.local.get());


        Runnable t3 = () -> {

            System.out.println(ThreadLocalDemo.local.get());

            ThreadLocalDemo.local.set("kobe-3");

            System.out.println(ThreadLocalDemo.local.get());
        };

        Runnable t4 = () -> {

            System.out.println(ThreadLocalDemo.local.get());

            ThreadLocalDemo.local.set("kobe-4");

            System.out.println(ThreadLocalDemo.local.get());
        };

        threadPoolExecutor2.submit(t3);
        threadPoolExecutor2.submit(t4);

        sleep();

        System.out.println(ThreadLocalDemo.local.get());

        threadPoolExecutor.shutdown();
        threadPoolExecutor2.shutdown();

    }

    private static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}