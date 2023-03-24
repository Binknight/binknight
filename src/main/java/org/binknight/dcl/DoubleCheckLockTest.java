package org.binknight.dcl;

public class DoubleCheckLockTest {

    public static volatile DoubleCheckLockTest singleton = null;

    private DoubleCheckLockTest() {}

    public static DoubleCheckLockTest getInstance(){
        // check 1
        if (null==singleton){
            synchronized (DoubleCheckLockTest.class){
                if (null ==singleton){
                    singleton = new DoubleCheckLockTest();
                }
            }
        }
        return singleton;
    }
}
