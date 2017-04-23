package com.cixin.MyDesignPatters.Factory.SimpleFactory;

import com.cixin.MyDesignPatters.Factory.Model.Phone;

/**
 * Created by cixinxc on 2017/3/1.
 */
public class SimpleFactory {
    public static  <T extends Phone> T createPhone(Class<T> c) {
        Phone phone = null;
        try{
            phone = (Phone)Class.forName(c.getName()).newInstance();
        }catch(Exception e) {
            System.out.println("·¢Éú´íÎó!");
        }
        return (T)phone;
    }
}
