package com.cixin.Practice;

import java.util.*;

public class Learn {
    public static void main(String[] args) {
        // ArrayList add(�ǻ����������ͺ�String:��ַ���ݣ�����Ϊֵ����)
        List<Integer> numList = new ArrayList<>();
        int a = 0;
        numList.add(a);
        a = 2;
        System.out.println(numList.get(0));

        List<String> strList = new ArrayList<>();
        String str = "0";
        strList.add(str);
        str = "1";
        System.out.println(strList.get(0));

        List<A> aList = new ArrayList<>();
        A a1 = new A(); a1.a = 0;
        aList.add(a1);
        a1.a = 1;
        System.out.println(aList.get(0).a);

        // final ����ʱ���ɱ���
        B b = new B();
        b.b = 1;
        final B b2 = new B();
        //b2 = b;   // ����
        b2.a = new A();
        String A = "A", B = "B"; change(A, B);
        System.out.println("A:"+A.hashCode());
        System.out.println(A+"   "+B);
    }
    private static void change(String strA, String strB) {
        System.out.println("strA:"+strA.hashCode());
        System.out.println("�Ƚ�:"+strA=="A");
        strA = "AA";
        strB = "BB";
    }
}

class A {
    A() {
        ;
    }
    public int a;
}

final class B {
    public int b;
    A a;
}
