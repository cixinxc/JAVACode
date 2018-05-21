package com.cixin.learning.Code.base.Thread;

/**
 * Created by cixinxc on 2017/2/23.
 */
public class ThreadTwo implements Runnable {
    private boolean flag = true;

    public boolean getFlag() {
        return this.flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public void run() {
        System.out.println("通过实现 Runnable接口中的run() 实现");
    }
}
