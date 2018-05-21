package com.cixin.learning.Code.base.ArrayAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cixinxc on 2017/2/24.
 */
public class ArrayListTest {
    public static void main(String[] arg) {
        List<String> al1 = new ArrayList<String>();
        String[] strs = new String[]{"ab", "cd", "ef","jh"};

        for(String str:strs) {
            al1.add(str);
        }
        al1.add(0,"kk");

        System.out.println("str.length:"+strs.length+"    al1.size():"+al1.size());
        System.out.println("");
        for(String str:al1) {
            System.out.println(str);
        }
        System.out.println("");
        for(String str:al1) {
            System.out.println(str);
        }
        System.out.println("");
        for(String str:al1) {
            System.out.println(str);
        }
        System.out.println(al1.get(0)+"al1½áÊø");
        Map<Integer, String> hash = new HashMap<>();
        hash.put(1, "11");
        hash.put(2, "22");
        hash.put(3, "33");

        for(int i:hash.keySet()) {
            System.out.println("hash key is :"+i);
        }
        for(String str:hash.values()) {
            System.out.println("hash value is :"+str);
        }
        System.out.println("al1.size():"+al1.size()+"    hash.size():"+hash.size());


    }
}
