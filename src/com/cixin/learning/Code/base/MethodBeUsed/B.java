package com.cixin.learning.Code.base.MethodBeUsed;

/**
 * Created by cixinxc on 2017/3/2.
 */
public class B extends A{

    int a =  A.psb;
    static int b =  A.psb;
    int c = super.pa;
    //static int d = super.pa;  //������
    public void showb() {
        //super.show();     //����
        super.showb();      //��
        show();
        //this.showb();
        //super.showb();
        int a = A.psb;
        int b = (new A()).pa;
        int c = new A().pa;
        A.staticShow();
        A.staticShowB();
        staticShow();
        staticShowB();
    }
    public static void showC() {
        //this.showb();     //������
        //super.showb();    //������
        A.staticShow();
        A.staticShowB();
        new A().show();
        int c = A.psb;
    }
}
