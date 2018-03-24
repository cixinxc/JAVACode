package com.cixin.Algorithm.LeetCode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String S = "abcde";
        String[] words = {"a", "acd", "acce", "bb"};
        int[] A = {1, 2, 3};
        int[] B = {1, 2, 3};
        int[][] as = {A, B};
        int n = 11;

        System.out.println(as.length+" "+as[0].length);
        System.out.println("rs: "+new Solution().isHappy(19));
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
