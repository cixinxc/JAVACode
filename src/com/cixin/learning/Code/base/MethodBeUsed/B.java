package com.cixin.learning.Code.base.MethodBeUsed;

/**
 * Created by cixinxc on 2017/3/2.
 */
public class B extends A{

    int a =  A.psb;
    static int b =  A.psb;
    int c = super.pa;
    //static int d = super.pa;  //不可以
    public void showb() {
        //super.show();     //可以
        super.showb();      //可
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
        //this.showb();     //不可以
        //super.showb();    //不可以
        A.staticShow();
        A.staticShowB();
        new A().show();
        int c = A.psb;
    }
}
