package com.cixin.learning.Code.Thread;

import java.util.HashMap;

public class Main {
    static Thread a, b;
    public static void main(String[] args) {

        HashMap<Integer, Integer> am = new HashMap<Integer, Integer>();

        am.put(null, 1);
        a = new Thread() {

            public void run() {
                try {
                    a.sleep(1000);
                } catch (Exception e) {
                    System.out.println("1");
                    return;
                }
                System.out.println("2");
            }
        };
        ////b = new ThreadB();
        //synchronized (b)
        {
            b = new Thread() {
                public void run() {
                    try {
                        b.wait();
                    } catch (Exception e) {
                        System.out.println("3");
                        return;
                    }
                    System.out.println("4");
                }
            };
        }

        a.start();
        b.start();


        System.out.println("end");
    }

}
class ThreadB extends Thread {
    int total;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            total += i;
        }
    }
}
class Animal { }
class Cat extends Animal{}