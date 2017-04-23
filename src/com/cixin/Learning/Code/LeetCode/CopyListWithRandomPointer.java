package com.cixin.Learning.Code.LeetCode;

/**
 * Created by cixinxc on 2017/4/2.
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Definition for singly-linked list with a random pointer.
 * */
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};



class Solutions {


    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode new_head = new RandomListNode(head.label);
        RandomListNode new_p = new_head;
        RandomListNode old_p = head.next;
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
        hm.put(head, new_head);
        while(old_p != null) {
            RandomListNode ls = new RandomListNode(old_p.label);
            new_p.next = ls;
            hm.put(old_p, ls);
            new_p = new_p.next;
            old_p = old_p.next;
        }

        new_p = new_head;
        old_p = head;
        while(old_p != null) {
            new_p.random = hm.get(old_p.random);
            new_p = new_p.next;
            old_p = old_p.next;
        }

        return new_head;
    }

    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i = 0;i<A.length;i++) {
            if(hm.get(A[i])==null) {
                hm.put(A[i], 1);
            }else if(hm.get(A[i])==1) {
                hm.put(A[i], 2);
            }else if(hm.get(A[i])==2) {
                hm.remove(A[i]);
            }
        }
        int k = 1;
        for(int i = 0;i<A.length;i++) {
            if(hm.containsKey(A[i])) {
                k = A[i];
            }
        }
        return k;
    }
}

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solutions s = new Solutions();
        int[] A = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
        System.out.println(s.singleNumber(A));
    }
}
