package com.cixin.Learning.Code.base.Abstract;

/**
 * Created by cixinxc on 2017/2/22.
 */
//抽象类，只是知道要包含哪些方法，但真不知准确的实现细节
//用来约束子类，以抽象类为模板，降低子类设计的随意性
//abstract修饰抽象类
public abstract class Person {

    //抽象类中可以包含普通的方法，也可以没有抽象方法
    public void showMe() {
        System.out.print("\n I am a Person" );
    }
    //父类方法，不准备被子类重写
    public void showUse() {
        System.out.println("父类方法，不准备被子类重写");
    }

    //abstract修饰方法，只声明，不实现          包含抽象方法的类就是抽象类
    public abstract void abFunction();
}
