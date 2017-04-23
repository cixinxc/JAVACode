package com.cixin.DesignPatterns.Singleton;

/**
 * Created by cixinxc on 2017/2/25.
 */
public class SingletonTest {
    public static void main(String[] arg) {
        SingletonHanger sh = SingletonHanger.getSingletonHanger();
        SingletonHanger sh2 = SingletonHanger.getSingletonHanger();

        SingletonEnum es = SingletonEnum.INSTANCE;
        SingletonEnum es2 = SingletonEnum.INSTANCE;
        es.setEs("1");
        es2.setEs("2");
        System.out.println(es==es2);
        System.out.println("es: "+es.getEs()+"    es2: "+es2.getEs()+"    sh: "+sh+"    sh2: "+sh2);
    }
}
