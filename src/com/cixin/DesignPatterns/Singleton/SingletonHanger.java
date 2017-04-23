package com.cixin.DesignPatterns.Singleton;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * Created by cixinxc on 2017/2/25.
 * ¶öººµ¥ÀýÄ£Ê½
 */
public class SingletonHanger {
    private static SingletonHanger single = new SingletonHanger();
    private SingletonHanger() { System.out.println("father"); }
    public static SingletonHanger getSingletonHanger() {
        return single;
    }
}
