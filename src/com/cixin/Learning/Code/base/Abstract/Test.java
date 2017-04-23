package com.cixin.Learning.Code.base.Abstract;

/**
 * Created by cixinxc on 2017/2/22.
 */
public class Test {
    public static void main(String[] arg) {
        /*
        Person p = new Person();    //报错，抽象类不能直接实例化对象
        */
        Father father = new Father();
        father.abFunction();
        father.showMe();
        father.showUse();
    }
}
