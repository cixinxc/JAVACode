package com.cixin.learning.proxy.jdk;

/**
 * @author cixinxc
 */
public class HelloImpl implements Hello{
    @Override
    public void hello(String name) {
        System.out.println("Impl : Hello "+name);
    }
}
