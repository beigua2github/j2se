package jmh;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class RedisHanlder implements Runnable{
    @Setter
    @Getter
    Map<String,String> distinctMap;

    public RedisHanlder(Map<String, String> distinctMap) {
        this.distinctMap = distinctMap;
    }

    @Override
    public void run() {
        Map<String, String> distinctMap = this.getDistinctMap();
        System.out.println("distinctMap.size:"+  distinctMap.keySet().size());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
