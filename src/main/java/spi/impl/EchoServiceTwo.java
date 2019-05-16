package spi.impl;

import spi.EchoService;

public class EchoServiceTwo implements EchoService {
    @Override
    public void say() {
        System.out.println("It's two");
    }
}
