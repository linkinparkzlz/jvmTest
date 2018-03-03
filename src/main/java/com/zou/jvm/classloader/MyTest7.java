package com.zou.jvm.classloader;


/**
 * @author zlz
 */

public class MyTest7 {


    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("java.lang.String");

        //返回加载这个类的加载器
        //返回的是null,说明加载String这个类的是根类加载器。刻印查看Javadoc
        System.out.println(clazz.getClassLoader());


        //输出是 sun.misc.Launcher$AppClassLoader@18b4aac2  。系统内加载器/应用程序加载器
        Class<?> clazz2 = Class.forName("com.zou.jvm.classloader.Test");
        System.out.println(clazz2.getClassLoader());




    }


}

class Test {

}








































