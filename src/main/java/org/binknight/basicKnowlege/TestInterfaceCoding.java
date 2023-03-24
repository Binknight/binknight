package org.binknight.basicKnowlege;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestInterfaceCoding {

    public String provideO(Supplier<String> stringSupplier ){
        return stringSupplier.get();
    }

    public static void main(String[] args) {
        TestInterfaceCoding testInterfaceCoding = new TestInterfaceCoding();
        String s = testInterfaceCoding.provideO(() -> {
            return Stream.of("a,b,c,1,2,3").collect(Collectors.toList()).toString();});
        System.out.println(s);
    }
}




