package com.cixin.EffectiveJava.Extendss;

/**
 * Created by cixinxc on 2017/4/24.
 */
public class Main {
    public static void main(String[] args) {
        Son s = new Son();
        //s.addAll();
        //s.add();
        Father f = new Father();
        //f.add();
        //f.addAll();
        Father ff = new Son();
        //ff.add();
        ff.addAll();
    }

}
