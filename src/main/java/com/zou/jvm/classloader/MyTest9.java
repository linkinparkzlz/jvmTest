package com.zou.jvm.classloader;

class Parent {
    static int a = 3;

    static {
        System.out.println("parent  static  block");
    }
}


class Child extends Parent {
    static int b = 4;

    static {
        System.out.println("child static block");
    }
}

/**
 *
 * @author zlz
 */

public class MyTest9 {

    static {
        System.out.println("MyTest9  static  block");
    }

    public static void main(String[] args) {

        System.out.println(Child.b);

    }


}


/*

输出结果：

MyTest9  static  block
parent  static  block
child static block
4


 */







































