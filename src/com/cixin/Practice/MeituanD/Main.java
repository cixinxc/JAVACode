package com.cixin.Practice.MeituanD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        teamTest();
    }

    /*
    * 在上小学的时候，我们经常碰到这样的事：考完试后老师懒得改试卷，于是让我们同桌相互交换试卷后为对方批改。但是后来老师发现这样作容易出现作弊，于是他想了一个新办法。
    * 老师将同学分成了 n 个组，其中编号为?的组中有?? 个人。然后老师会按某种顺序依次访问这些组。
    * 对于他访问的第一个组，他会将这组内的所有试卷都收走，放置在桌上；对于他后续访问的每一个组，首先他会从桌上的试卷最上方拿出该组对应人数数量的试卷，
    * 随机分配给该组每个人一张试卷让他们进行批改，而后再将这组学生自己考的试卷收走放置在桌面试卷的最下方。
    * 当他访问完所有的组后他会将桌面上剩余的所有试卷随机分配给他第一个访问的组的学生进行批改。
    * 但他发现这种方法有时候也会出现问题：有可能在中途访问到某个组的时候桌面上的试卷不够分配给这组学生每人一张；
    * 也有可能最后会有学生分配到批改自己的试卷，而且这两种情况是否出现是与他访问每个组的顺序有关的。
    * 现在他想知道是否存在一种访问顺序能够使以上两种情况都不出现，顺利完成试卷批改呢？
    * */
    private static void teamTest() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] sn = new int[n];
        for(int i = 0;i<n;i++) {
            sn[i] = in.nextInt();
        }
        Arrays.sort(sn);
        int total = sn[n-1];
        for(int i = n-2;i>=1;i--) {
            total -= sn[i];
        }
        System.out.print(total<1?"Yes":"No");

    }

    /*
    * 序列中任意个连续的元素组成的子序列称为该序列的子串。
    * 现在给你一个序列P和一个整数K，询问元素和是K的倍数的子串的最大长度。
    * 比如序列【1,2,3,4,5】，给定的整数K为 5，其中满足条件的子串为{5}、{2,3}、{1,2,3,4}、{1,2,3,4,5}，
    * 那么答案就为 5，因为最长的子串为{1,2,3,4,5}；如果满足条件的子串不存在，就输出 0。
    * 5
    * 1 2 3 4 5
    * 5
    * 5
    * */
    private static void kMax() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] pn = new int[n];
        for(int i = 0;i<n;i++) {
            pn[i] = in.nextInt();
        }
        int k = in.nextInt();
        int max = -1;
        for(int i = 0;i<n;i++) {
            int total = 0;
            int j = i;
            for(;j<n;j++) {
                total+=pn[j];
                if(total%k==0) {
                    //max = Math.max(max, j-i+1);
                    max = max+j-i+1;
                    i = j;
                }
            }
            if(max>(n-i+1) && (i+max)>n)
                break;
        }
        System.out.print(max);
    }
}
