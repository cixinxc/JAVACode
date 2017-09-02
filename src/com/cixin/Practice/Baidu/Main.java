package com.cixin.Practice.Baidu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by cixinxc on 2017/7/3.
 */
public class Main {
    public static void main (String[] str) {
        ArrayList<Integer> al = new ArrayList<>();
        //al.add(0, 1);         //ArrayList 的index值必须连续，大小到大
        System.out.println(buyHat());
    }
    public static int buyHat () {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        int n = in.nextInt();
        int j = 0;
        for(int i = 0;i<n;i++) {
            int temp = in.nextInt();
            if(al.contains(temp)) {
                continue;
            } else {
                al.add(temp);//al.add(temp, temp);   是错误的
                j++;
            }
        }
        Collections.sort(al);
        return al.size()>=3?al.get(2):-1;
    }

    public static int sort () {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] num = new int[N];
        for(int i = 0;i<N;i++) {
            num[i] = in.nextInt();
        }
        int f = 0;  // f存放移动次数
        for(int i = N;i>=1;i--) {
            int max = 0;
            for(int j = 0;j<N;j++) {
                if(num[max]<num[j]) {
                    max = j;
                }
            }
            if(num[i-1]==num[max]) {
                continue;
            } else {
                int temp = num[i-1];
                num[i-1] = num[max];
                num[max] = temp;
                f++;
            }

        }
        return f;
    }
}