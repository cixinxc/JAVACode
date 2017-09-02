package com.cixin.Test;

import sun.nio.cs.ext.MacThai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by cixinxc on 2017/4/26.
 */
public class Main {
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int total1 = 0;
        int total2 = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            al.add(in.nextInt());
        }
        Collections.sort(al);
        int i = 0;int j = n-1;
        while(i<j) {
            if(total1<total2) {
                total1 += al.get(j);
                j--;
            }else {
                total2 += al.get(j);
                j--;
            }
        }
        System.out.print(Math.max(total1, total2));
    }
    */
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int total = 0;
        char[] strs = str.toCharArray();
        char[] strs2 = str.toCharArray();
        for(int i = 0;i<strs.length;i++) {
            if(strs[i]=='G') {
                for(int j = i-1;j>=0;j--) {
                    if(strs[j] == 'B') {
                        char temp = strs[j];
                        strs[j] = strs[j+1];
                        strs[j+1] = temp;
                        total++;
                    }else {
                        break;
                    }
                }
            }
        }
        int total2 = 0;
        for(int i = 0;i<strs2.length;i++) {
            if(strs2[i]=='B') {
                for(int j = i-1;j>=0;j--) {
                    if(strs2[j] == 'G') {
                        char temp = strs2[j];
                        strs2[j] = strs2[j+1];
                        strs2[j+1] = temp;
                        total2++;
                    }else {
                        break;
                    }
                }
            }
        }
        System.out.print(Math.min(total, total2));
    }
    */
    /*
    // 去除重复元素，按最后出现的次序显示
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            int num = in.nextInt();
            if(al.contains(num)) {
                al.remove(al.indexOf(num));
                al.add(num);
            }else {
                al.add(num);
            }
        }
        System.out.print(al.get(0));        // 第一个元素从0开始 不是1！！！
        for(int i = 1;i<al.size();i++) {
            System.out.print(" "+al.get(i));
        }
    }
    */
    /*
    // 需要根据给定的w，x，y，z,求出集合中一共有多少个元素
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        HashSet<Double> hs3 = new HashSet<>();
        for(int i = w;i<=x;i++) {
            al1.add(i);
        }
        for(int i = y;i<=z;i++) {
            al2.add(i);
        }
        for(int i = 0;i<=x-w;i++) {
            for(int j = 0;j<=z-y;j++) {
                hs3.add(1.0*al1.get(i)/al2.get(j)); // 居然是double类型集合
            }
        }

        System.out.print(hs3.size());
    }
    */
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n==0) {
            System.out.print(0);
            return;
        }
        if(n==1) {
            System.out.print(1);
            return;
        }
        char[][] chars = new char[n][n];
        for(int i = 0;i<n;i++) {
            String str = in.next();
            chars[i] = str.toCharArray();
        }
        int[][] total = new int[n][2];      //  此处int[][] total = new int[4][2];
        int Btotal = 0;int Wtotal = 0;
        int Max = 1;
        int K = 1;
        for(int j = 0;j<n;j++) {
            K = 1;                      //  注意初始值的保存
            for(int i = 0;i<n-1;i++) {
                char a = chars[i][j];
                char b = chars[i+1][j];
                if(chars[i][j]==chars[i+1][j]) {
                    K++;
                    if(K>Max) {
                        Max = K;
                    }
                } else {
                    K = 1;
                }
            }
        }


        System.out.print(Max);
    }
    */
    /*
    // 记单词  输出输出
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nm = in.nextLine();
        String[] nms = nm.split(" ");
        int n = Integer.parseInt( nms[0] );
        int m = Integer.parseInt( nms[1] );
        //while(in.hasNextLine())
        {


            String mStr = in.nextLine();
            String sStr = in.nextLine();

            String[] mStrs = mStr.split(" ");
            String[] sStrs = sStr.split(" ");
            HashSet<String> hm = new HashSet<>();
            HashSet<String> hs = new HashSet<>();
            for(int i = 0;i<n;i++) {
                hm.add(mStrs[i]);
            }
            for(int i = 0;i<m;i++) {
                hs.add(sStrs[i]);
            }
            int total = 0;
            for(int i = 0;i<n;i++) {
                if(hm.contains(mStrs[i])) {
                    if(hs.contains(mStrs[i])) {
                        total += mStrs[i].length()*mStrs[i].length();
                    }
                    hm.remove(mStrs[i]);
                }
            }
            System.out.print(total);
        }
    }
    */
    /*
    // K个饼干分给n个人（K位中有些数字看不清）  完成60%，复杂度有些高
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String k = in.nextLine();
        int n = in.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        // 记录x的位置
        for(int i = 0;i<k.length();i++) {
            if(k.charAt(i)=='X') {
                al.add(i);
            }
        }
        //System.out.print( Integer.parseInt("999990") );

        System.out.print(""+replaceX(k, n));
    }
    public static int replaceX(String str0, int n) {
        int t = 0;
        String str = new String(str0);
        //System.out.print(str);
        if(!str.contains("X")) {
            if(Long.parseLong(str)%n==0) {
                return 1;
            } else {
                return 0;
            }
        }else {

            for(int i = 0;i<=9;i++) {
                //System.out.print(str);
                //String cs = str.replaceFirst("X", ""+((char)(i+48)));
                //System.out.println("    "+cs);
                t += replaceX(str.replaceFirst("X", ""+((char)(i+48))), n);
            }
            return t;
        }
    }*/
    // 判断栈的压入弹出序列
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        String push = in.nextLine();
        String pop = in.nextLine();
        String[] spush = push.split(" ");
        String[] spop = pop.split(" ");
        int[] pushs = new int[spush.length];
        int[] pops = new int[spop.length];
        for(int i = 0;i<pushs.length;i++) {
            pushs[i] = spush[i].charAt(0)-48;
        }
        for(int i = 0;i<pops.length;i++) {
            pops[i] = spop[i].charAt(0)-48;
        }
        ArrayList<Integer> alPush = new ArrayList<>();
        ArrayList<Integer> alPop = new ArrayList<>();
        for(int i = 0;i<pushs.length;i++) {
            alPush.add(pushs[i]);
        }
        for(int i = 0;i<pops.length;i++) {
            alPop.add(pops[i]);
        }

        for(int i = 0;i<alPop.size();i++) {

        }
    }
    public static void main33(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<str.length();i++) {
            int total = 1;
            char f = str.charAt(i);
            for(int j = i+1;j<str.length();j++) {
                if(str.charAt(j)==f) {
                    total++;
                    i++;
                } else {
                    break;
                }
            }
            sb.append(total);
            sb.append(f);
        }
        System.out.print(sb.toString());
    }
        public static void  main333(String[] args) {
            System.out.print(jump(3));
        }
        public static int jump(int n) {
            int total = 1;
            if(n==1) {
                return 1;
            } else {
                return jump(n-1)*2;
            }
        }
    public static void  main(String[] args) {
        int n = -2147483648;
        System.out.println(((int)Math.pow(2, 31)+n*(-1)-1)+1);
        System.out.println((int)Math.pow(2, 31));
        if(n>0) {
            System.out.print(qu1(n));
        } else if(n<0){
            System.out.print(qu1((int)Math.pow(2, 31)+n*(-1)-1)+1);
        } else {
            System.out.print(0);
        }
    }
    public static int qu1(long n) {
        int t = 1;
        while(n/2!=0) {
            if(n%2==1) {
                t++;
            }
            n /= 2;
        }
        return t;
    }


}