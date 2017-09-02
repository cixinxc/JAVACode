package com.cixin.Practice.Haoweilai;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> father = new ArrayList<>();
        ArrayList<String> son = new ArrayList<>();
        son.add("1");
        father.add(son);
        son.add("2");
        for(int i = 0;i<father.get(0).size();i++) {
            System.out.println(father.get(0).get(i));
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.keySet();
    }
    /*
    * 输入n个整数，输出出现次数大于等于数组长度一半的数。
    * */
    private static void printHalf() {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> numLists = new ArrayList<>();
        String str = in.nextLine();
        String[] strs = str.split(" ");
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0;i<strs.length;i++) {
            numLists.add(Integer.parseInt(strs[i]));
            if(hm.containsKey(Integer.parseInt(strs[i]))) {
                hm.put(Integer.parseInt(strs[i]), hm.get(Integer.parseInt(strs[i]))+1);
            } else {
                hm.put(Integer.parseInt(strs[i]), 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if(entry.getValue()>=strs.length/2)
                System.out.print(entry.getKey());
        }

    }
    /*
    * 找出n个数里最小的k个
    * */
    private static void minK() {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> numLists = new ArrayList<>();
        String str = in.nextLine();
        String[] strs = str.split(" ");
        for(int i = 0;i<strs.length;i++) {
            numLists.add(Integer.parseInt(strs[i]));
        }
        int k = numLists.get(numLists.size()-1);
        int nl = numLists.size()-1;
        int[] minKNum = new int[k];
        for(int i = 0;i<k;i++) {
            minKNum[i] = Integer.MAX_VALUE;
        }
        for(int i = 0;i<nl;i++) {
            if(numLists.get(i)<minKNum[k-1]) {
                minKNum[k-1] = numLists.get(i);
                for(int j = k-1;j>0;j--) {
                    if(minKNum[j]<=minKNum[j-1]) {
                        int temp = minKNum[j];
                        minKNum[j] = minKNum[j-1];
                        minKNum[j-1] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
        for(int i = 0;i<k;i++) {
            System.out.print(minKNum[i]);
            if(i<k-1) {
                System.out.print(" ");
            }
        }
    }

    /*
    * 读入一个字符串str，输出字符串str中的连续最长的数字串
    * */
    private static void longestSubStr() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int longest = 0;
        String lStr = "";
        for(int i = 0;i<str.length();i++) {
            for(int j = i;j<str.length();j++) {
                if((j+1<str.length() && (str.charAt(j))!=(str.charAt(j+1)-1)) || j+1==str.length() ) {
                    if(longest<(j-i+1)) {
                        lStr = str.substring(i, j+1);

                    }
                    longest = longest>(j-i+1)?longest:(j-i+1);
                    i = j;
                    break;
                }
            }
        }
        System.out.print(lStr);
    }
    /*
    * 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
    * */
    private static ArrayList<ArrayList<Integer>> comLists = new ArrayList<>();
    private static void toSum() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        for(int i = 1;i<=n;i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            toSumList(i, i, n, m, list);
        }
        for(int i = 0;i<comLists.size();i++) {
            for(int j = 0;j<comLists.get(i).size();j++) {
                System.out.print(comLists.get(i).get(j));
                if(j<comLists.get(i).size()-1) {
                    System.out.print(" ");
                }
            }
            if(i<comLists.size()-1) {
                System.out.println();
            }
        }
    }
    private static void toSumList(int start, int count, int n, int m, ArrayList<Integer> list) {
        if(count==m) {
            comLists.add(new ArrayList<>(list));
        } else if(count>m) {
        } else {
            for(int i = start+1;i<=n;i++) {
                list.add(i);
                toSumList(i, count+i, n, m, list);
            }
        }
        if(list.size()>0) {
            list.remove(list.size()-1);
        }
    }

    /*
    * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”
    * 和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
    * */
    private static void deleteSubChar() {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        for(int i = 0;i<str2.length();i++) {
            str1 = str1.replaceAll(""+str2.charAt(i), "");
        }
        System.out.print(str1);
    }
    /*
    * 将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I
    * */
    private static void reverse() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] subStrs = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = subStrs.length-1;i>=0;i--) {
            sb.append(subStrs[i]);
            if(i>0) {
                sb.append(" ");
            }
        }
        System.out.print(sb.toString());
    }
}
