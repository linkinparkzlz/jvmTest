package com.zou.jvm.classloader;

/**
 *
 * @author zlz
 * 当一个接口初始化时，并不要求其父接口都完成了初始化。
 * <p>
 * 只有在真正使用父接口的时候（如引用接口中所定义的常量时），才会初始化。
 */

public class MyTest5 {

    public static void main(String[] args) {

        System.out.println(MyChild5.B);
    }

}

interface MyParent5 {

    public static int A = 5;

}

interface MyChild5 extends MyParent5 {

    public static int B = 6;
}