package com.cixin.learning.Code.base.Thread;

/**
 * Created by cixinxc on 2017/2/23.
 */
public class ThreadOne2 extends Thread {
    private boolean flag = true;
    private int j = 0;
    public boolean getFlag() {
        return this.flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public void run() {
        int i = 0;
        System.out.println("run中有局部变量i和全局变量j，但这是ThreadOne2");
        while(flag) {
            System.out.println("但这是ThreadOne2  通过 继承Thread 并 重写run() 来实现.   "+"运行了i "+(i++)+" 次   "+"运行了j "+(j++)+" 次");
        }
    }
}
