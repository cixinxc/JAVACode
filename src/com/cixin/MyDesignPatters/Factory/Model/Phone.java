package com.cixin.MyDesignPatters.Factory.Model;

/**
 * Created by cixinxc on 2017/3/1.
 */
public abstract class Phone {
    protected String logo = null;
    public abstract void showLogo();

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
