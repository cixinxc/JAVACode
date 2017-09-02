package com.cixin.EffectiveJava.Extendss;

/**
 * Created by cixinxc on 2017/4/24.
 */
public class Father {
    public void add() {
        System.out.println("father's add()");
    }
    public void addAll() {
        System.out.println("father's allAll()");
        this.add();
        System.out.println("");
    }
}
