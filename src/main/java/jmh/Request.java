package jmh;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class Request{

    Map<String,String> distinctMap = new ConcurrentHashMap<>(100000);

}
