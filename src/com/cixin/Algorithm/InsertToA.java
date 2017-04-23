package com.cixin.Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cixinxc on 2017/3/1.
 */
// 有序的数组A、B，A有足够的空间容纳B，编写算法将B合并到A
public class InsertToA {
    public static void main(String[] args) {
        List A = new ArrayList();
        List B = new ArrayList();

        for(int i = 0;i<10;i++) {
            A.add(i, (int)(Math.random()*100));
        }
        for(int i = 0;i<20;i++) {
            B.add((int)(Math.random()*100));
        }
        Collections.sort(A);
        int a = A.size();
        int b = (int)A.get(a-1);
        Collections.sort(B);
        InsertToA.insertToA(A, B);
        int as = 1;
    }
    public static void insertToA(List A, List B) {
        int aLength = A.size();
        int bLength = B.size();
        int count = aLength + bLength -1;
        while(aLength>0 && bLength>0) {
            if( (int)A.get(aLength-1)>=(int)B.get(bLength-1) ) {
             //   A.remove();
                A.add(A.get(aLength-1));
                aLength--;
            }else if( (int)A.get(aLength-1)<(int)B.get(bLength-1) ) {
                A.add(B.get(bLength-1));
                bLength--;
            }
            count--;
        }
    }
}
