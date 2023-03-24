package org.binknight.basicKnowlege;

public abstract class TestAbstractObject implements TestInterface{

    public static  int x = 10;
    private static int y = 11;

    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
