package com.cixin.learning.Code.base.Abstract;

/**
 * Created by cixinxc on 2017/2/22.
 */
public class Father extends Person {
    public void abFunction() {
        System.out.println("Father�̳�Person��ʵ�����е�showMe");
    }
    public void showMe() {
        super.showMe();
        System.out.println(",and I am a Father.This function has been override!");
    }
}
