package com.cixin.DesignPatterns.Flyweight;

import java.util.Hashtable;

public class WebsiteFactory
{
    public Hashtable<String,WebSite> flyweights = new Hashtable<String, WebSite>();
    
    //�����վ����
    public WebSite GetWebSiteCategory(String key)
    {
        //�ж��Ƿ��������������������ֱ�ӷ��أ��������ڣ���ʵ�������ٷ���
        if(!flyweights.containsKey(key))
        {
        	System.out.println("new one object");
            
        	flyweights.put(key, new ConcreteWebSite(key));
        }
        return flyweights.get(key);
    }
    
    //��ȡ��վ���������
    public int GetWebSiteCount()
    {
        return flyweights.size();
    }
}