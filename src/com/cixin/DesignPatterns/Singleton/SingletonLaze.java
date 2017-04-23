package com.cixin.DesignPatterns.Singleton;

/**
 * Created by cixinxc on 2017/2/26.
 */
public final class SingletonLaze {
    private static SingletonLaze sl = null;
    private SingletonLaze() {}
    //静态工厂方法    线程不安全
    public static SingletonLaze getInstance() {
        if (sl == null) {
            sl = new SingletonLaze();
        }
        return sl;
    }

    // 同步方法，性能不高
    public static synchronized SingletonLaze getSingletonLazeOne() {
        if(sl == null) {
            sl = new SingletonLaze();
        }
        return sl;
    }
    // 同步块。但是有错误

    /**
     * 两个进程，S1和S2，S1运行到1判断为null，继续运行，然后假使处理器转到S2运行S2也判断为null
     * 处理器转到S1运行，继续运行3，然后转S2，运行3，俩线程成功创建不同的实例
     * @return
     */
    public static SingletonLaze getSingletonLazeError() {
        if(sl == null) {                            //1
            synchronized(SingletonLaze.class) {     //2
                sl = new SingletonLaze();           //3
            }
        }
        return sl;
    }
    // 同步块，但是由于Java平台内存模型的问题，并不能实现要求。
    // 线程1运行1-4，但在调用构造方法前，被设置为非空，此时轮到线程2执行getSingletonLazeTwo()，于是线程2直接返回sl
    /*
    mem = allocate();             //Allocate memory for Singleton object.
    instance = mem;               //Note that instance is now non-null, but has not been initialized.
    ctorSingleton(instance);      //Invoke constructor for Singleton passing instance.
    */
    public static SingletonLaze getSingletonLazeTwo() {
        if(sl == null) {                            //1
            synchronized(SingletonLaze.class) {     //2
                if(sl == null) {                    //3
                    sl = new SingletonLaze();       //4
                }
            }
        }
        return sl;
    }
}
