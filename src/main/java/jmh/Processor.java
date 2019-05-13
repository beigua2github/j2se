package jmh;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Processor {

    public static ThreadPoolExecutor EXECUTOR;

    static {
        if(EXECUTOR == null){
            synchronized (RedisTest.class){
                EXECUTOR = new ThreadPoolExecutor(
                        10,20,0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue(),
                        new ThreadFactoryBuilder().setNameFormat("UpdateRedis-%s").build(),
                        new ThreadPoolExecutor.CallerRunsPolicy()
                );
            }
        }
    }
}
