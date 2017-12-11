package com.cixin.Algorithm.LeetCode;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSumClosest(nums, 1));
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
