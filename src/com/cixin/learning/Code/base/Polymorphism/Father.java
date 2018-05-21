package com.cixin.learning.Code.base.Polymorphism;

/**
 * Created by cixinxc on 2017/2/22.
 */
public class Father extends Person {
    public Father() {
        System.out.println("Father的构造开始,name是"+super.getName()+", Id is "+super.id);    //子类中用super访问父类属性和方法
    }
    public void showMe() {
        super.showMe();
        System.out.print(",And I am a father");
    }
}
