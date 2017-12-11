package com.cixin.Practice.WangYi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        devideFour();
    }
    private static void devideFour() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] results = new String[t];
        for(int i = 0;i<t;i++) {
            int n = in.nextInt();
            int[] A = new int[n];
            int n_4 = 0;
            int nf4 = 0;
            int n_2 = 0;
            for(int j = 0;j<n;j++) {
                A[j] = in.nextInt();
                if(A[j]%4==0) {
                    n_4++;
                } else if(A[j]%2==0) {
                    n_2++;
                }else {
                    nf4++;
                }
            }
            if(n_4+1>=nf4 || (n_2>0 && n_4>=nf4)) {
                results[i] = "Yes";
            } else {
                results[i] = "No";
            }
        }
        for(int i = 0;i<t;i++) {
            System.out.print(results[i]);
            if(i<t-1) {
                System.out.println();
            }
        }
    }
    // 50
    private static void visit() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int L = in.nextInt();
        int[] ns = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n-1;i++) {
            ns[i] = in.nextInt();
            if(map.containsKey(ns[i])) {
                map.put(ns[i], map.get(ns[i])+1);
            } else {
                map.put(ns[i], 1);
            }
        }
        System.out.print(Math.min(map.size(), L));
    }
    private static void slipLength() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int slip = 1;
        char start = str.charAt(0);
        for(int i = 0;i<str.length();i++) {
            if(start!=str.charAt(i)) {
                start = str.charAt(i);
                slip++;
            }
        }
        System.out.print(String.format("%.2f", 1.0*str.length()/slip));
    }
    private static void SSR() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int count = 0;

        for(int A = 1;A<=n;A++)
        {
            //count+=Math.floor(Math.sqrt(Math.floor(A+m+2*Math.sqrt(A*m))));
            count+= ( Math.floor(Math.sqrt(A)+Math.sqrt(m) - Math.sqrt(A)+Math.sqrt(1)));
        }

        for(int A = 1;A<=n;A++) {
            for(int B = 1;B<=m;B++) {
                if( (2*Math.sqrt(1.0*A*B))%1.0<=0.000001 ) {
                    count+=1;
                }
            }
        }
        System.out.print(count);
    }
    private static void reverseNum() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String rev = new StringBuffer(str).reverse().toString();
        StringBuffer result = new StringBuffer();
        int add = 0;
        int a = 0;
        int b = 0;
        for(int i = str.length()-1;i>=0;i--) {
             add = (str.charAt(i)-'0') + (rev.charAt(i)-'0') + b;
             a = add%10;
             b = add/10;
             result.append(a);
        }
        if(b!=0) {
            result.append(b);
        }
        System.out.print(result.reverse());
    }
    private static void magicCoin() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        /*实质上是以0为开始的二叉树*/
        StringBuffer sb = new StringBuffer();
        while(n!=0) {
            sb.append(""+((n-1)%2+1));
            n = (n-1)/2;
        }
        sb.reverse();
        System.out.print(sb.toString());
    }
}
