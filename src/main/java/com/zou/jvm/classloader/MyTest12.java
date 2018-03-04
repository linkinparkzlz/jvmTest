package com.zou.jvm.classloader;


class CL {

    static {

        System.out.println("Class  Cl");
    }
}

/**
 * @author zlz
 * <p>
 * 反射导致类的初始化
 */

public class MyTest12 {

    public static void main(String[] args) throws Exception {

        //获取系统类加载器（应用类加载器）
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        //这行代码的执行，不会导致CL类的初始化。
        //调用ClassLoader的loadCalss()方法，并不是对类的主动调用，不会导致类的初始化。
        Class<?> clazz = loader.loadClass("com.zou.jvm.classloader.CL");

        System.out.println(clazz);


        System.out.println("--------");

        //导致类CL的初始化
        clazz = Class.forName("com.zou.jvm.classloader.CL");

        System.out.println(clazz);

    }

}


/*
删除：
class com.zou.jvm.classloader.CL
--------
Class  Cl
class com.zou.jvm.classloader.CL



 */




























































