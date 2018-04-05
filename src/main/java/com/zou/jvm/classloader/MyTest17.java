package com.zou.jvm.classloader;

public class MyTest17 {


    public static void main(String[] args) throws Exception {


        MyTest16 loader1 = new MyTest16("loader1");

        Class<?> clazz = loader1.loadClass("com.zou.jvm.classloader.MySample");

        System.out.println("class: " + clazz.hashCode());

        /*
        如果注释掉该行，那就不会实例化MySample对象，即MySample构造方法不会被调用。
        因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat  Class。
         */
        Object object = clazz.newInstance();

        /**
         * 输出
         * class: 1580066828
         MySample is loaded by :sun.misc.Launcher$AppClassLoader@18b4aac2
         MyCat  is  loaded by :sun.misc.Launcher$AppClassLoader@18b4aac2
         */


    }
}







































