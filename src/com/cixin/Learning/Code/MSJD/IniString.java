package com.cixin.Learning.Code.MSJD;

import java.util.*;

/**
 * Created by cixinxc on 2017/3/8.
 */
public class IniString {
    public static void main(String[] strs) {
        //System.out.println(new IniString().checkDifferent("as"));
        //System.out.println("countBitDiff:"+new IniString().countBitDiff(16807,282475249));
        //System.out.println("countBitDiff:"+new IniString().countSum(4));
        int[] A = {1, 3, 5, 7, 9};
        //System.out.println("countBitDiff:"+new IniString().getPos(A, 5, 3));
        int[][] array = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13},{6,8,11,15}};
        //int[][] array = {{1,2,8,9},  {4,7,10,13}};
        //System.out.println(new IniString().Find(7, array));

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        a1.next = a3; a3.next = a5;
        a2.next = a4; a4.next = a6;

        //ArrayList<Integer> a = new IniString().printListFromTailToHead(l1);
        ListNode ln = new IniString().Merge(a1, a2);
        ArrayList a = new ArrayList();
        a.add(0, 1);
        a.contains(1);
        HashMap h = new HashMap();
        h.put(1,2);
        int[] al = {0,7,1,6};
        int[] ar = {1, 5, 0, 6};
        //findMinimum(4, al, ar);
        System.out.println("偶串个数是:"+new IniString().qiuou());

    }


    public static int findMinimum(int n, int[] left, int[] right) {
        int lmin = -1;
        int rmin = -1;
        ArrayList<Integer> leftArray = new ArrayList<Integer>();
        ArrayList<Integer>rightArray = new ArrayList<Integer>();

        for(int i = 0;i<n;i++) {
            leftArray.add(i, left[i]);
            rightArray.add(i, right[i]);
        }
        Collections.sort(leftArray);
        Collections.sort(rightArray);
        int lcout = 0;
        for(int i = 0;i<n;i++) {
            System.out.println("  "+ leftArray.get(i));
            if(leftArray.get(i)!=0 && lcout==0) {
                lcout = 100;
                continue;
            }
            lcout += leftArray.get(i);
            System.out.println(" lcout "+ lcout);
        }
        int rcout = 0;
        for(int i = 0;i<n;i++) {
            if(rightArray.get(i)!=0 && rcout==0) {
                rcout = 100;
                continue;
            }
            rcout += rightArray.get(i);
        }
        return Math.min(lcout, rcout)-101;
    }
    public boolean checkDifferent(String iniString) {
        HashMap hm = new HashMap();
        for(int i = 0;i<iniString.length();i++) {
            if(hm.get( iniString.charAt(i))==null) {
                hm.put(iniString.charAt(i), i);
            }else {
                return false;
            }
        }
        return true;
    }
    public void subSortString(String str) {
        ArrayList al = new ArrayList<String>();
    }
    public int countBitDiff(int m, int n) {
        int dif = 0;
        while(m!=0 || n!=0) {
            if(m!=0 && n!=0) {
                if((m%2)==(n%2)) {
                    ;
                }
                else{
                    dif++;
                }
                m/=2;
                n/=2;
            }
            if(m!=0 && n==0) {
                if(m%2==1) {
                    dif++;
                }
                m/=2;
            }
            if(m==0 && n!=0) {
                if(n%2==1) {
                    dif++;
                }
                n/=2;
            }
        }
        return dif;
    }
    int[][] counts = new int[3][];
    public int countSum(int n) {
        /*
        counts[0][0] = 0; counts[0][0] = 1; counts[0][0] = 1;
        counts[1][0] = 0; counts[1][0] = 0; counts[1][0] = 1;
        counts[2][0] = 1; counts[2][0] = 1; counts[2][0] = 1;
        if(n<3) {
            return counts[0][n-1]+counts[1][n-1]+counts[2][n-1];
        }
        for(int i = 1;i<n;i++) {
            cows3 = counts[2];
            counts[2] +=counts[1];
            counts[1] =counts[0];
            counts[0] =cows3;
        }
        return (counts[0]+counts[1]+counts[2])%1000000007;*/
        return 0;
    }
    public int getPos(int[] A, int n, int val) {
        int s = 0;
        int e = n-1;
        int c = (s+e)/2;
        while(s<=e) {
            c = (s+e)/2;
            if(val==A[c]) {
                int i = c;
                while(i-1>=s) {
                    if(A[i-1]==A[i]) {
                        i--;
                    }
                    else {
                        break;
                    }
                }
                return i;
            }
            else if(val<A[c]) {
                e = c - 1;
            }
            else {
                s = c + 1;
            }
        }
        return -1;
    }
    public boolean Find(int target, int [][] array) {
        int length1 = array.length;
        if(length1==0)
            return false;

        int length2 = array[0].length;
        if(length2==0)
            return false;
        System.out.println(" i:"+length1+"   j:"+length2);
        int i = 0;
        int j = 0;
        for( ;i<length2;i++) {
            if(array[0][i]>target) {
                break;
            }
        }
        for( ;j<length1;j++) {
            if(array[j][0]>target) {
                break;
            }
        }
        for(int ii = 0;ii<i;ii++) {
            for(int jj = 0;jj<j;jj++) {
                if(array[jj][ii]==target) {
                    return true;
                }
            }
        }
        return false;
    }
    public String replaceSpace(StringBuffer str) {
        String strs = str.toString();
        return strs.replaceAll(" ", "%20");
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList al = new ArrayList<Integer>();
        ArrayList a2 = new ArrayList<Integer>();
        while(listNode!=null) {
            //System.out.println(" 1:"+listNode.val);
            al.add(listNode.val);
            listNode = listNode.next;
        }
        for(int i = al.size()-1;i>=0;i--) {
            //System.out.println(" 2:"+al.get(i));
            a2.add(al.get(i));
        }
        return a2;
    }

    // 栈   先进后出
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    // 队列 先进先出
    public void push(int node) {
        // flag=1 使用stack1
        stack1.push(node);
    }
    public int pop() {
        while(stack1.empty()!=true) {
            stack2.push(stack1.pop());
        }
        int a = stack2.pop();
        while(stack2.empty()!=true) {
            stack1.push(stack2.pop());
        }
        return a;
    }
    public void reOrderArray(int [] array) {
        int[] ac = new int[array.length];
        int o = array.length - 1;
        int j = 0;
        int i = 0;
        for(;i<array.length;i++) {
            if(array[i]%2==0) {
                ac[o] = array[i];	// 偶数倒序排列
                o--;
            }
            else if(array[i]%2==1) {
                ac[j] = array[i];	// 奇数正序排列
                j++;
            }
        }
        int index = 0;
        while(index<j) {
            array[index] = ac[index];
            index++;
        }
        //index++;
        int index2 = array.length-1;
        while(index<array.length) {
            array[index] = ac[index2];
            index++;
            index2--;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
            ListNode ln1 = new ListNode(0);
            ListNode ln = ln1;
            ListNode p1 = list1;
            ListNode p2 = list2;
            while(p1!=null || p2!=null) {
                if(p1!=null && p2!=null) {
                    if(p1.val>p2.val) {
                        ln.next = p2;
                        p2 = p2.next;
                    }
                    else {
                        ln.next = p1;
                        p1 = p1.next;
                    }
                }else if(p1!=null && p2==null){
                    ln.next = p1;
                    p1 = p1.next;
                }else if(p2!=null && p1==null){
                    ln.next = p2;
                    p2 = p2.next;
                }
                ln = ln.next;

            }
            return ln1.next;
        }
    // 判断是不是后序遍历
    /*对于二叉搜索树的后续遍历：删去最后一个元素，剩下的可分为<最后元素和>最后元素的两类*/
    public boolean VerifySquenceOfBST(int [] sequence) {
        return isSquenceOfBST(0, sequence.length-1, sequence);
    }
    public static boolean isSquenceOfBST(int s, int e, int[] array) {

        return true;
    }
    public static int qiuou() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int length = str.length();
        int sum = 0;        // 偶串个数
        for(int i = 0;i<length;i++) {
            for(int j = 0;j<length-i+1;j++) {
                // 获取子串
                String s = str.substring(i, i+j);
                if(s.length()<=0) {
                    continue;
                }
                //System.out.print(""+s+" "+sum+"");
                HashMap hm = new HashMap();
                if(new IniString().isO(s)) {
                    sum++;
                }
            }
        }
        return sum;
    }
    public static boolean isO(String str) {
        HashMap hm = new HashMap();
        for(int i = 0;i<str.length();i++) {
            if(!hm.containsKey(str.charAt(i))) {
                hm.put(str.charAt(i), str.charAt(i));
            }
            else{
                hm.remove(str.charAt(i), str.charAt(i));
            }
        }
        if(hm.isEmpty()) {
            return true;
        }
        return false;
    }
}
