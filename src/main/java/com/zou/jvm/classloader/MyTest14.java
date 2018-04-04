package com.zou.jvm.classloader;

import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {

    public static void main(String[] args) throws Exception {

        //返回线程的上下文加载器
        //线程的创建者提供该加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        System.out.println(classLoader); //  sun.misc.Launcher$AppClassLoader@18b4aac2

        String resourcesName = "com/zou/jvm/classLoader/MyTest13.class";

        Enumeration<URL> urls = classLoader.getResources(resourcesName);

        while (urls.hasMoreElements()) {

            URL url = urls.nextElement();
            System.out.println(url);
        }
        // file:/Users/zoulvzhou/Documents/workspace/jvmTest/out/production/classes/com/zou/jvm/classLoader/MyTest13.class


    }

}




















































