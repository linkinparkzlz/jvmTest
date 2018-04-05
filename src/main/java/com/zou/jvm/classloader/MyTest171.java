package com.zou.jvm.classloader;

public class MyTest171 {


    public static void main(String[] args) throws Exception {


        MyTest16 loader1 = new MyTest16("loader1");

        loader1.setPath("/Users/zoulvzhou/Desktop/");

        Class<?> clazz = loader1.loadClass("com.zou.jvm.classloader.MySample");

        Object object = clazz.newInstance();

        System.out.println("class: " + clazz.hashCode());


    }
}
