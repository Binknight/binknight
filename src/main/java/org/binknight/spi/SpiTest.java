package org.binknight.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<Car> load = ServiceLoader.load(Car.class);
        Iterator<Car> iterator = load.iterator();
        while(iterator.hasNext()){
            iterator.next().run();
        }
    }
}
