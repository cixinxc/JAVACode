package com.cixin.learning.Code.base.Polymorphism;

/**
 * Created by cixinxc on 2017/2/22.
 */
public class Person {
    private String name = "person";
    private final String nickName = "personNickName";   //��final����ʱ�������г�ʼ�����ԣ������ڹ��캯������ֵ����ѡһ
    protected String id = "id";

    public Person() {

        System.out.println("Person�Ĺ��쿪ʼ��name��"+name+",nickName is "+nickName);
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
        //�����޷�����final���α���assign value
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
