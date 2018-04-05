package com.zou.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * 扩展类加载器应用
 */
public class MyTest19 {


    public static void main(String[] args) {


        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        //扩展类加载器加载
        System.out.println(aesKeyGenerator.getClass().getClassLoader());

        //应用类加载器加载
        System.out.println(MyTest19.class.getClassLoader());

        /**
         * sun.misc.Launcher$ExtClassLoader@d716361
         sun.misc.Launcher$AppClassLoader@18b4aac2
         */


    }


}




























