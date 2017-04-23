package com.cixin.EffectiveJava.Singleton;

/**
 * Created by cixinxc on 2017/4/19.
 */
public enum EnumSingleton {
    enumSingleton("1");
    private String id;
    private EnumSingleton(String id) {
        this.id = id;
    }
}
