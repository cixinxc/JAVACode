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
            r.product("北京烤鸭");
        }
    }
}
/**
 * @author zejian
 * @time 2016年3月12日 下午11:02:05
 * @decrition 消费者线程
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
        //生产者线程
        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        //消费者线程
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);
        //启动线程
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
class KaoYaResource {

    private String name;
    private int count = 1;//烤鸭的初始数量
    private boolean flag = false;//判断是否有需要线程等待的标志

    /**
     * 生产烤鸭
     */
    public synchronized void product(String name){
        if(flag){
            //此时有烤鸭，等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace()
                ;
            }
        }
        this.name=name+count;//设置烤鸭的名称
        count++;
        System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
        flag=true;//有烤鸭后改变标志
        this.notify();
        //notifyAll();//通知消费线程可以消费了
    }

    /**
     * 消费烤鸭
     */
    public synchronized void consume(){
        if(!flag){//如果没有烤鸭就等待
            try{this.wait();}catch(InterruptedException e){}
        }
        System.out.println(Thread.currentThread().getName()+"...消费者........"+this.name);//消费烤鸭1
        flag = false;
        this.notify();
        //notifyAll();//通知生产者生产烤鸭
    }
}
/**
 * @author zejian
 * @time 2016年3月12日 下午11:02:22
 * @decrition 生产者线程
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
            r.product("北京烤鸭");
        }
    }

}
/**
 * @author zejian
 * @time 2016年3月12日 下午11:02:05
 * @decrition 消费者线程
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
