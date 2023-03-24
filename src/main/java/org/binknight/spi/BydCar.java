package org.binknight.spi;

public class BydCar implements Car{
    @Override
    public void run() {
        System.out.println("BYD running...");
    }
}
