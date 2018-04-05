package com.zou.jvm.classloader;

import java.io.*;

/**
 * 自定义的类加载器
 */

public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtendsion = ".class";

    private String path; //加载路径

    public MyTest16(String classLoaderName) {

        super(); //将系统类加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);// 显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }


    /**
     * 重要的方法
     *
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {

        System.out.println("findClass invoked: " + className);

        System.out.println("class  loader name: " + this.classLoaderName);


        byte[] data = this.loadClassData(className);

        return this.defineClass(className, data, 0, data.length);


    }

    private byte[] loadClassData(String className) {

        InputStream inputStream = null;
        byte[] data = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        //从指定的位置加载
        className = classLoaderName.replace(".", "/");

        try {

            inputStream = new FileInputStream(new File(this.path + className + this.fileExtendsion));

            byteArrayOutputStream = new ByteArrayOutputStream();

            int ch = 0;

            while (-1 != (ch = inputStream.read())) {

                byteArrayOutputStream.write(ch);


            }
            data = byteArrayOutputStream.toByteArray();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                inputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return data;

    }

    public void setPath(String path) {
        this.path = path;
    }


    public static void main(String[] args) throws Exception {

        MyTest16 loader1 = new MyTest16("loader1");

       // loader1.setPath("/Users/zoulvzhou/Documents/workspace/jvmTest/out/production/classes/");

        loader1.setPath("/Users/zoulvzhou/Desktop/");


        Class<?> clazz = loader1.loadClass("com.zou.jvm.classloader.MyTest1");

        System.out.println("class: " + clazz.hashCode());

        Object object = clazz.newInstance();

        System.out.println(object);

        System.out.println(object.getClass().getClassLoader());

        /*
        1输出：
        class: 1625635731
        com.zou.jvm.classloader.MyTest1@5e2de80c
        sun.misc.Launcher$AppClassLoader@18b4aac2

        2输出
        findClass invoked: com.zou.jvm.classloader.MyTest1
        class  loader name: loader1

         */


        System.out.println("-------------------");


        MyTest16 loader2 = new MyTest16("loader2");

        // loader1.setPath("/Users/zoulvzhou/Documents/workspace/jvmTest/out/production/classes/");

        loader1.setPath("/Users/zoulvzhou/Desktop/");


        Class<?> clazz2 = loader1.loadClass("com.zou.jvm.classloader.MyTest1");

        System.out.println("class: " + clazz2.hashCode());

        Object object2 = clazz.newInstance();

        System.out.println(object2);

        /*

           输出：
           class: 1625635731
            com.zou.jvm.classloader.MyTest1@1d44bcfa
         */


        System.out.println("--------------------");

        MyTest16 loader3 = new MyTest16(loader2,"loader2");

        // loader1.setPath("/Users/zoulvzhou/Documents/workspace/jvmTest/out/production/classes/");

        loader3.setPath("/Users/zoulvzhou/Desktop/");


        Class<?> clazz3 = loader1.loadClass("com.zou.jvm.classloader.MyTest1");

        System.out.println("class: " + clazz3.hashCode());

        Object object3 = clazz.newInstance();

        System.out.println(object3);





    }

}














































