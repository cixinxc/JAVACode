package com.cixin.DesignPatterns.Singleton;

/**
 * Created by cixinxc on 2017/2/27.
 */
public class SingletonInner {
    private static class Holder {
        private static SingletonInner singleton = new SingletonInner();
    }
    private SingletonInner(){
    }
    public static SingletonInner getSingletonInner(){
        return Holder.singleton;
    }
}