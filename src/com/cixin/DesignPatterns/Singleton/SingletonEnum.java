package com.cixin.DesignPatterns.Singleton;

/**
 * Created by cixinxc on 2017/2/26.
 */

public enum SingletonEnum
{
    INSTANCE;
    private static String es;
    private SingletonEnum() {}
    public void setEs(String es)
    {
        this.es = es;
    }
    public String getEs() {
        return this.es;
    }
}
