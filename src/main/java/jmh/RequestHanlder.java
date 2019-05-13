package jmh;

import java.util.concurrent.Semaphore;

public class RequestHanlder implements Runnable {
    private Semaphore semaphore;

    public RequestHanlder(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();


            Request requestObj = new Request();
            for (int j = 0; j < 100000; j++) {
                String key = j + "";
                requestObj.getDistinctMap().put(key, "1");
            }

            Processor.EXECUTOR.execute(new RedisHanlder(requestObj.getDistinctMap()));
        } catch (RuntimeException r) {


        } catch (InterruptedException e) {
            System.out.println("并发了");
        } finally {
            semaphore.release(1);
        }
    }
}
