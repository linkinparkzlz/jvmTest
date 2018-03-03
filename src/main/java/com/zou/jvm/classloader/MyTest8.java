package com.zou.jvm.classloader;


class FinalTest {

    public static final int X = 3;

    static {
        System.out.println("FinalTest   static block");
    }
}

/**
 *@author zlz
 */
public class MyTest8 {


    public static void main(String[] args) {
        System.out.println(FinalTest.X);
    }

}


/*
加上final，静态代码块不执行
输出 3

去掉final  静态代码块执行
输出
FinalTest   static block
3



原因在于，final是一个编译时的常量，编译之后这个常量就会放在MyTest8的常量池中。
也就是在编译之后，就不需要FinalTest文件了，其也就不会被初始化，静态代码块也就不会被执行。

 */































