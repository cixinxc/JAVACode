package com.cixin.Learning.Code.Exception;

/**
 * Created by cixinxc on 2017/5/18.
 */
class Ext{

    Ext() {}
    Ext(int i){}

    public int t1;
    protected int t2;
    int t3;
    private int t4;

    static public int tt1;
    static protected int tt2;
    static int tt3;
    static private int tt4;

    public void t1() {}
    protected void t2(){}
    void t3(){}
    private void t4(){}
}
class ExTest2 extends Ext{
    ExTest2() {
        //super();
        super(1);
        t1 = 1;
        t2 = 2;
        t3 = 3;
        //t4 = 5;
    }
    public int t1 = 1;
    public static int  t1t = 1;

    public void t1() {
        t2 = 2;
        super.t1();
    }
}
public class ExTest extends Ext{
    public static void main(String[] args) {
        try {
            test1();
        } catch (Exception e) {
            System.out.println("³ý0´íÎó");
        }
        System.out.println("¸ò¸ò");
        //System.out.println(1/0);
        B b = new B();
        A a = b;
        a.a();
    }
    public void aa() {
        t1 = 1;
    }
    public static void test1() throws Exception {
        tt1 = 1;tt2 = 1;tt3 = 1;//tt4 = 1;

        ExTest2 et2 = new ExTest2();

        System.out.print(1/1);
    }
}

class A {
    public void a() {
        System.out.println("A");
    }

}
class B extends A {
    public void a() {
        System.out.println("B");
    }
}
