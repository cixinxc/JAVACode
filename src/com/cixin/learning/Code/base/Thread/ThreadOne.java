package com.cixin.learning.Code.base.Thread;

/**
 * Created by cixinxc on 2017/2/23.
 */
public class ThreadOne extends Thread {
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
        System.out.println("run���оֲ�����i��ȫ�ֱ���j��������ThreadOne");
        while(flag) {
            System.out.println("������ThreadOne   ͨ�� �̳�Thread �� ��дrun() ��ʵ��.   "+"������i "+(i++)+" ��   "+"������j "+(j++)+" ��");
        }
    }

}
