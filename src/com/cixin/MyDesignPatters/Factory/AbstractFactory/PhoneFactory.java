package com.cixin.MyDesignPatters.Factory.AbstractFactory;

import com.cixin.MyDesignPatters.Factory.Model.Phone;

/**
 * Created by cixinxc on 2017/3/1.
 */
public abstract class PhoneFactory {
    public abstract <T extends Phone> T createPhone();
}
