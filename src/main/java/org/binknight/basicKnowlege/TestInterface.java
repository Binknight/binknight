package org.binknight.basicKnowlege;


public interface TestInterface {

    public static  int x = 10;
    // interface not allow private
    //private static int y = 11;

    // 接口只能有一个默认方法实现
    default void test(){
        System.out.println("test interface");
    }


    public int add(int a, int b);

    // 接口可以有多个静态方法实现，省去工具类的创建
    public static void add2(int a, int b){
        System.out.println("add2");
    };

    public static void add3(int a, int b){
        System.out.println("add2");
    };


}
