package jmh;

import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * redis
 *
 * @author zhanglinmin
 */
@Slf4j
public class RedisTest{

    public static void main(String[] args) throws InterruptedException {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("pid:" + name);

        Semaphore semaphore = new Semaphore(10);
        Thread.sleep(5000);

        int count = 0;
        while (count < 2000) {
            new Thread(new RequestHandler(semaphore)).start();
            System.out.println("开始了" + ++count +"线程");
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }
}