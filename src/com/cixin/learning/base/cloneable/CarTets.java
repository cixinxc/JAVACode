package com.cixin.learning.base.cloneable;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CarTets {
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Set up before class");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Set up");
    }
    @Test
    public void tests() {
        LinkedList<Integer> ls1 = new LinkedList<>();
        LinkedList<Integer> ls2 = new LinkedList<>();
        for(int i = 0;i<10;i++) {
            ls1.add(i);
        }
        ls2.add(1);
        ls2.add(4);
        ls2.add(5);
        ls2.add(9);
        int index = 0;
        for(int i = 0;i<10;i++) {
            if(index<ls2.size()) {
                if(ls1.get(i)<ls2.get(index)) {
                    ls2.add(index, i);
                    index+=1;
                } else if(ls1.get(i)>ls2.get(index)) {

                } else {
                    index++;
                }
            } else {
                ls2.add(i);
                index++;
            }

        }
        for(int i:ls2) {
            System.out.println(i+"  ");
        }
    }
}



