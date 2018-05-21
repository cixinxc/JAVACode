package com.cixin.learning.Code.base.Thread;

/**
 * Created by cixinxc on 2017/2/23.
 */
public class ThreadThree implements Runnable {
    private boolean flag = true;
    private String name;
    private int j = 0;
    private static int k = 0;
    public ThreadThree() {
    }
    public ThreadThree(String name) {
        this.name = name;
    }
    public boolean getFlag() {
        return this.flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public void run() {
        System.out.println("run中有局部变量i和成员变量j，但这是ThreadThree");
        for(int i = 0;j<50;i++,k++) {
            try
            {
                Thread.sleep((long) Math.random() * 1000);
                //Thread.sleep((long)( Math.random() * 1000 ) );
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(this.name+"\ti的值:"+i+"\tj的值:"+(j++)+"\tk的值:"+k);
        }
    }

}
