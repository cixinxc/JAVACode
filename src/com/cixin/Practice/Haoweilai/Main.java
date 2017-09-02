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
    * ����n��������������ִ������ڵ������鳤��һ�������
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
    * �ҳ�n��������С��k��
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
    * ����һ���ַ���str������ַ���str�е�����������ִ�
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
    * ������������ n �� m��������1��2��3.......n ������ȡ������,ʹ��͵��� m ,Ҫ���������еĿ�������г���
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
    * ���������ַ������ӵ�һ�ַ�����ɾ���ڶ����ַ��������е��ַ������磬���롱They are students.��
    * �͡�aeiou������ɾ��֮��ĵ�һ���ַ�����ɡ�Thy r stdnts.��
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
    * ��һ�仰�ĵ��ʽ��е��ã���㲻���á����� I like beijing. �����������Ϊ��beijing. like I
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
