package com.cixin.learning.Code.base.Inheritance;

/**
 * Created by cixinxc on 2017/2/22.
 */
public class Father extends Person{
    public Father() {
        System.out.println("Father�Ĺ��쿪ʼ,name��"+super.getName()+", Id is "+super.id);    //��������super���ʸ������Ժͷ���
    }
    public void showMe() {
        super.showMe();
        System.out.println("I am a father");
    }
}
