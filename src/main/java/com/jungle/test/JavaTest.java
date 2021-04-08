package com.jungle.test;

//.java文件中 只有一个public（公开类）类
public class JavaTest {
    public static void main(String[] args) {
//        A a = new A(); //A
//        B b = new B(); //B

//        C c = new C(); //A C

        A a = new C(); //A C

    }
}

class A{
    static {
        System.out.println("A");
    }
}

class B{
    static {
        System.out.println("B");
    }
}

class C extends A{
    static {
        System.out.println("C");
    }
}