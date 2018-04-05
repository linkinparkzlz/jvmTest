package com.zou.jvm.classloader;

public class MyTest18_1 {

    public static void main(String[] args) throws Exception {


        MyTest16 loader1 = new MyTest16("loader1");

        loader1.setPath("/Users/zoulvzhou/Desktop/");

        Class<?> clazz = loader1.loadClass("com.zou.jvm.classloader.MyTest1");

        System.out.println("class: " + clazz.hashCode());

        System.out.println("class loader: " + clazz.getClassLoader());
        /**
         * 应用程序加载器进行加载
         * class: 1580066828
           class loader: sun.misc.Launcher$AppClassLoader@18b4aac2
         */





    }


}
