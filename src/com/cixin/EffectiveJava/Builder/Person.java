package com.cixin.EffectiveJava.Builder;

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

    @Override
    public String toString() {
        return "Person@id:"+this.id;
    }
    @Override
    public Person clone() {
        Person clonedPerson = new Person();
        clonedPerson.id = this.id;
        clonedPerson.name = this.name;
        clonedPerson.age = this.age;
        return clonedPerson;
    }
}
