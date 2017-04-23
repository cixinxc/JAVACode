package com.cixin.MyDesignPatters.Factory;

import com.cixin.MyDesignPatters.Factory.AbstractFactory.AndroidFactory;
import com.cixin.MyDesignPatters.Factory.AbstractFactory.IPhoneFactory;
import com.cixin.MyDesignPatters.Factory.FactoryMethod.FactoryMethod;
import com.cixin.MyDesignPatters.Factory.Model.Android;
import com.cixin.MyDesignPatters.Factory.Model.IPhone;
import com.cixin.MyDesignPatters.Factory.Model.Phone;
import com.cixin.MyDesignPatters.Factory.SimpleFactory.SimpleFactory;

/**
 * Created by cixinxc on 2017/3/1.
 */
public class FactoryTest {
    public static void main(String[] arg) {
        System.out.println("工厂方法：");
        FactoryMethod fm = new FactoryMethod();
        Phone iphone = fm.createPhone(IPhone.class);
        Phone android = fm.createPhone(Android.class);
        iphone.showLogo();
        android.showLogo();
        System.out.println("简单工厂：");
        Phone iphone2 = SimpleFactory.createPhone(IPhone.class);
        Phone android2 = SimpleFactory.createPhone(Android.class);
        iphone2.showLogo();
        android2.showLogo();
        System.out.println("抽象工厂：");
        IPhoneFactory iphoneFactory = new IPhoneFactory();
        AndroidFactory androidFactory = new AndroidFactory();
        iphoneFactory.createPhone().showLogo();
        androidFactory.createPhone().showLogo();
    }
}
