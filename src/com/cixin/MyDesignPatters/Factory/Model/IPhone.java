package com.cixin.MyDesignPatters.Factory.Model;

/**
 * Created by cixinxc on 2017/3/1.
 */
public class IPhone extends Phone{
    public IPhone() {
        this.logo = "IPhone";
    }
    public void showLogo() {
        System.out.println("this is "+this.logo+"!");
    }
}
