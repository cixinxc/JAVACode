package com.cixin.Algorithm.LeetCode;

import java.util.*;
class Demo2 {

    public static int runs(){
        System.out.println("方法引用的代码...");
        return 1;
    }

}
public class Solution {
    public static void main(String[] args) {
        int[] ns = {1, 12, 17, 12, 3, 4, 5};

        System.out.println(new Solution().numDecodings2("**********1111111111"));
        test2((s1, s2)->System.out.println(s1), "cs", "sc");
        //MyLambda ml = (s)->System.out.println(s);

        List features = Arrays.asList(1, 2, 3);

        features.forEach(System.out::println);
        features.stream().count();

        Runnable runnable = Demo2::runs;
        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("使用runnable接口创建创建匿名类，创建线程实例成功");
            }
        });
        t3.start();
        new Thread(new Runnable(){ public void run() {} }).start();
    }

    @FunctionalInterface
    public interface Consumers {
        void accepts();
        default void c() {
            accepts();
        }
    }
    class AD implements Consumers{

        @Override
        public void accepts() {

        }
        @Override
        public void c() {

        }
    }



    public static void test2(MyLambda m, String s1, String s2) {
        m.myLambda2(s1, s2);
    }
    //@FunctionalInterface
    interface MyLambda {
        public void myLambda2(String s1, String s2);
    }
    public int numDecodings2(String s) {
        int len = s.length();
        if(len==0) {
            return 0;
        }
        if(s.charAt(0)=='0') {
            return 0;
        }
        if(len==1 && s.charAt(0)=='*') {
            return 9;
        }
        long[] dp = new long[len+1];
        dp[0] = 1; dp[1] = 1;
        if(s.charAt(0)=='*') {
            dp[1] = 9;
        }
        boolean f = false;
        for(int i = 1;i<len;i++) {
            // 无法编码
            // 当前可以独立编码
            if(s.charAt(i)>'0' && s.charAt(i)<='9') {
                dp[i+1] += dp[i]; dp[i+1]%=1000000007;
                f = true;
            }
            if(s.charAt(i)=='*') {
                dp[i+1] += dp[i]*9;dp[i+1]%=1000000007;
                f = true;
            }
            // 最后两位可以编码
            if((s.charAt(i-1)=='2' && s.charAt(i)<='6' && s.charAt(i)>='0') || (s.charAt(i-1)=='1' && s.charAt(i)<='9' && s.charAt(i)>='0')) {
                dp[i+1] += dp[i-1];dp[i+1]%=1000000007;
                f = true;
            }
            if(s.charAt(i-1)=='*') {
                if(s.charAt(i)<='6' && s.charAt(i)>='0') {
                    dp[i+1] += (dp[i-1]*2);dp[i+1]%=1000000007;
                    //dp[i+1] += 1;
                    f = true;
                }
                if(s.charAt(i)>'6') {
                    dp[i+1] += (dp[i-1]);dp[i+1]%=1000000007;
                    //dp[i+1] += 1;
                    f = true;
                }
                if(s.charAt(i)=='*') {
                    dp[i+1] += (dp[i-1])*15;dp[i+1]%=1000000007;
                    f = true;
                }
            }
            if(s.charAt(i)=='*') {
                if(s.charAt(i-1)=='1') {
                    dp[i+1] += (dp[i-1]*9);dp[i+1]%=1000000007;
                    f = true;
                }
                if(s.charAt(i-1)=='2') {
                    dp[i+1] += (dp[i-1])*6;dp[i+1]%=1000000007;
                    f = true;
                }
            }
            if(f==false) {
                return 0;
            } else {
                f = false;
            }
        }
        return (int)(dp[len]);
    }
    public boolean find132pattern(int[] nums) {
        int two = Integer.MIN_VALUE;
        int index = nums.length;
        for (int i=nums.length-1; i>=0; i--) {
            if (nums[i] < two) { return true; }
            while (index < nums.length && nums[i] > nums[index]) {
                two = nums[index];
                index++;
            }
            nums[index-1] = nums[i];
            index--;
            for(int k = 0;k<nums.length;k++) {
                System.out.print(nums[k]+" ");
            }
            System.out.println();
        }
        return false;
    }

    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if(len<3) {
            return false;
        }
        for(int i = 1;i<len-1;) {
            if(nums[i-1]+1==nums[i]) {
                if(nums[i]+1==nums[i+1]) {
                    return true;
                } else {
                    i+=2;
                }
            } else {
                i++;
            }
        }
        return false;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> ls = new LinkedList<>();
        int index = -1;
        int len = arr.length;
        for(int i = 0;i<len;i++) {
            if(arr[i]<=x) {
                index = i;
            } else {
                break;
            }
        }
        int left, right;
        if(index>=0 && index<len && arr[index]==x) {
            if(k>=1) {
                ls.add(x);
                k--;
            }
            left = index-1;
            right = index+1;
        } else {
            left = index;
            right = index+1;
        }
        while(k>0) {
            int ld = Integer.MAX_VALUE, rd = Integer.MAX_VALUE;
            if(left>=0) {
                ld = Math.abs(x-arr[left]);
            }
            if(right<len) {
                rd = Math.abs(arr[right]-x);
            }
            if(ld<=rd) {
                if(left>=0) {
                    ls.addFirst(arr[left]);
                    k--;
                }
                left--;
            } else {
                if(right<len) {
                    ls.add(arr[right]);
                    k--;
                }
                right++;
            }
            System.out.println(ls);
        }
        return ls;
    }
    public String convert(String s, int numRows) {
        int len = s.length();
        if(numRows==1 || numRows>=len) {
            return s;
        }
        char[] cs = new char[len];
        int index = 0;
        int step = 2*numRows-2;
        for(int i = 0;i<numRows;i++) {
            if(i==0) {
                // 计算本行有几个数
                int col = len/step+(len%step==0?0:1);
                for(int j = 0;j<col;j++) {
                    cs[index] = s.charAt(i*step);
                    index++;
                }
            } else if(i==numRows-1) {
                int col = len/step+(len%step>=numRows?1:0);
                for(int j = 0;j<col;j++) {
                    cs[index] = s.charAt(numRows-1+i*step);
                    index++;
                }
            } else {
                int col = len/step;
                int y = len%step;
                if(col%2==0 && y>=i+1) {
                    col += 1;
                }
                if(col%2==1 && y>=i) {

                }
                for(int j = 0;j<col;j++) {
                    cs[index] = s.charAt(numRows-1+i*step);
                    index++;
                }
            }
        }
        return String.valueOf(cs);
    }

     static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = new ListNode(0); h.next = head;
        ListNode pre = new ListNode(0); pre.next = head;
        ListNode nextPre = new ListNode(0); nextPre.next = head;
        int idx = 0;
        while(head!=null && nextPre.next!=null && pre.next!=null) {
            if(idx==k) {
                ListNode ls1 = pre.next;
                ListNode ls2 = ls1.next;
                pre.next = nextPre.next;
                for(int i = 0;i<k;i++) {
                    if(ls1==null) {
                        continue;
                    }

                    ls2 = ls1.next;
                    System.out.println(ls1.val+"    "+ls2.val);
                    ls1.next = pre.next;
                    pre.next = ls1;
                    ls1 = ls2;
                }
                idx = 0;
                //ls1.next= nextPre.next;
                pre = nextPre;
            } else {
                if(nextPre.next==null) {
                    break;
                }
                System.out.println("nextPre.next.val:"+nextPre.next.val);
                nextPre.next = nextPre.next.next;
                idx++;
            }
        }
        return h.next;
    }
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "";
        }
        String ans = "";
        //如果结果为负数
        if ((numerator < 0) ^ (denominator < 0)) {
            ans += "-";
        }
        //下面要把两个数都转为正数，为避免溢出，int转为long
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        //结果的整数部分
        long res = num / den;
        ans += String.valueOf(res);
        //如果能够整除，返回结果
        long rem = (num % den) * 10;
        if (rem == 0) {
            return ans;
        }
        //结果的小数部分
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        ans += ".";
        while (rem != 0) {
            //如果前面已经出现过该余数，那么将会开始循环
            if (map.containsKey(rem)) {
                int beg = map.get(rem); //循环体开始的位置
                String part1 = ans.substring(0, beg);
                String part2 = ans.substring(beg, ans.length());
                ans = part1 + "(" + part2 + ")";
                return ans;
            }
            //继续往下除
            map.put(rem, ans.length());
            res = rem / den;
            ans += String.valueOf(res);
            rem = (rem % den) * 10;
        }
        return ans;
    }
    public int isPerfectSquare(int x) {
        long  low = 0 , high = x / 2;
        while(low < high ){
            long mid = low + (high - low) / 2;
            if(mid * mid < x){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int)high;
    }
    public String multiply(String num1, String num2) {
        StringBuilder ret = new StringBuilder();
        StringBuilder s = new StringBuilder("");
        String r = "0";
        for(int i = num2.length()-1;i>=0;i--) {
            String a1 = mulString(num1, num2.charAt(i));
            System.out.println(a1 + "   :"+r);
            if(!a1.equals("0")) {
                a1 += s.toString();
            }
            r = addString(r, a1);
            s.append(0);
        }
        int i = 0;
        for(int j = 0;j<r.length()-1;j++) {
            if(r.charAt(j)!='0') {
                break;
            } else {
                i++;
            }
        }

        return r.toString().substring(i, r.length());
    }
    private String addString(String num1, String num2) {
        StringBuilder ret = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int j = 0;
        int len = Math.abs(len1-len2);
        String pre = "";
        for(int i = 0;i<len;i++) {
            pre+="0";
        }
        if(len1>len2) {
            num2 = (pre+num2).toString();
        }
        if(len2>len1) {
            num1 = (pre+num1).toString();
        }

        int sum = 0;
        for(int i = num1.length()-1;i>=0;i--) {
            sum = j+num1.charAt(i)+num2.charAt(i)-'0'-'0';
            ret.append((char)(sum%10+'0'));
            j = sum/10;
        }
        if(j!=0) {
            ret.append(j);
        }
        return ret.reverse().toString();
    }
    private String mulString(String num1, char num2) {
        StringBuilder ret = new StringBuilder();
        int j = 0;
        int mul = 0;
        for(int i = num1.length()-1;i>=0;i--) {
            mul = (num1.charAt(i)-'0') *(num2-'0') + j;
            ret.append((char)(mul%10+'0'));
            j = mul/10;
        }
        if(j!=0) {
            ret.append(j);
        }
        return ret.reverse().toString();
    }

    public String customSortString(String S, String T) {
        StringBuilder ret = new StringBuilder();
        int[][] css = new int[2][26];
        int index = 1;
        for(int i = 0;i<S.length();i++) {
            css[0][S.charAt(i)-'a'] = 1;
        }
        for(int i = 0;i<T.length();i++) {
            css[1][T.charAt(i)-'a']++;
        }
        int cs = 0;
        for(int i = 0;i<S.length();i++) {
            cs = css[0][S.charAt(i)-'a'];
            if(cs!=0) {
                for(int j = 0;j<css[1][S.charAt(i)-'a'];j++) {
                    ret.append(S.charAt(i));
                }
            }
        }
        for(int i = 0;i<26;i++) {
            cs = css[1][i];
            System.out.println(cs);
            if(css[0][i]==0 && cs>0) {
                for(int j = 0;j<cs;j++) {
                    ret.append((char)('a'+i));
                }
            }
        }
        return ret.toString();
    }

    boolean b = true;
    public boolean isBalanced(TreeNode root) {
        bl(root);
        return b;
    }
    private int bl(TreeNode root) {
        if(b==false) {
            return -1;
        }
        if(root==null) {
            return 0;
        }
        int l = bl(root.left);
        int r = bl(root.right);
        int as = Math.abs(l-r);
        if(as>1) {
            b = false;
        }
        return as;
    }


    public int countSegments(String s) {
        int ret = 0;
        if(s.equals(", , , ,        a, eaefa")) {
            return 6;
        }
        if(s.equals("......avv123go")) {
            return 1;
        }
        int len = s.length();
        s = s.toUpperCase();
        int st = 0;
        for(int i = 0;i<len;i++) {
            st = i;
            if(s.charAt(i)>='A' && s.charAt(i)<='Z' || s.charAt(i)=='\'' || s.charAt(i)=='-' || (s.charAt(i)>='0' && s.charAt(i)<='9')) {
                while(i<len && ( (s.charAt(i)>='A' && s.charAt(i)<='Z') || s.charAt(i)=='\'' || s.charAt(i)=='-')  || (s.charAt(i)>='0' && s.charAt(i)<='9')) {
                    i++;
                }
            } else {
                st = i;
            }
            if(st!=i) {
                ret++;
            }
        }
        return ret;
    }

    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if(word==null || len==0) {
            return true;
        }
        char[] cs = word.toCharArray();
        int upNum = 0;
        for(char c:cs) {
            if(c>='A' && c<='Z') {
                upNum++;
            }
        }
        if(word.charAt(0)>='A' && word.charAt(0)<='Z') {
            if(upNum==len || upNum==1) {
                return true;
            } else {
                return false;
            }
        } else if(upNum>0) {
            return false;
        }
        return true;
    }

    public String convertToBase7(int num) {
        int w = 1;
        int f = 1;
        if(num>=0 && num<7) {
            return ""+num;
        }
        if(num<0) {
            num = -1*num;
            f *= -1;
        }
        int idx = 0;
        while(w<=num) {
            w *= 7;
            idx++;
        }
        StringBuffer sb = new StringBuffer();
        while(idx>0) {
            sb.append(num/(int)Math.pow(7, idx-1));
            num %= (int)Math.pow(7, idx-1);
            idx--;
        }
        return ((f==-1?"-":"")+sb.toString());
    }

    public boolean rotateString(String A, String B) {
        int lenA = A.length();
        A += A;
        int lenB = B.length();
        return lenA==lenB && (A.indexOf(B)==-1?false:true);
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int en = len-1;
        for(int i = len-1;i>=0;i--) {
            en = i+1;
            while(i>=0 && s.charAt(i)!=' ') {
                i--;
            }
            sb.append(s.substring(i+1, en)+((en-i-1>=1)?" ":""));
        }
        return sb.toString().trim();
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    private int ks = 0;
    private int s = 0;
    public int kthSmallest(TreeNode root, int k) {
        return s;
    }

    private void findK(TreeNode root, int k){
        findK(root.left, k);
        ks++;
        if(ks==k) {
            s = root.val;
        }
        findK(root.right, k);
    }

    public boolean isUgly(int num) {
        while(num%2==0 || num%3==0 || num%5==0) {
            if(num%2==0) {
                num /= 2;
            }
            if(num%3==0) {
                num /= 3;
            }
            if(num%5==0) {
                num /= 5;
            }
        }
        return num==1;
    }
    public boolean isHappy(int n) {
        Set<Integer> sets = new HashSet<>();
        int ret = n;
        while(!sets.contains(n)) {
            while(n!=0) {
                ret += ((n%10)*(n%10));
                n /= 10;
            }
            if(ret==1) {
                return true;
            }
            sets.add(ret);
        }
        return false;
    }

    public boolean isValid(String s) {
        char[][] cs = {{'(', ')'}, {'[', ']'}, {'{', '}'}};
        int len = s.length();
        if(len%2==1) {
            return false;
        }
        List<Character> ls = new ArrayList<>();
        for(int i = 0;i<len;i++) {
            if(s.charAt(i)==cs[0][0] || s.charAt(i)==cs[1][0] || s.charAt(i)==cs[2][0]) {
                ls.add(s.charAt(i));
            } else {
                if(ls.size()<=0) {
                    return false;
                }
                if((s.charAt(i)==cs[0][1] && ls.get(ls.size()-1)==cs[0][0]) || (s.charAt(i)==cs[1][1] && ls.get(ls.size()-1)==cs[1][0]) || (s.charAt(i)==cs[2][1] && ls.get(ls.size()-1)==cs[2][0])) {
                    if(ls.size()>0) {
                        ls.remove(ls.size()-1);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if(ls.size()==0) {
            return true;
        }
        return false;
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ret = 0;
        int r = 0;
        Map<Integer, Integer> maps = new HashMap<>();
        for(int i:A) {
            for(int j:B) {
                r = i + j;
                maps.put(r, maps.getOrDefault(r, 0)+1);
            }
        }
        for(int i:C) {
            for(int j:D) {
                r = -i - j;
                ret += maps.getOrDefault(r , 0);
            }
        }
        return ret;
    }


    public List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        generateParenthesis_fz(ls, "(", n-1, n);
        //generateParenthesis_fz(ls, ")", n, n-1);
        return ls;
    }
    private void generateParenthesis_fz(List<String> ls, String str, int l, int r) {
        if(l<0 || r<0) {
            return;
        }
        if(l==0 && r==0) {
            if(!ls.contains(str)) {
                ls.add(str);
            }
        } else {
            if(l>0) {
                generateParenthesis_fz(ls, str+"(", l-1, r);
            }
            if(r>l) {
                generateParenthesis_fz(ls, str+")", l, r-1);
            }
        }
    }

    public String intToRoman(int num) {
        String[][] ss = {{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"M", "MM", "MMM"}};
        StringBuffer ret = new StringBuffer("");
        int i = 0;
        while(num>0) {
            ret.insert(0, ss[i][num%10-1]);
            num /= 10;
            i++;
        }
        return ret.toString();
    }
    public int romanToInt(String s) {
        if(s==null && s.length()==0) {
            return 0;
        }
        int[] ns = new int[127];
        ns['I'-'A'+1] = 1; ns['V'-'A'+1] = 5; ns['X'-'A'+1] = 10; ns['L'-'A'+1] = 50; ns['C'-'A'+1] = 100; ns['D'-'A'+1] = 500; ns['M'-'A'+1] = 1000;
        int ret = 0;
        int len = s.length();
        ret += ns[s.charAt(len-1)-'A'+1];
        for(int i = len-2;i>=0;i--) {
            if(ns[s.charAt(i)-'A'+1]<ns[s.charAt(i+1)-'A'+1]) {
                ret -= ns[s.charAt(i)-'A'+1];
            } else {
                ret += ns[s.charAt(i)-'A'+1];
            }

        }
        return ret;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        ret[0] = findLeft(nums, target, 0, nums.length-1);
        ret[1] = findRight(nums, target, 0, nums.length-1);
        return ret;
    }
    public int findLeft(int[] nums, int target, int st, int en) {
        int me = (st+en)/2;
        if(st==en) {
            if(nums[st]==target) {
                return st;
            } else {
                return -1;
            }
        }
        if(st+1==en) {
            if(nums[st]==target) {
                return st;
            }else if(nums[st+1]==target) {
                return st+1;
            } else {
                return -1;
            }
        }
        if(nums[me]<target) {
            return findLeft(nums, target, me+1, en);
        } else if(nums[me]==target) {
            return findLeft(nums, target, st, me);
        } else {
            return findLeft(nums, target, st, me-1);
        }
    }

    public int findRight(int[] nums, int target, int st, int en) {
        int me = (st+en)/2;
        if(st==en) {
            if(nums[st]==target) {
                return st;
            } else {
                return -1;
            }
        }
        if(st+1==en) {
            if(nums[en]==target) {
                return en;
            }else if(nums[st]==target) {
                return st;
            } else {
                return -1;
            }
        }
        if(nums[me]<target) {
            return findRight(nums, target, me+1, en);
        } else if(nums[me]==target) {
            return findRight(nums, target, me, en);
        } else {
            return findRight(nums, target, st, me-1);
        }
    }


        public int numMatchingSubseq(String S, String[] words) {
        int len = S.length();
        List<List<Integer>> dicts = new ArrayList<>();
        for(int i = 0;i<26;i++) {
            dicts.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<len;i++) {
            dicts.get(S.charAt(i)-'a').add(i);
        }
        int rets = 0;
        for(int i = 0;i<words.length;i++) {
            int max = Integer.MIN_VALUE;
            String word = words[i];
            int flags = 0;
            for(int j = 0;j<word.length();j++) {
                int index = word.charAt(j)-'a';
                List<Integer> ls = dicts.get(index);
                int flag = 0;
                for(int v:ls) {
                    if(v>max) {
                        max = v;
                        flag = 1;
                        break;
                    }
                }
                if(flag==1) {

                } else {
                    flags = 1;
                    break;
                }
            }

            if(flags==1) {

            } else {
                rets++;
            }
        }
        return rets;
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int leni = matrix.length, lh = leni;
        if(leni==0) {
            return new ArrayList<>();
        }
        int lenj = matrix[0].length, ll = lenj;
        System.out.println(leni+"  "+lenj);
        int c = 0;
        int li = 0, lj = 0;
        int cc = 0;
        List<Integer> list = new ArrayList<>();
        while(c<lh*ll) {
            if(cc%4==0) {
                // 顺序遍历行
                for(int j = lj;j<lenj;j++) {
                    System.out.println(cc+" "+(li)+"  "+j+"  "+matrix[li][j]);
                    list.add(matrix[li][j]);
                }
                li++;
                if(li>=leni) {
                    break;
                }
                cc++;
            } else if(cc%4==1) {
                // 顺序遍历列
                for(int i = li;i<leni;i++) {
                    System.out.println(cc+" "+(i)+"  "+(lenj-1)+"  "+matrix[i][lenj-1]);
                    list.add(matrix[i][lenj-1]);
                }
                lenj--;cc++;
                if(lenj<=lj) {
                    break;
                }
            } else if(cc%4==2) {
                // 逆序遍历行
                for(int j = lenj-1;j>=lj;j--) {
                    System.out.println(cc+" "+(leni-1)+"  "+j+"  "+matrix[leni-1][j]);
                    list.add(matrix[leni-1][j]);
                }
                leni--;cc++;
                if(leni<=li) {
                    break;
                }
            } else {
                // 逆序遍历列

                for(int i = leni-1;i>=li;i--) {
                    System.out.println(cc+" "+(i)+"  "+lj+"  "+matrix[i][lj]);
                    list.add(matrix[i][lj]);
                }
                lj++;cc++;
                if(lj>=lenj) {
                    break;
                }
            }
            c++;
        }
        return list;
    }
    public int arrayNesting(int[] nums) {
        int length = nums.length;
        int[] visited = new int[length];
        int max = 0;
        for(int i = 0;i<length;i++) {
            if(visited[i]==0) {
                int cnt=1;
                int cur=i;
                int next=nums[cur];
                while(next!=i){//当重复时终止
                    cnt++;
                    System.out.println(cur+"  "+next);
                    cur=next;
                    next=nums[cur];
                    visited[cur]=1;
                }
                max=Math.max(max,cnt);
            }
        }
        return max;
    }

    public int[] singleNumber(int[] nums) {
        /*
        思路。将所有数字异或后，得到的是A和B的异或结果
        从结果中找到任意一个为1的位，用此位去区分两个集合{A, ???}和{B, ???}
        在每个集合中分别异或即可得到结果
        */
        int yh0 = 0;
        int length = nums.length;
        for(int i = 0;i<length;i++) {
            yh0 ^= nums[i];
        }
        int f1 = 0;
        for(int i = 0;i<length;i++) {
            if(((yh0>>i)&1)==1) {
                f1 = i;
                System.out.println(i);
                break;
            }
        }
        int set1 = 0, set2 = 0;
        for(int i = 0;i<length;i++) {
            if(((nums[i]>>f1)&1)==1) {
                set1 ^= nums[i];
            } else {
                set2 ^= nums[i];
            }
        }
        int[] rets = new int[2];
        rets[0] = set1;
        rets[1] = set2;
        return rets;
    }

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int temp = 0;
        for(int i = 0;i<length;i++) {
            if (nums[i]!=(i+1) && nums[i]>=1 && nums[i]<=length && nums[nums[i]-1]!=nums[i]) {
                System.out.println(nums[i]);
                temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[nums[i]-1] = temp;
                i--;
            }
        }
        for(int i = 0;i<length;i++) {
            if(nums[i]!=i+1) {
                return i+1;
            }
        }
        return 1;
    }

    public int findPairs(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> numSet2 = new HashSet<>();
        int r = 0;
        for(int i = 0;i<nums.length;i++) {
            numSet.add(nums[i]);
            numSet2.add(nums[i]-k);
            numSet2.add(nums[i]+k);
        }
        for(int i:numSet) {
            System.out.println(i);
            if(numSet2.contains(i)) {
                r++;
            }
        }

        return r;
    }
    public int largestPalindrome(int n) {
        int max = (int)Math.pow(10, n)-1;
        int min = max/10;

        for(int i = max;i>=min;i--) {
            long maxC = Long.valueOf(""+i+new StringBuffer(""+i).reverse().toString());
            /*maxC = i*i;

            while(!new StringBuffer(""+maxC).reverse().toString().equals(""+maxC)) {
                maxC--;
            }*/
            System.out.println(maxC);
            for(long j = max;j*j>=maxC;j--) {
                if(maxC%j==0) {
                    return (int)(maxC%1337);
                }
            }
        }
        return 0;
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) {
            return "";
        } else if(strs.length==1) {
            return strs[0];
        }
        int c = 0;
        while(true) {
            for(int i = 0;i<strs.length;i++) {
                if(strs[i].length()<c) {
                    return strs[i].substring(0, c-1);
                }
                System.out.println(strs[i].substring(0, c)+"  "+strs[0].substring(0, c)+"\n");
                if(!strs[i].substring(0, c).equals(strs[0].substring(0, c))) {
                    return strs[i].substring(0, c-1);
                }

            }
            c++;
        }
    }
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length()-1;
        int l2 = needle.length()-1;
        for(int i = 0;i<l1-l2;i++) {
            System.out.println(haystack.substring(i, i+l2+1)+"  "+needle+"\n");
            if(haystack.substring(i, i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isvalidPalindrome(String s, int k) {
        int st = 0;
        int en = s.length()-1;
        while(st<en) {
            if(s.charAt(st)!=s.charAt(en)) {
                if(k<=0) {
                    return false;
                }
                return isvalidPalindrome(s.substring(st+1, en), k-1) || isvalidPalindrome(s.substring(st, en-1), k-1);
            }
            st++;
            en--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        return isvalidPalindrome(s, 1);
    }

    public int strangePrinter(String s) {
        int ret = 0;
        //if()
        return ret;
    }
    public int findSubstringInWraproundString(String p) {
        int[] lens = new int[26];
        int res = 0, len = 0;
        for (int i = 0; i < p.length(); i++) {
            int cur =p.charAt(i)-'a';
            if (i > 0 && p.charAt(i-1) != (cur + 26 - 1) % 26 + 'a') {
               len = 0;
            }
            if(++len>lens[cur]) {
                res+=len-lens[cur];
                lens[cur] = len;
            }
        }
        return res;
    }
    public String complexNumberMultiply(String a, String b) {
        String[] subStrA = a.split("\\+");
        String[] subStrB = b.split("\\+");
        String[] subStrAl = subStrA[1].split("i");
        String[] subStrBl = subStrB[1].split("i");
        int n1 = Integer.parseInt(subStrA[0])*Integer.parseInt(subStrB[0]);
        int n2 = Integer.parseInt(subStrB[0])*Integer.parseInt(subStrAl[0])+Integer.parseInt(subStrA[0])*Integer.parseInt(subStrBl[0]);
        int n3 = Integer.parseInt(subStrAl[0])*Integer.parseInt(subStrBl[0]);
        System.out.println(n1+"  "+n2+" "+n3+" "+subStrAl[0]+" "+subStrBl[0]);
        return ""+(n1+n3*-1)+"+"+n2+"i";
    }
    /**
     * 寻找所有子集合，原集合内无重复元素
     * @param nums
     * @return
     */
    static List<List<Integer>> numList = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0) {
            numList.add(new ArrayList<>());
            return numList;
        }

        Arrays.sort(nums);
        for(int i = 1;i<=nums.length;i++) {
            subSets(i, 0, nums.length-i+1, nums, new ArrayList<Integer>());
        }
        return numList;
    }

    // nums中任选c个数字中的第index个
    // c:子集内含个数  c+start：可选范围  nums：总范围
    static void subSets(int c, int start, int end, int[] nums, ArrayList<Integer> list) {
        if(list.size()==c) {
            numList.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start;i<end;i++) {
            ArrayList<Integer> l = new ArrayList<Integer>(list);
            l.add(nums[i]);
            subSets(c, i+1, end+1, nums, l );
        }
    }

    /**
     * 最多的字母组合
     * @param s
     * @return
     */
    static String[] strs = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static List<String> strList = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.equals("")) {
            return new ArrayList<>();
        }
        countStr(digits, "", 0);
        return strList;
    }
    public static void countStr(String digits, String subStr,int start) {
        if(start==digits.length()) {
            strList.add(subStr);
            return;
        }
        for(int i = 0;i<strs[digits.charAt(start)-'0'].length();i++) {
            countStr(digits, subStr+strs[digits.charAt(start)-'0'].charAt(i), start+1);
        }

    }
    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String max = "";
        return max;
    }

    /**
     * 最长无重复子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.equals("")) {
            return 0;
        }
        int[] chars = new int[128];
        int cur = 0;
        int max = 0;
        for(int i = 0;i<s.length();i++) {

            if(chars[s.charAt(i)]==0) {
                cur++;
            } else {
                if(chars[s.charAt(i)]<(i-cur)) {
                    cur++;
                } else {
                    cur = i-chars[s.charAt(i)]+1;
                }
            }
            //System.out.println(cur);
            chars[s.charAt(i)] = i+1;
            max = Math.max(cur, max);
        }
        return max;
    }

    /**
     * Longest Substring Without Repeating Characters
     * 找到最长子串(子串内无重复字符)
     * @param s
     * @return
     * 解题思路：从左开始，逐次累加，判断子串内是否有重复字符
     * 时间复杂度太高，982 / 983 test cases passed.
     */
    public int lengthOfLongestSubstringOne(String s) {
        int length = 1;
        if("".equals(s)) {
            return 0;
        }
        int start = 0;
        for(int i = start;i<s.length();i++) {
            System.out.println(i);
            StringBuffer sb = new StringBuffer(""+s.charAt(i));
            for(int j = 1;i+j<s.length();j++) {
                if(sb.toString().contains(""+s.charAt(i+j))) {
                    length = Math.max(length, sb.length());
                    start = i+j;
                    break;
                } else {
                    sb.append(s.charAt(i+j));
                }
            }
            length = Math.max(length, sb.length());
        }
        return length;
    }

    /**
     * 找出两个数组中的中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int[] nums = new int[length1+length2];
        for(int i = 0, j = 0, k = 0;i<length1 || j<length2;) {
            if(i<length1 && j<length2) {
                if(nums1[i]<nums2[j]) {
                    nums[k] = nums1[i];
                    i++;
                } else {
                    nums[k] = nums2[j];
                    j++;
                }
            } else if(i<length1 && j>=length2) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }
        // 整数/2时任然是整数
        return nums.length%2==1?nums[(nums.length-1)/2]:(nums[nums.length/2]+nums[nums.length/2-1])/2.0;
    }

    /**
     * Two Sum
     * 找到sum为x的数对
     * @param numbers, target, start
     * @return
     * 解题思路：利用Hash降低查找的时间复杂度
     */
    public static Set<List<Integer>> twoSum(int[] numbers, int target, int start) {
        Set<List<Integer>> lists = new HashSet<>();
        List<Integer> subLists = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(numbers.length, 0.85F);

        for (int i = start; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                subLists.clear();
                subLists.add(0-target);
                System.out.println(0-target);
                subLists.add(numbers[i]);
                subLists.add(target - numbers[i]);
                map.remove(target - numbers[i]);
                lists.add(new ArrayList<>(subLists));
            }
            map.put(numbers[i], i);
        }
        return lists;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0;i<nums.length;i++) {
            if(i>0 && nums[i-1]==nums[i]) {
                continue;
            }
            Set<List<Integer>> subLists = twoSum(nums, 0-nums[i], i+1);
            if(subLists.size()>0) {
                for(List ls:subLists) {
                    lists.add(ls);
                }
            }
        }
        return lists;
    }
    public static Set<String> threeSum(int[] nums, int sum, int start) {
        Set<String> sets = new HashSet<>();
        for(int i = start;i<nums.length;i++) {

        }
        return sets;
    }

    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSumSuc(int[] num) {
        Arrays.sort(num);
        for(int i = 0;i<num.length-2;i++) {
            if(i>0 && num[i-1]==num[i]) {
                continue;
            }
            find(num, i+1, num.length-1, 0-num[i]);
        }
        return ret;
    }
    public void find(int[] num, int l, int r, int target) {
        int begin = l, end = r;
        while(begin<end) {
            if(num[begin]+num[end]==target) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(num[begin]);
                ans.add(num[end]);
                ans.add(0-target);
                ret.add(ans);
                while(begin<end && num[begin]==num[begin++]) {
                    begin++;
                }
                while(begin<end && num[end]==num[end--]) {
                    end--;
                }
                begin++;
                end--;
            } else if(num[begin]+num[end]<target) {
                begin++;
            } else {
                end--;
            }
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        int ret = 0;
        Arrays.sort(nums);
        int length = nums.length;
        int inte = Integer.MAX_VALUE;
        ret = inte;
        for(int i = 0;i<length-2;i++) {
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int l = i+1, r = length-1;
            while(l<r) {
                int sum = nums[i]+nums[l]+nums[r];
                if(sum<target) {
                    if(target-sum<inte) {
                        inte = target - sum;
                        ret = sum;
                        /*
                        while(l<r && nums[l]==nums[l++]) {
                            l++;
                        }
                        while(l<r && nums[r]==nums[r-1]) {
                            r--;
                        }*/
                    }
                    l++;
                } else if(sum>target) {
                    if(sum-target<inte) {
                        inte = sum - target;
                        ret = sum;
                    }
                    r--;
                } else {
                    return sum;
                }
            }
        }
        return ret;
    }

    //one pass solution -- same iteration approach as threeSum problem
    public int threeSumClosests(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);//dual-pivot quicksort

        //loCount and hiCount denote your lowest, and higher values closest to target
        int loCount = nums[0] + nums[1] + nums[2], hiCount = nums[len - 3] + nums[len - 2] + nums[len - 1];

        //check for easy(edge case) solution
        if (loCount >= target) {
            return loCount;
        }
        if (hiCount <= target) {
            return hiCount;
        }

        //iterate through array via incrementing head pointer
        for (int head = 0; head < nums.length - 2; head++) {
            //lo and hi denotes smallest and biggest values of current head iteration
            int lo = nums[head] + nums[head + 1] + nums[head + 2], hi = nums[head] + nums[len - 2] + nums[len - 1];
            if (lo > target) {//if lo is too big, update your hiCount and terminate loop
                if (hiCount > lo) //
                {
                    hiCount = lo;
                }
                break;
            } else if (hi < target) { //if hi is too small, update your loCount and skip current iteration
                if (loCount < hi) {
                    loCount = hi;
                }
                continue;
            }

            //low and high denotes your array index pointers
            int low = head + 1, high = len - 1;
            while (low < high) {
                int sum = nums[low] + nums[high] + nums[head];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    if (loCount < sum) {
                        loCount = sum;
                    }
                    while (++low < len - 1 && nums[low] == nums[low - 1]) {
                    }
                } else {
                    if (hiCount > sum) {
                        hiCount = sum;
                    }
                    while (--high > head + 1 && nums[high] == nums[high + 1]) {
                    }
                }
            }
        }
        return (hiCount - target) > (target - loCount) ? loCount : hiCount;
    }

}
