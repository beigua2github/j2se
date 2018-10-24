package multiThread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinDemo {
    public static void main(String[] args) {
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void join() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.info("running");
            System.out.println("running");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }) ;
        Thread t2 = new Thread(() -> {
            log.info("running2");
            System.out.println("running2");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }) ;

        t1.start();
        t2.start();

        //等待线程1终止
        t1.join();

        //等待线程2终止
        t2.join();

        System.out.println("main over");
    }
}
