package com.cixin.EffectiveJava;

import com.cixin.EffectiveJava.Builder.BuildePerson;
import com.cixin.EffectiveJava.Builder.FinalPerson;
import com.cixin.EffectiveJava.Builder.Person;
import com.cixin.EffectiveJava.Singleton.EnumSingleton;

/**
 * Created by cixinxc on 2017/4/19.
 */
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person().Id("1").Name("ДоіЮіЮ").Age(25);
        final Person p11 = new Person().Id("11").Name("11").Age(11);

        BuildePerson p2 = new BuildePerson.Builder("2").Name("ДоіЮ").Age(26).build();
        BuildePerson p22 = new BuildePerson.Builder("22").Name("22").Age(22).build();
        //p2 = p22;
        BuildePerson.Builder b = new BuildePerson.Builder("33");
        System.out.println(p2.toString());

        Person p2c = p1.clone();
        p1 = new Person();
        FinalPerson p3 = new FinalPerson("3");
        FinalPerson p33 = new FinalPerson("33");
        //p3 = p33;

        EnumSingleton es = EnumSingleton.enumSingleton;
        int a = 2;
        System.out.println(a--);
        System.out.println(--a);
        System.out.println(a);
    }
}
