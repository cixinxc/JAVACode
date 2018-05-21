package com.cixin.learning.proxy.jdk;

/**
 * @author cixinxc
 */
public interface Hello {

    default void hello(String name) {
        System.out.println("static : Hello "+name);
    }
}
