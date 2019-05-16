package spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * https://docs.oracle.com/javase/1.5.0/docs/guide/jar/jar.html#Service%20Provider
 *
 * @author kobe
 */
public class Main {
    public static void main(String[] args) {
//        Iterator<EchoService> providers = Service.providers(EchoService.class);
        Iterator<EchoService> providers = ServiceLoader.load(EchoService.class).iterator();


        while (providers.hasNext()) {
            providers.next().say();
        }
    }
}
