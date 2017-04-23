package com.cixin.DesignPatterns.Singleton;

/**
 * Created by cixinxc on 2017/2/26.
 */
public final class HelloWorld
{
    private static HelloWorld instance = null;

    private HelloWorld()
    {
    }

    public static HelloWorld getInstance()
    {
        if (instance == null)
        {
            instance = new HelloWorld();
        }
        return instance;
    }

    public void sayHello()
    {
        System.out.println("hello world!!");
    }

    public static void sayHello2()
    {
        System.out.println("hello world 222 !!");
    }

}
