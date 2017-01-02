package com.cixin.DesignPatterns.Flyweight;

public class Test
{
    public static void main(String[] args)
    {
        WebsiteFactory f = new WebsiteFactory();
        
        WebSite fx = f.GetWebSiteCategory("1");
        fx.Use(new User("С��"));
        
        
        
        WebSite fy = f.GetWebSiteCategory("1");
        fy.Use(new User("������"));
        
        WebSite fz = f.GetWebSiteCategory("1");
        fz.Use(new User("���"));
        
        WebSite fl = f.GetWebSiteCategory("2");
        fl.Use(new User("����ͯ"));
        
        WebSite fm = f.GetWebSiteCategory("2");
        fm.Use(new User("�ʲ�"));
        
        WebSite fn = f.GetWebSiteCategory("2");
        fn.Use(new User("СС��"));
        
        System.out.println(" "+fy+" "+fz+"::"+fl+" "+fn);
        System.out.println(f.flyweights.toString());
        
        System.out.println("��վ��������Ϊ��" + f.GetWebSiteCount());
    }
}

