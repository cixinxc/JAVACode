package com.cixin.Learning.Code.base.ArrayAndString;

/**
 * Created by cixinxc on 2017/2/24.
 */
public class ArrayTest {
    public static void main(String[] arg) {
        //创建数组
        //int[] intArray0 = new int[];  错误初始化
        //int[] intArray0; //由于没有初始化，无法输出intArray0.length
        int[] intArray1 = {1, 2};
        int[] intArray2 = new int[3];
        int[] intArray3 = new int[]{1, 2, 3, 4};
        System.out.println("    "+intArray1.length+"    "+intArray2.length+"    "+intArray3.length);

        String str0 = "ab";
        String str1 = "ab";
        String str2 = "a"+"b";
        String str3 = "";
        str3 +="ab";
        String str4 = "";
        str4 = ""+"ab";
        System.out.println("str0==str1    "+ (str0==str1));         //true
        System.out.println("str0==str2    "+(str0==str2));         //true
        System.out.println("str0==str3    "+(str0==str3));         //false
        System.out.println("str0==str4    "+(str0==str4));         //true
        str0 = "aaaaa";
        System.out.println("str0==str1:    "+ (str0==str1)+"    str0:"+str0+"    str1:"+str1);         //false
        System.out.println(str0.equals(str1));  //true
        System.out.println(str0.equals(str2));  //true
        System.out.println(str0.equals(str3));  //true

        System.out.println("intArray1.length:"+intArray1.length+"    intArray2.length:"+intArray2.length+"    intArray3.length:"+intArray3.length);
    }
}
