package com.zou.jvm.classloader;

import java.io.*;

/**
 * 自定义的类加载器
 */

public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtendsion = ".class";

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


        byte[] data = this.loadClassData(className);

        return this.defineClass(className, data, 0, data.length);


    }

    private byte[] loadClassData(String name) {

        InputStream inputStream = null;
        byte[] data = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {

            this.classLoaderName = this.classLoaderName.replace(".", "/");

            inputStream = new FileInputStream(new File(name + this.fileExtendsion));

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


    public static void test(ClassLoader classLoader) throws Exception {

        Class<?> clazz = classLoader.loadClass("com.zou.jvm.classloader.MyTest1");

        Object object = clazz.newInstance();

        System.out.println(object);

    }


    public static void main(String[] args) throws Exception {

        MyTest16 loader1 = new MyTest16("loader1");
        test(loader1);

        //  输出  com.zou.jvm.classloader.MyTest1@60e53b93
    }

}














































