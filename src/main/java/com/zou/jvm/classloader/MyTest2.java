package com.zou.jvm.classloader;



public class MyTest2 {

    public static void main(String[] args) {
        System.out.println(MyParent2.str);
    }
}

class MyParent2 {

    /**
     * 加上final，常量，在编译时就会将其存入调用这个常量的方法所在的类中的常量池。
     *
     * 本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化。
     *
     * 注意：这里指的是将常量存放到了MyTest2的常量池中，之后MyTest2与Parent2就没有任何关系了。
     *
     *
     * 助记符：
     * ldc 表示将int  ,float或是String类型的常量值从常量池推送至栈顶。
     *
     * bipush表示将单字节（-128 - 127）的常量值推送至栈顶
     *
     *
     * sipush表示将一个短整型常量值(-32768 - 32767) 推送至栈顶
     *
     * iconst_1 表示将int类型1推送至栈顶.(iconst_1  -  iconst_5)
     *
     *
     */

    public static final String str = "hello world";

    static {
        System.out.println("MyParet2  static  block");
    }
}


//输出：  hello world

//反编译：

//
//    Compiled from "MyTest2.java"
//public class com.zou.jvm.classloader.MyTest2 {
//public com.zou.jvm.classloader.MyTest2();
//        Code:
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//
//public static void main(java.lang.String[]);
//        Code:
//        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
//        3: ldc           #4                  // String hello world
//        5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//        8: return
//        }













































