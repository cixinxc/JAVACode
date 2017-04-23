package com.cixin.Learning.Code.base.Polymorphism;

/**
 * Created by cixinxc on 2017/2/22.
 */
public class Test {
    public static void main(String[] arg) {
        //引用多态:一般父类的引用可以指向本类的对象。
        Person person = new Person();
        Person father = new Father();
        Person mother = new Mother();

        person.showMe();    //父类不能调用子类方法
        father.showMe();    //子类调用重写父类中的方法
        mother.showMe();    //子类调用从父类继承的方法

        //引用类型转换
        //从高到低由计算机自动完成:隐式转换
        //从低到高有溢出风险，需要手动强制转换
        Father f = new Father();
        Person p = f;                   //由高到低
        Mother m1 = (Mother)person;     //从低到高
        //Mother m2 = (Mother)p;          //从低到高,编译器没问题,但这里运行会出现问题
        //Mother m3 = (Mother)father;   //编译器没问题,但这里运行会出现问题
        //Mother m4 = (Mother)f;          //编译器报错
    }
}
