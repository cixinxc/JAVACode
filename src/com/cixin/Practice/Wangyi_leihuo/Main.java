package com.cixin.Practice.Wangyi_leihuo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        reEncode();
    }



    /*
    * ��һ��N*N��������Ѱ�����кᣬ�������ϵ����£����ϵ����£����ַ����ֱ������D�����ֵĺ���������ֵ
    * */
    private static void reEncode2() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int D = in.nextInt();
        int[][] nums = new int[N][N];
        int[][] maxs = new int[N][N];
        for(int i = 0;i<N;i++) {
            for(int j = 0;j<N;j++) {
                nums[i][j] = in.nextInt();
            }
        }
        for(int i = 0;i<N;i++) {
            maxs[i][0] = nums[i][0];
            for(int j = 1;j<N;j++) {
             //   maxs[i][j] = Math.max();
            }
        }
    }

    private static void reEncode() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuffer reStr = new StringBuffer();
        for(int i = 0;i<str.length();i++) {
            char indexI = str.charAt(i);
            int n = 1;
            while(i+1<str.length() && str.charAt(i)==str.charAt(i+1)) {
                n++;
                i++;
            }
            reStr.append(n);
            reStr.append(indexI);
        }
        System.out.print(reStr);
    }
}
