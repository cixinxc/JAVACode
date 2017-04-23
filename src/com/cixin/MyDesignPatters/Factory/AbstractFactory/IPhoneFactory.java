package com.cixin.MyDesignPatters.Factory.AbstractFactory;


import com.cixin.MyDesignPatters.Factory.Model.IPhone;

/**
 * Created by cixinxc on 2017/3/1.
 */
public class IPhoneFactory extends PhoneFactory{
    public IPhone createPhone() {
        return new IPhone();
    }
}
