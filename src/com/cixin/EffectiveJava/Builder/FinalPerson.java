package com.cixin.EffectiveJava.Builder;

/**
 * Created by cixinxc on 2017/4/19.
 */
public class FinalPerson {
    private final String id;
    private final String name;
    private final int age;
//    public FinalPerson() {}
    public FinalPerson(String id) {
        this(id, "");
    }
    public FinalPerson(String id, String name) {
        this(id, name, 0);
    }
    public FinalPerson(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
