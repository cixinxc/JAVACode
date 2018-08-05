package com.cixin.DesignPatterns.Mediator;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String args[]) {
		List<InsightInfo> campaign = new ArrayList<>();
		List<InsightInfo> adset = new ArrayList<>();
		List<InsightInfo> ads = new ArrayList<>();
		InsightInfo insightInfo1 = new InsightInfo(-1.0, 1, 1, 1);
		InsightInfo insightInfo2 = new InsightInfo(2.0, -2, 2, 2);
		InsightInfo insightInfo3 = new InsightInfo(3.0, 3, 3, 3);
		int days = 20;
		for(int i = 0;i<days;i++) {
			campaign.add(insightInfo1);
			adset.add(insightInfo2);
			ads.add(insightInfo3);
		}
		Field[] fields = InsightInfo.class.getDeclaredFields();
		List<String> ls = new ArrayList<>();
		for(Field f:fields) {
			ls.add(f.getName());
		}
		List<List<InsightInfo>> lists = Arrays.asList(campaign, adset, ads);

		for (int i = 0; i < fields.length; i++) {
			StringBuffer content = new StringBuffer();
			fields[i].setAccessible(true);
			try {
				for(int j = 0;j<days;j++) {
					StringBuffer sb = new StringBuffer();
					sb.append("<tr>");
					for(int k = 0;k<lists.size()+2;k++) {
						if(k<lists.size()) {
							sb.append(check(fields[i].get( lists.get(k).get(k)), fields[i].getGenericType().toString().substring(6)));
						} else {
							if(k<lists.size()+1){
								sb.append(colsFun(lists,0, 1, j,fields[i]));
							} else {
								sb.append(colsFun(lists,0, 2, j,fields[i]));
							}
						}
					}
					sb.append("</tr>");
					content.append(sb);
				}
				//System.out.println(content);
				System.out.println();
			} catch (IllegalArgumentException e) {
					e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			System.out.println(content);
		}
	}

	private static String colsFun(List<List<InsightInfo>> ls, int a, int b, int i, Field field) {
		StringBuffer sb = new StringBuffer();
		try {
			if(field.getGenericType().toString().substring(6).equals(Double.class.getTypeName())) {
				sb.append(subInfo((Double)(field.get(ls.get(a).get(i))), (Double)field.get(ls.get(b).get(i)), thr(field.getName())));
			} else if(field.getGenericType().toString().substring(6).equals(Integer.class.getTypeName())) {
				sb.append(subInfo((Integer) (field.get(ls.get(a).get(i))), (Integer)field.get(ls.get(b).get(i)), thr(field.getName())));
			} else {
				sb.append("-");
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	private static String subInfo(int a, int b, int thr) {
		StringBuffer sb = new StringBuffer();
		String color = Math.abs(a-b)>=thr?"red":"black";
		if(a<0 || b<0) {
			sb.append("<td><font color=red>-</font></td>");
		} else {
			sb.append(String.format("<td><font color=%s>", color
			)).append(a-b)
			.append("</font></td>");
		}
		return sb.toString();
	}
	private static String subInfo(double a, double b, int thr) {
		StringBuffer sb = new StringBuffer();
		String color = Math.abs(a-b)>=thr?"red":"black";
		DecimalFormat df =new DecimalFormat("0.00");
		if(a<0 || b<0) {
			sb.append("<td><font color=red>-</font></td>");
		} else {
			sb.append(String.format("<td><font color=%s>", color
			)).append(df.format(a-b))
					.append("</font></td>");
		}
		return sb.toString();
	}
	private static int thr(String field) {
		switch (field) {
			case "spent": return 1;
			case "cicks": return 2;
			case "reach": return 3;
			case "impression": return 4;
		}
		return 0;
	}

	private static String check(Object o, String str) {
		if(str.equals(Integer.class.getTypeName())) {
			return check((int) o);
		} else if(str.equals(Double.class.getTypeName())) {
			return check((double) o);
		} else {
			return "<td><font color=red>-</font></td>";
		}
	}
	private static String check(int data) {
		StringBuffer sb = new StringBuffer();
		if(data<0) {
			sb.append("<td><font color=red>-</font></td>");
		} else {
			sb.append(String.format("<td><font color=black>")).append(data)
					.append("</font></td>");
		}
		return sb.toString();
	}
	private static String check(double data) {
		StringBuffer sb = new StringBuffer();
		if(data<0) {
			sb.append("<td><font color=red>-</font></td>");
		} else {
			sb.append(String.format("<td><font color=black>")).append(data)
					.append("</font></td>");
		}
		return sb.toString();
	}
}
