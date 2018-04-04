package com.zou.jvm.classloader;

/*

 * <p> <tt>Class</tt> objects for array classes are not created by class
 * loaders, but are created automatically as required by the Java runtime.
 * The class loader for an array class, as returned by {@link
 * Class#getClassLoader()} is the same as the class loader for its element
 * type; if the element type is a primitive type, then the array class has no
 * class loader.

数组对应的Class对象不是由类加载器加载的，而是由JVM在运行期动态创建出来的.


 */
public class MyTest15 {

    public static void main(String[] args) {

        String[] strings = new String[2];

        System.out.println(strings.getClass().getClassLoader());   //  输出 null

        System.out.println("-------------");

        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b4aac2

        /*

        myTest15是自己定义的类。
         */

        System.out.println("---------------");

        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader()); // 输出null   数组里面的类型是原生数据类型  则其没有类加载器
        //  if the element type is a primitive type, then the array class has no class loader.


    }
}













































