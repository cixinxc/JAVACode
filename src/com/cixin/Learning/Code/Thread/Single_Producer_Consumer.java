package com.cixin.Learning.Code.Thread;

import java.util.HashMap;

class Mutil_Producer implements Runnable
{
    private KaoYaResource r;
    Mutil_Producer(KaoYaResource r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.product("������Ѽ");
        }
    }
}
/**
 * @author zejian
 * @time 2016��3��12�� ����11:02:05
 * @decrition �������߳�
 */
class Mutil_Consumer implements Runnable
{
    private KaoYaResource r;
    Mutil_Consumer(KaoYaResource r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.consume();
        }
    }
}
public class Single_Producer_Consumer {

    public static void main(String[] args)
    {
        HashMap<String, String> hm;
        //hm.put("1", "1");
        KaoYaResource r = new KaoYaResource();
        Mutil_Producer pro = new Mutil_Producer(r);
        Mutil_Consumer con = new Mutil_Consumer(r);
        //�������߳�
        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        //�������߳�
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);
        //�����߳�
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
class KaoYaResource {

    private String name;
    private int count = 1;//��Ѽ�ĳ�ʼ����
    private boolean flag = false;//�ж��Ƿ�����Ҫ�̵߳ȴ��ı�־

    /**
     * ������Ѽ
     */
    public synchronized void product(String name){
        if(flag){
            //��ʱ�п�Ѽ���ȴ�
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace()
                ;
            }
        }
        this.name=name+count;//���ÿ�Ѽ������
        count++;
        System.out.println(Thread.currentThread().getName()+"...������..."+this.name);
        flag=true;//�п�Ѽ��ı��־
        this.notify();
        //notifyAll();//֪ͨ�����߳̿���������
    }

    /**
     * ���ѿ�Ѽ
     */
    public synchronized void consume(){
        if(!flag){//���û�п�Ѽ�͵ȴ�
            try{this.wait();}catch(InterruptedException e){}
        }
        System.out.println(Thread.currentThread().getName()+"...������........"+this.name);//���ѿ�Ѽ1
        flag = false;
        this.notify();
        //notifyAll();//֪ͨ������������Ѽ
    }
}
/**
 * @author zejian
 * @time 2016��3��12�� ����11:02:22
 * @decrition �������߳�
 */
class Producer implements Runnable
{
    private KaoYaResource r;
    Producer(KaoYaResource r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.product("������Ѽ");
        }
    }

}
/**
 * @author zejian
 * @time 2016��3��12�� ����11:02:05
 * @decrition �������߳�
 */
class Consumer implements Runnable
{
    private KaoYaResource r;
    Consumer(KaoYaResource r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.consume();
        }
    }
}
