package com.cixin.Learning.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author cixinxc
 */
public class CustomInvocationHandler implements InvocationHandler{

    private Object object;

    /**
     * @param object
     */
    public CustomInvocationHandler(Object object) {
        this.object = object;
    }

    /**
     * @param proxy
     * @param method
     * @param objects
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
        System.out.println("Before proxy");

        Object realObj = method.invoke(this.object, objects);

        System.out.print("After proxy");
        return realObj;
    }
}
