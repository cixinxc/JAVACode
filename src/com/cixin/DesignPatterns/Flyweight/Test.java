package com.cixin.DesignPatterns.Flyweight;

public class Test
{
    public static void main(String[] args)
    {
        WebsiteFactory f = new WebsiteFactory();
        
        WebSite fx = f.GetWebSiteCategory("1");
        fx.Use(new User("小菜"));
        
        
        
        WebSite fy = f.GetWebSiteCategory("1");
        fy.Use(new User("大烟笼"));
        
        WebSite fz = f.GetWebSiteCategory("1");
        fz.Use(new User("大菜"));
        
        WebSite fl = f.GetWebSiteCategory("2");
        fl.Use(new User("老顽童"));
        
        WebSite fm = f.GetWebSiteCategory("2");
        fm.Use(new User("肥菜"));
        
        WebSite fn = f.GetWebSiteCategory("2");
        fn.Use(new User("小小斌"));
        
        System.out.println(" "+fy+" "+fz+"::"+fl+" "+fn);
        System.out.println(f.flyweights.toString());
        
        System.out.println("网站分类总数为：" + f.GetWebSiteCount());
    }
}

