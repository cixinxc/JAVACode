package com.cixin.MyDesignPatters.Factory.AbstractFactory;

import com.cixin.MyDesignPatters.Factory.Model.Android;

/**
 * Created by cixinxc on 2017/3/1.
 */
public class AndroidFactory extends PhoneFactory{
    public Android createPhone( ) {
        return new Android();
    }
}
