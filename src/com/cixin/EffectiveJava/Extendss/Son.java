package com.cixin.EffectiveJava.Extendss;

/**
 * Created by cixinxc on 2017/4/24.
 */
public class Son extends Father{
    @Override
    public void add() {
        super.add();
        System.out.println("son's add()");
    }
    @Override
    public void addAll() {
        super.addAll();
        System.out.println("son's addAll()");
        this.add();
    }
}
