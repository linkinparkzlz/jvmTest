package com.zou.jvm.classloader;


import java.lang.reflect.Method;

public class MyTest20 {

    public static void main(String[] args) throws Exception {

        MyTest16 loader1 = new MyTest16("loader1");

        MyTest16 loader2 = new MyTest16("loader2");

        Class<?> clazz1 = loader1.loadClass("com.zou.jvm.classloader.MyPerson");

        Class<?> clazz2 = loader2.loadClass("com.zou.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2);  // true

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        /*
        类相同并且加载类的加载器相同，才是完全一样的类。
         */

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);

    }
}


























