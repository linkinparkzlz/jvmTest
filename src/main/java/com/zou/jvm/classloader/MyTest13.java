package com.zou.jvm.classloader;

public class MyTest13 {

    public static void main(String[] args) {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);

        //在hostspot虚拟机中  使用null表示根类加载器
        while (null != classLoader) {

            classLoader = classLoader.getParent();

            System.out.println(classLoader);

        }
    }

}

/*
输出：

sun.misc.Launcher$AppClassLoader@18b4aac2   应用类加载器
sun.misc.Launcher$ExtClassLoader@60e53b93   扩展类加载器
null  根类加载器/启动类加载器

 */






































