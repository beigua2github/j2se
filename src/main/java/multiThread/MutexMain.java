package multiThread;

import java.util.concurrent.TimeUnit;

public class MutexMain {
    private static Mutex mutex = new Mutex();
    private static volatile  int i = 0;
    public static void main(String[] args) {
       new Thread(() -> {
           while (i < 100){
               try {
                   mutex.lock();
                   i += 1;
                   System.out.println("t1: i= " + i);
               }finally {
                   mutex.unlock();
               }

               try {
                   TimeUnit.SECONDS.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }).start();

        new Thread(() -> {
            while (i < 100){
                try {
                    mutex.lock();
                    i += 1;
                    System.out.println("t2: i= " + i);
                }finally {
                    mutex.unlock();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("finally:i = " + i);
    }
}
