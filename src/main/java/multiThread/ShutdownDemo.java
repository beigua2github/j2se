package multiThread;

import java.util.concurrent.TimeUnit;

public class ShutdownDemo {
    public static void main(String[] args) {
        Thread hook1 = new Thread(new ShutdownListener(),"Test1Thread");
        Thread hook2 = new Thread(new ShutdownListener(),"Test2Thread");
        Runtime.getRuntime().addShutdownHook(hook1);
        Runtime.getRuntime().addShutdownHook(hook2);

        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ShutdownListener implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is Game Over.");
    }
}