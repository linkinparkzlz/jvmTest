package com.zou.jvm.classloader;


/**
 * 对于静态字段来说，只有直接定义该字段的类才会被初始化。
 *
 * 当一个类在初始化时，要求其全部父类都已经初始化完毕。
 *
 * -XX:+TraceClassLoading，用于追踪类的加载信息并打印出来。
 *
 * -XX:+<option>,表示开启option选项
 * -XX:-<option> ,表示关闭option选项
 *
 * -XX:<option>=<value>，表示将option选项值设置为value
 *
 */


public class MyTest1 {

    public static void main(String[] args) {
        System.out.println(MyChild1.str);
    }

}

class MyParent1 {

    public static String str = "hello  world";

    static {
        System.out.println("MyParent  static  bloock");
    }
}


class MyChild1 extends MyParent1 {

    //public static String str2 = "world";  去掉注释，上面改为str2会有什么现象

    static {

        System.out.println("MyChild  static  child");
    }

}






























