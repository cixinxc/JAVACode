package com.cixin.MyDesignPatters.Factory.Model;

/**
 * Created by cixinxc on 2017/3/1.
 */
public class Android extends Phone{
    public Android() {
        this.logo = "Android";
    }
    public void showLogo() {
        System.out.println("this is "+this.logo+"!");
    }
}
