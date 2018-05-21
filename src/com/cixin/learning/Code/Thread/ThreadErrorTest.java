package com.cixin.learning.Code.Thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThreadErrorTest {
    public static void main(String[] args) {
         Runnable runnable = new Runnable() {
            DataOne dataOne = new DataOne();
            public void run() {
                //dataOne.add();
                DataOne dataOne1 = new DataOne();
                DataOne dataOne2 = new DataOne();
                dataOne1.sObject("one");
                dataOne2.sObject2("two");
            }
        };
         /*
        for(int i = 0;i<1;i++) {
            //new Thread(new RunableOne()).start();
            new Thread(runnable).start();
        }
        */

        //LinkedHashMap
        //HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>(20);
        Map<String, Integer> hm = new HashMap<>(16, 0.8F);
        for(int i = 0;i<15;i++) {
            hm.put("key"+i, i);
        }
        for(Map.Entry<String, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
class RunableOne implements Runnable {
    DataOne dataOne = new DataOne();
    public void run() {
        dataOne.add();
    }
}
class DataOne {
    int data;

    public void sObject(String str) {
        System.out.print(str+":");
        for(int i = 0;i<100;i++) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }

    public synchronized void sObject2(String str) {
        System.out.print(str+":");
        for(int i = 0;i<100;i++) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }

    public static synchronized void sClass(String str) {
        System.out.print(str+":");
        for(int i = 0;i<100;i++) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }
    public static synchronized void sClass2(String str) {
        System.out.print(str+":");
        for(int i = 0;i<100;i++) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }

    public void add() {
        String str = "0123456789";
        synchronized(this)
        {
            for(int i = 0;i<10;i++) {
                System.out.print(str.charAt(i)+"\t");
                data+=i;
            }
            System.out.println();
            //System.out.println(Thread.currentThread().getName()+":data is "+data);
        }
    }
}
