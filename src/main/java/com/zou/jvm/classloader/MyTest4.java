package com.zou.jvm.classloader;


/**
 * @author zlz
 *
 * 对于数组实例来说，其类型是由JVM运行期间动态生成的，表示为： class [Lcom.zou.jvm.classloader.MyParent4
 * 动态生成的类型，其父类型就是Object。
 * 对于数组来说，Javadoc经常将构成数组的元素为Compoent，实际上就是一个数组降低一个维度。
 *
 *反编译：javap  -c
 *
 * 助记符：
 * anewarray ：表示创建一个引用类型的（如类，接口，数组）数组，并将其引用值压入栈顶。
 *
 * newarray： 表示创建一个指定的原生类型（如 int,float,char）的数组，并将其引用值压入栈顶。
 *
 */
public class MyTest4 {

    public static void main(String[] args) {

        //输出  MyParent4  static  block
       // MyParent4 myParent4 = new MyParent4();

        //无输出
        MyParent4[] myParent4s =new MyParent4[1];

        //  class [Lcom.zou.jvm.classloader.MyParent4  . Java虚拟机在运行时生成.
        System.out.println(myParent4s.getClass());

        //二维数组
        MyParent4[][]  myParent4s1 = new MyParent4[1][1];

        //  class [[Lcom.zou.jvm.classloader.MyParent4;
        System.out.println(myParent4s1.getClass());

        System.out.println("*******************");

        //class [I
        int[]  ints = new int[1];
        System.out.println(ints.getClass());
        // class java.lang.Object
        System.out.println(ints.getClass().getSuperclass());
    }

}

class MyParent4 {

    static {
        System.out.println("MyParent4  static  block");
    }
}
