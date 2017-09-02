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
    * ����Сѧ��ʱ�����Ǿ��������������£������Ժ���ʦ���ø��Ծ�����������ͬ���໥�����Ծ��Ϊ�Է����ġ����Ǻ�����ʦ�������������׳������ף�����������һ���°취��
    * ��ʦ��ͬѧ�ֳ��� n ���飬���б��Ϊ?��������?? ���ˡ�Ȼ����ʦ�ᰴĳ��˳�����η�����Щ�顣
    * ���������ʵĵ�һ���飬���Ὣ�����ڵ������Ծ����ߣ����������ϣ��������������ʵ�ÿһ���飬������������ϵ��Ծ����Ϸ��ó������Ӧ�����������Ծ�
    * ������������ÿ����һ���Ծ������ǽ������ģ������ٽ�����ѧ���Լ������Ծ����߷����������Ծ�����·���
    * �������������е�������Ὣ������ʣ��������Ծ�������������һ�����ʵ����ѧ���������ġ�
    * �����������ַ�����ʱ��Ҳ��������⣺�п�������;���ʵ�ĳ�����ʱ�������ϵ��Ծ������������ѧ��ÿ��һ�ţ�
    * Ҳ�п���������ѧ�����䵽�����Լ����Ծ���������������Ƿ��������������ÿ�����˳���йصġ�
    * ��������֪���Ƿ����һ�ַ���˳���ܹ�ʹ������������������֣�˳������Ծ������أ�
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
    * �����������������Ԫ����ɵ������г�Ϊ�����е��Ӵ���
    * ���ڸ���һ������P��һ������K��ѯ��Ԫ�غ���K�ı������Ӵ�����󳤶ȡ�
    * �������С�1,2,3,4,5��������������KΪ 5�����������������Ӵ�Ϊ{5}��{2,3}��{1,2,3,4}��{1,2,3,4,5}��
    * ��ô�𰸾�Ϊ 5����Ϊ����Ӵ�Ϊ{1,2,3,4,5}����������������Ӵ������ڣ������ 0��
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
