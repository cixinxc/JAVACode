package com.cixin.Algorithm.LeetCode;

/**
 * @author cixinxc
 */
public class Main {
    public static void main(String[] args) {
        /*
        String s = new String("tt");
        s.intern();
        String s2 = "tt";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
        */

    }
}

class ThreadT1 implements Runnable {
    public String v;
    public String name;
    public int c = 0;

    public ThreadT1(String s1, String s2, int c) {
        v = s1;
        name = s2;
        this.c = c;
    }

    @Override
    public void run() {
        for(int i = 0;i<20;i++) {
            c++;
            System.out.println(name+"  :  "+c+"  :  "+i);
        }
    }
}
