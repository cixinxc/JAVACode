package com.cixin.Learning.Code.base.Abstract;

/**
 * Created by cixinxc on 2017/2/22.
 */
public class Test {
    public static void main(String[] arg) {
        /*
        Person p = new Person();    //���������಻��ֱ��ʵ��������
        */
        Father father = new Father();
        father.abFunction();
        father.showMe();
        father.showUse();
    }
}
