package com.cixin.MyDesignPatters.Factory.FactoryMethod;

import com.cixin.MyDesignPatters.Factory.Model.Phone;

/**
 * Created by cixinxc on 2017/3/1.
 */
public abstract class AbstractPhoneFactory {
    public abstract <T extends Phone> T createPhone(Class<T> c);
}
