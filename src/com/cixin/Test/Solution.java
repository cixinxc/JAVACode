package com.cixin.Test;
import java.util.Map.Entry;
import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;

import java.util.*;
import java.util.Iterator;
class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;
         ArrayList<String> as = new ArrayList<>();
     }
 }
/*
public class Solution {
    public static void main(String[] args){}
    private static ArrayList<TreeNode> al = new ArrayList<TreeNode>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree.left!=null) Convert(pRootOfTree.left);
        if(pRootOfTree.left==null && pRootOfTree.right==null) visit(pRootOfTree);
        if(pRootOfTree.left!=null) Convert(pRootOfTree.left);
        return al.get(0);
    }
    public static void visit(TreeNode pRootOfTree) {
        if(al.size()>=1) {
            //al.get(al.size()-1).left = pRootOfTree;
            al.get(al.size()-1).right = pRootOfTree;
            pRootOfTree.left = al.get(al.size()-1);
            //pRootOfTree.right = al.get(al.size()-1);
            al.add(pRootOfTree);
        }else {
            al.add(pRootOfTree);
        }
    }
}
*/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
 class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null) return null;
        LinkedHashMap<Integer, ListNode> hm = new LinkedHashMap<Integer, ListNode>();
        LinkedHashMap<Integer, ListNode> hm2 = new LinkedHashMap<Integer, ListNode>();
        ListNode ph = pHead;
        while(ph!=null) {
            if(hm.containsKey(ph.val)) {
                hm2.remove(ph.val);
            }else {
                hm.put(ph.val, ph);
                hm2.put(ph.val, ph);
            }
            ph = ph.next;
        }
        //new ArrayList<String>(map.values());
        ArrayList<ListNode> ls= new ArrayList<ListNode>(hm2.values());
        if(ls.size()==0)return null;
        ls.get(0).next = null;
        for(int j = 1;j<ls.size();j++) {
            ls.get(j-1).next = ls.get(j);
            ls.get(j).next = null;
        }
        return ls.get(0);
    }
     public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
         ArrayList<Integer> al0 = new ArrayList<Integer>();
         ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i = 0;i<input.length;i++) {
            al0.add(input[i]);
        }
        if(al.size()<k)
            return al;
         Collections.sort(al0);
         for(int i = 0;i<k;i++) {
             al.add(al0.get(i));
         }
         return al;
     }
     public int FirstNotRepeatingChar(String str) {
        if(str.length()==0 || str==null) return -1;
        ArrayList<Character> alc = new ArrayList<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0;i<str.length();i++) {
            alc.add(i, '0');
            if(hm.containsKey(str.charAt(i))) {
                if(alc.indexOf(str.charAt(i))!=-1)
                    alc.set(alc.indexOf(str.charAt(i)), '0');
            } else {
                hm.put(str.charAt(i), i);
                alc.add(i, str.charAt(i));
            }
        }
        int t = -1;
        boolean f = false;
        for(int i = 0;i< alc.size();i++) {
            if(alc.get(i)!='0') {
                f = true;t = i;break;
            }
        }
        if(f) return t;
        return 0;
     }
     public int GetUglyNumber_Solution(int index) {
         if(index==1) return 1;
         int t = 1;
         int i = 2;
         while(t<index) {
            if(isUgly(i)) {
                t++;
            }
            i++;
         }
         return i;
     }
     public static boolean isUgly(int n) {
        if(n%4==0) return false;
        for(int i = 6;i<n;i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
     }

     public int GetUglyNumber_Solution2(int n)
     {
         if(n<=0)return 0;
         ArrayList<Integer> list=new ArrayList<Integer>();
         list.add(1);
         int i2=0,i3=0,i5=0;
         while(list.size()<n)//循环的条件
         {
             int m2=list.get(i2)*2;
             int m3=list.get(i3)*3;
             int m5=list.get(i5)*5;
             int min=Math.min(m2,Math.min(m3,m5));
             list.add(min);
             if(min==m2)i2++;
             if(min==m3)i3++;
             if(min==m5)i5++;
         }
         return list.get(list.size()-1);
     }
     public ArrayList<String> Permutation(String str) {
         ArrayList<String> als = new ArrayList<>();
         if(str==null || str.length()==0) return als;
         getStrs(str, new StringBuffer(),als);
         return als;
     }
     public static void getStrs(String str, StringBuffer sb,ArrayList<String> als) {
        if(str==null || str.length()==0) {
            if(!als.contains(sb.toString()))
                als.add(sb.toString());
            return;
        } else {
            for(int i = 0;i<str.length();i++) {
                StringBuffer ss = new StringBuffer();
                for(int j = 0;j<str.length();j++) {
                    if(j!=i) {
                        ss.append(str.charAt(j));
                    }
                }
                getStrs(ss.toString(), new StringBuffer(sb.toString()+str.charAt(i)), als);//sb.append(str.charAt(i))
            }
        }
     }
     public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)
            return false;
        if(sequence.length==1)
            return true;
        return ju(sequence, 0, sequence.length-1);
    }
    public boolean ju(int[] a,int star,int root){
        if(star>=root)
            return true;
        int i = root;
        //从后面开始找
        while(i>star&&a[i-1]>a[root])
            i--;//找到比根小的坐标
        // 从前面开始找 star到i-1应该比根小
        for(int j = star;j<i-1;j++)
            if(a[j]>a[root])
                return false;;
        return ju(a,star,i-1)&&ju(a, i, root-1);
    }
     public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i = 0;i<array.length;i++) {
            if(hm.containsKey(array[i])) {
                hm.put(array[i], hm.get(array[i])+1);
            } else {
                hm.put(array[i], 1);
            }
        }
        for(Integer i:hm.keySet()) {
            if(hm.get(i)>(array.length/2)) {
                return hm.get(i);
            }
        }
        return 0;
     }

     public static ArrayList<Integer> min = new ArrayList<>();
     public static ArrayList<Integer> max = new ArrayList<>();
     public static int minM = 0;
     public static int maxM = 0;
     public void Insert(Integer num) {
         if(min.size()==0 || max.size()==0 ) {
             if(min.size()==0) {
                 min.add(num);
                 return;
             }
             if(max.size()==0) {
                 if(num>min.get(0)) {
                     int tem = min.get(0);
                     min.remove(0);
                     min.add(num);
                     max.add(tem);
                 } else {
                     max.add(num);
                 }
             }
             return;
         }
         Collections.sort(max); if(max.size()>=1) maxM = max.get(max.size()-1); // 放小数
         Collections.sort(min); if(min.size()>=1) minM = min.get(0);            // 放大数

         if(min.size()==max.size()) {
            if(num>minM) {
                min.add(num);
            } else {
                max.add(num);
            }
         } else if(min.size()==(max.size()-1)) {
            if(num<maxM) {
                int tem = max.get(max.size()-1);
                max.remove(max.size()-1);
                max.add(num);
                min.add(tem);
            } else {
                min.add(num);
            }
         } else if(min.size()==(max.size()+1)) {
             if(num>minM) {
                 int tem = min.get(0);
                 min.remove(0);
                 min.add(num);
                 max.add(tem);
             } else {
                 max.add(num);
             }
         }
     }

     public Double GetMedian() {
         Collections.sort(min); if(min.size()>=1) minM = min.get(0);
         Collections.sort(max); if(max.size()>=1) maxM = max.get(max.size()-1);
         if(min.size()==max.size() ) {
             return (minM+maxM)/2.0;
         }
         if(min.size()>max.size() )
             return 1.0*min.get(0);
         return 1.0*max.get(max.size()-1);
     }
     public String LeftRotateString(String str,int n) {
         if(n>str.length()) return "";
         StringBuffer sb = new StringBuffer();
         for(int i = n;i<str.length();i++) {
             sb.append(str.charAt(i));
         }
         for(int i = 0;i<n;i++) {
             sb.append(str.charAt(i));
         }
         return sb.toString();
     }
     private boolean isBalanced=true;
     public boolean IsBalanced_Solution(TreeNode root) {
         getDepth(root);
         return isBalanced;
     }
     public int getDepth(TreeNode root){
         if(root==null)
             return 0;
         int left=getDepth(root.left);
         int right=getDepth(root.right);
         if(Math.abs(left-right)>1){
             isBalanced=false;
         }
         return right>left ?right+1:left+1;
     }
     boolean isSymmetrical(TreeNode pRoot)
     {
         if(pRoot == null){
             return true;
         }
         return comRoot(pRoot.left, pRoot.right);
     }
     private boolean comRoot(TreeNode left, TreeNode right) {
         if(left == null) return right==null;
         if(right == null) return false;
         if(left.val != right.val) return false;
         ArrayList<Character> al = new ArrayList<>();

         return comRoot(left.right, right.left) && comRoot(left.left, right.right);
     }
     public static void main(String[] args) {
        ArrayList<String>al = new Solution().Permutation("aa");
     }



     public static ListNode sort(ListNode head){
         if (head == null || head.next == null)
             return head;
         ListNode mid = getMiddle(head); //获取中间结点
         // 断开
         ListNode midNext = mid.next;
         mid.next = null;
         //排序，合并
        return mergeTwoLists(sort(head), sort(midNext));
     }

        /**
/* 获取链表的中间结点,偶数时取中间第一个
/* @param head/
         * @return
 */
    public static ListNode getMiddle(ListNode head){
        if (head == null || head.next == null){//空或只有一个
            return head;
        }

            ListNode fast, slow;////快慢指针
            fast = slow = head;
            //快2步，慢一步
            while (fast.next != null && fast.next.next != null) {
                //偶数时取第一个
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

            /**
      ?????* 实现合并两个已经排序的链表
      ?????* @param l1
      ?????* @param l2
      ?????* @return
      ?????*/
     public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         //特殊情况
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode first = l1.next, second = l2.next;
        ListNode res, newHead;
        //结果
        if (l1.val < l2.val){
            newHead = res = l1;
            second = l2;
        }else {
            newHead = res = l2;
            first = l1;
        }
        while (first != null || second != null){
            if (first == null){ //第一条链表没了
                res.next = second;
                return newHead;
            } else if (second == null) {
                //第二条链表空了
                res.next = first;
                return newHead;
            } else if (first.val < second.val){
                //第一个值小
                res.next = first;
                first = first.next;
                res = res.next;
            } else {
                res.next = second;
                second = second.next;
                res = res.next;
            }
        }
        return newHead;
     }

    public int main() {

        Entry<Integer, Integer> a ;
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0;i<N;i++) {
            int temp = in.nextInt();
            if(!al.contains(temp)) {
                al.add(temp);
            }
        }
        if(al.size()<3) {
            return 0;
        }
        Collections.sort(al);
        return al.get(3);
     }
}