package com.cixin.DesignPatterns.Singleton;

/**
 * Created by cixinxc on 2017/2/26.
 */
public final class SingletonLaze {
    private static SingletonLaze sl = null;
    private SingletonLaze() {}
    //��̬��������    �̲߳���ȫ
    public static SingletonLaze getInstance() {
        if (sl == null) {
            sl = new SingletonLaze();
        }
        return sl;
    }

    // ͬ�����������ܲ���
    public static synchronized SingletonLaze getSingletonLazeOne() {
        if(sl == null) {
            sl = new SingletonLaze();
        }
        return sl;
    }
    // ͬ���顣�����д���

    /**
     * �������̣�S1��S2��S1���е�1�ж�Ϊnull���������У�Ȼ���ʹ������ת��S2����S2Ҳ�ж�Ϊnull
     * ������ת��S1���У���������3��Ȼ��תS2������3�����̳߳ɹ�������ͬ��ʵ��
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
    // ͬ���飬��������Javaƽ̨�ڴ�ģ�͵����⣬������ʵ��Ҫ��
    // �߳�1����1-4�����ڵ��ù��췽��ǰ��������Ϊ�ǿգ���ʱ�ֵ��߳�2ִ��getSingletonLazeTwo()�������߳�2ֱ�ӷ���sl
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
