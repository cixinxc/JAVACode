package com.cixin.DesignPatterns.Flyweight;

import java.util.Hashtable;

public class WebsiteFactory
{
    public Hashtable<String,WebSite> flyweights = new Hashtable<String, WebSite>();
    
    //获得网站分类
    public WebSite GetWebSiteCategory(String key)
    {
        //判断是否存在这个对象，如果存在则直接返回，若不存在，则实例化它再返回
        if(!flyweights.containsKey(key))
        {
        	System.out.println("new one object");
            
        	flyweights.put(key, new ConcreteWebSite(key));
        }
        return flyweights.get(key);
    }
    
    //获取网站分类的总数
    public int GetWebSiteCount()
    {
        return flyweights.size();
    }
}