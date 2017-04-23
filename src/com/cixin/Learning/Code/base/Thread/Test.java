package com.cixin.Learning.Code.base.Thread;

/**
 * Created by cixinxc on 2017/2/23.
 */
public class Test {
    public static void main(String[] arg) {
        ThreadOne t1 = new ThreadOne();            //通过继承Thread，实现run()
        ThreadOne2 t12 = new ThreadOne2();            //通过继承Thread，实现run()
        Thread t2 = new Thread(new ThreadTwo());//通过实现接口Runnable,实现run()
        Thread t31 = new Thread(new ThreadThree("One"));
        Thread t32 = new Thread(new ThreadThree("Two"));

        ThreadThree three = new ThreadThree();
        Thread t321 = new Thread(three);
        Thread t322 = new Thread(three);
        /*
        //Test1
        //多个线程在没有约束时，我们看到的进程间的调度/运行没有规律，进程交叉运行。
        t1.start();
        t12.start();
        t2.start();
        for(int i = 0;i<10000;i++) {
            for(int j = 0;j<10000;j++) {
                for(int k = 0;k<1;k++) {
                    ;
                }
            }
        }
        t1.setFlag(false);
        t12.setFlag(false);
        */
        /*
        t31.start();
        t32.start();
        */
        t321.start();
        t322.start();
    }
}
