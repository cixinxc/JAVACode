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
//        staticShow();       //ʵ�����������෽��
//        A.staticShow();     //ʵ������ͨ��   ��.  �����෽��
//        int a1 = pa;
//        int a2 = this.pa;
//        int a3 = this.psb;
//        show();             //
//        showb();            //
//        this.show();        //ʵ��������������
//        this.showb();       //ʵ��������������ʵ������

    }

    public void showb() {
        System.out.println("void show bbb");
    }

    public static void staticShow() {
        System.out.println("static void show");
//        //show();         //����
//        A a = new A();
//        a.showb();
//        //show();           //����
//        new A().showb();
//        //this.show();  //����
//        //this.staticShow();      //����
//        staticShowB();
//
//        int a1 = psb;
//        //int a2 = this.pa;     //����
//        //int a3 = this.psb;        //����
//        A.staticShow();
    }

    public static void staticShowB() {}


}
