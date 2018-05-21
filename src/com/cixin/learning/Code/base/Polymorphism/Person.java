package com.cixin.learning.Code.base.Polymorphism;

/**
 * Created by cixinxc on 2017/2/22.
 */
public class Person {
    private String name = "person";
    private final String nickName = "personNickName";   //被final修饰时，必须有初始化属性，或者在构造函数赋初值，二选一
    protected String id = "id";

    public Person() {

        System.out.println("Person的构造开始，name是"+name+",nickName is "+nickName);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        /*
        //报错，无法给被final修饰变量assign value
        this.nickName = nickName;
        */
    }
    public void showMe() {
        System.out.print("\nI am a Person");
    }
    public void overRide() {
        System.out.println("Person's overRide");
    }
    public void overLoad() {
        System.out.println("Person's overLoad");
    }
}
