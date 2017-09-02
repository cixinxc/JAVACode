package com.cixin.Practice.Didi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        aToSum();
    }

    private static void maxSum() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++) {
            nums[i] = in.nextInt();
        }
        int max = Integer.MIN_VALUE, maxCur = 0;
        for(int i = 0; i < n; i++) {
            maxCur = Math.max(maxCur + nums[i], nums[i]);
            max = Math.max(maxCur, max);
        }
        System.out.println(max);
    }

    /*
    * 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
    * 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
    * */
    private static void maxPrice() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] ns = new int[n];
        ArrayList<Integer> nsList = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            ns[i] = in.nextInt();
            nsList.add(ns[i]);
        }
        Collections.sort(nsList);
        ArrayList<HashMap<Integer, Integer>> al = new ArrayList<HashMap<Integer, Integer>>();
        ArrayList<Integer> m1s = new ArrayList<>();
        ArrayList<Integer> m2s = new ArrayList<>();
        for(int i = 0;i<m;i++) {
            int a1 = in.nextInt();
            int a2 = in.nextInt();
            m1s.add(a1);
            m2s.add(a2);
        }
        int total = 0;
        for(int i = 0;i<n;i++) {
            int index = -1; int value = -1;
            for(int j = 0;j<m1s.size();j++) {
                if(nsList.get(i)>=m1s.get(j) && ( index==-1 || m2s.get(j)>value )) {
                    index = j; value = m2s.get(j);
                }
            }
            if(index!=-1) {
                total += value;
                m1s.remove(index); m2s.remove(index);
            }
        }
        System.out.print(total);
    }

    private static void aToSum() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int[] A = new int[n];
        for(int i = 0;i<n;i++) {
            A[i] = in.nextInt();
        }
        long dp[]=new long[sum+1];
        dp[0]=1;
        int i,j;
        for(i=0;i<n;i++){
            for(j=sum;j>=A[i];j--){
                dp[j]=dp[j-A[i]]+dp[j];
            }
        }
        System.out.println(dp[sum]);
    }
}
