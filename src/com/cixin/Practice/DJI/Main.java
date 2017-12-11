package com.cixin.Practice.DJI;

import com.cixin.Learning.Code.List.LinkList;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class A{
    public String show(D d){return ("AD");}
    public String show(A a){return ("AA");}
}

class B extends A{
    public String show(B b){return ("BB");}
    public String show(A a){return ("BA");}
}

class C extends B{}

class D extends B{}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a.show(b)+"-"+a.show(c)+"-"+a.show(d)+"-"+b.show(a)+"-"+b.show(c)+"-"+b.show(d));
        float f = 1.0f;
    }

    private static void replaceNum() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strs = new String[n];
        String a = in.nextLine();
        for(int i = 0;i<n;i++) {
            strs[i] = in.nextLine();
        }
        for(int i = 0;i<=9;i++) {
            String[] strs2 = new String[n];
            for(int i2 = 0;i2<n;i2++) {
                strs2[i2] = strs[i];
               // strs2[i2].replaceAll()
            }
        }
    }

    private static void tets() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strs = new String[n];
        Long[] num = new Long[n];
        int[][] nums = new int[n][3];
        for(int i = 0;i<n;i++) {
            String as = in.nextLine();
            strs[i] = in.nextLine();
            //num[i] = in.nextLong();
            //strs[i] = ""+num[i];
            nums[i][0] = in.nextInt();
            nums[i][1] = in.nextInt();
            nums[i][2] = in.nextInt();
            Arrays.sort(nums[i]);
        }
        for(int i = 0;i<n;i++) {
            for(int j = 2;j>=0;j--) {
                for(int k = 0;k<strs[i].length();k++) {
                    String str = strs[i];
                    if(strs[i].charAt(k)-'0'<nums[i][j]) {
                        // ¿ÉÒÔÌæ»»
                        //StringBuffer sb = new StringBuffer();
                        //sb.append(str.substring(0, k)); sb.append(nums[i][j]);sb.append(str.substring(k+1, str.length()));
                        strs[i] =  strs[i].replaceAll(""+strs[i].charAt(k), ""+nums[i][j]);
                        break;
                    }
                }
            }
            System.out.print(strs[i]);
            if(i<n-1)
                System.out.println();
        }
    }


    private static void getNums() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int total = 0;
        int[] nums = new int[n];
        for(int i = 0;i<n;i++) {
            nums[i] = in.nextInt();
        }
        for(int i = 0;i<n;i++) {
            HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
            for(int j = i;j<n;j++) {

                if(hm.containsKey(nums[j])) {
                    hm.put(nums[j], hm.get(nums[j])+1);
                } else {
                    hm.put(nums[j], 1);
                }
                if(hm.get(nums[j])<=k) {
                    total++;
                } else {
                    break;
                }
            }
        }
        System.out.print(total);
    }
}
