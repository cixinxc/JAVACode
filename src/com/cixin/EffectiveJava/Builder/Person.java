package com.cixin.EffectiveJava.Builder;

import java.util.ArrayList;

/**
 * Created by cixinxc on 2017/4/19.
 */
public class Person implements Cloneable{
    private String id;
    private String name;
    private int age;

    public Person() {}
    public Person Id(String id) {
        this.id = id;
        return this;
    }
    public Person Name(String name) {
        this.name = name;
        return this;
    }
    public Person Age(int age) {
        this.age = age;
        return this;
    }
public static void a1(){}
public final void a2(){
    Abs.ab1();
    //new Abs().ab1();
    //Abss.a5;
}
    @Override
    public String toString() {
        return "Person@id:"+this.id;
    }
    @Override
    public Person clone() {
        /*
        Person clonedPerson = new Person();
        clonedPerson.id = this.id;
        clonedPerson.name = this.name;
        clonedPerson.age = this.age;
        return clonedPerson;
        */
        try {
            return (Person)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } finally {
            return  null;
        }
    }
}
abstract class Abs {
    public Abs(){}
    public int a;
    public int c = Abss.a3;
    public final int a2 = 1;
    public static int a3;
    public static final int a4 = 3;
    public static void ab1() {
        Person.a1();
        new Person().a2();
        ArrayList al = new ArrayList();
        al.add(1);
        al.add("1");
    }
    //public abstract static  void ab2();
    public abstract void ab3();
}

interface Abss {
    public int a = 1;
    // 接口中不能用private和protected
    public final int a2 = 1;
    public static int a3 = 2;
    public static final int a4 = 3;
    public final int a5 = Abs.a3;
    //public static void ab1();
    //public abstract static  void ab2() {}
    public abstract void ab3();
    //public void ab4() {}
}

interface Ainterface{
    public abstract void A1();
    public abstract void A2();
}
abstract class Aabstract implements Ainterface{
    public void A1(){}
    public void A2(){}
    public abstract void B1();
    public abstract void B2();
    private void C1(){}
    protected void C2(){}
}

class A extends Aabstract{
    public void B1() {
    }
    public void B2() {
    }
    public void A1(){}
    public void A2(){}

    protected void C1(){}
    public void C2(){}
}