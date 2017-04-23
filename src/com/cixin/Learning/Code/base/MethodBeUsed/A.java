package com.cixin.Learning.Code.base.MethodBeUsed;

/**
 * Created by cixinxc on 2017/3/2.
 */
public class A {
    public int pa = 1;
    public static int psb = 2;

    public void show() {
        System.out.println("void show aaaa");
//
//        staticShow();       //实例方法调用类方法
//        A.staticShow();     //实例方法通过   类.  调用类方法
//        int a1 = pa;
//        int a2 = this.pa;
//        int a3 = this.psb;
//        show();             //
//        showb();            //
//        this.show();        //实例方法调用自身
//        this.showb();       //实例方法调用其他实例方法

    }

    public void showb() {
        System.out.println("void show bbb");
    }

    public static void staticShow() {
        System.out.println("static void show");
//        //show();         //不行
//        A a = new A();
//        a.showb();
//        //show();           //不行
//        new A().showb();
//        //this.show();  //不行
//        //this.staticShow();      //不行
//        staticShowB();
//
//        int a1 = psb;
//        //int a2 = this.pa;     //不行
//        //int a3 = this.psb;        //不行
//        A.staticShow();
    }

    public static void staticShowB() {}


}
