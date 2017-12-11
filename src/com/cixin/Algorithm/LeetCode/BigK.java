package com.cixin.Algorithm.LeetCode;

public class BigK {
    public static void main(String[] args){

        run1();
    }
    public static void run1(){
        int[] a={1,2,7,6,9,5,4,88,999,66,464,789};
        int k=5;
        System.out.println(a.length);
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i]<a[j]) {
                    change(a[i], a[j]);
                }
            }
        }
    }

    public static void change(Integer b1,Integer b2){

        System.out.println("b1="+b1+"-----b2="+b2);
        System.out.println("-----------------------------");
        Integer integer=null;
        integer=b1;
        b1=b2;
        b2=integer;
        System.out.println("b1="+b1+"-----b2="+b2);
    }
}

