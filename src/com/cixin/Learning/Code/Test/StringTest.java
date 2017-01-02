package com.cixin.Learning.Code.Test;

public class StringTest {
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer();
		System.out.println(sb);
		sb.append("ab");
		System.out.println(sb);
		
		String a = "ab";
		System.out.println(sb.toString()==a);
		String b = "ab";
		System.out.println(b==a);
		
		String c = "a"+"b";
		System.out.println(c==a);
		System.out.println( ((Object)c).toString());
		
		StringBuilder ss = new  StringBuilder();
		System.out.println(ss);
		ss.append("ab");
		System.out.println(ss);
		
		int at = 8;
		int bt = 0;
		while( (bt = (at-=1)) !=1 )
		{
			System.out.println("at"+at+"	bt"+bt);
		}
		
	}
}
