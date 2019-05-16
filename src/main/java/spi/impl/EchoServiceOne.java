package spi.impl;

import spi.EchoService;

public class EchoServiceOne implements EchoService {
    @Override
    public void say() {
        System.out.println("It's one");
    }
}
