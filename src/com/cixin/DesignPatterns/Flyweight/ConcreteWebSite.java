package com.cixin.DesignPatterns.Flyweight;

public class ConcreteWebSite extends WebSite
{
    private String name = "";
    
    public ConcreteWebSite(String name)
    {
        this.name = name;
    }
    
    @Override
    public void Use(User user)
    {
        System.out.println("��վ���ࣺ"+name+"�û�����"+user.getName());

    }

}