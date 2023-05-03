package org.binknight.dcl;

public class DoubleCheckLockTest {

    public static volatile DoubleCheckLockTest singleton = null;

    private DoubleCheckLockTest() {
        if(null != singleton){
            throw new RuntimeException("singleton is already existing!");
        }
    }

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
