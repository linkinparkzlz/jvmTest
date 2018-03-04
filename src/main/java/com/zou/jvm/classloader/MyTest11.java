package com.zou.jvm.classloader;


class Parent3 {

    static int a = 3;

    static {
        System.out.println("Parent3  static  block");

    }

    static void doSomething() {
        System.out.println("do something");
    }

}

class Child3 extends Parent3 {

    static {
        System.out.println("Child3  static block");
    }
}

/**
 * @author zlz
 */
public class MyTest11 {


    public static void main(String[] args) {

        System.out.println(Child3.a);

        System.out.println("--------------");

        Child3.doSomething();
    }

}
/*

输出：
Parent3  static  block
3
--------------
do something

结论：
对于使用子类的类名去调用父类的静态变量，表示的是对父类的主动使用，
而不是对子类的主动使用

 */








































