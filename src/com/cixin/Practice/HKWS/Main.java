package com.cixin.Practice.HKWS;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++) {
            nums[i] = in.nextInt();
        }
        int count = 0;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                if(i==j) {
                    continue;
                }
                System.out.println(Long.valueOf(nums[i]+""+nums[j])%7);
                if(Long.valueOf(nums[i]+""+nums[j])%7==0) {
                    count++;
                }
            }
        }
        List<Integer> a = new ArrayList<>();
        List<Integer> aa =  Collections.synchronizedList(a);
        System.out.print(count);
        Iterator<Integer> it = a.iterator();
        while(it.hasNext()) {
            it.next();
        }
    }
    private static void test2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
    }
    private static void test() {
        Scanner in = new Scanner(System.in);
        ArrayList<BM> bms = new ArrayList<>();
        while(in.hasNextLine()) {
            String str = in.nextLine();
            String[] strs = str.split(";");
            // 部门数
            int n = strs.length;

            for(int i = 0;i<n;i++) {
                BM bm = new BM();
                bm.id = strs[i].split(",")[0];
                bm.name = strs[i].split(",")[1];
                bm.parentId = strs[i].split(",")[2];
                bms.add(new BM(bm));
            }
            zl(bms);
            shows(bms.get(0), bms.get(0).name);
        }
    }
    private static void show(ArrayList<BM> bms) {
        ArrayList<String> strs = new ArrayList<>();

    }
    private static void zl(ArrayList<BM> bms) {
        // 建立多叉树
        for(int i = 0;i<bms.size();i++) {
            for(int j = 0;j<bms.size();j++) {
                if(bms.get(j).parentId.equals(bms.get(i).id)) {
                    bms.get(i).nextList.add(bms.get(j));
                }
            }
        }
    }
    private static void shows(BM bms, String str) {
        if(bms.nextList.size()==0) {
            System.out.println(str);
            return;
        }
        // 获得所有子节点
        for(int i = 0;i<bms.nextList.size();i++) {
            shows(bms.nextList.get(i), str+"-"+bms.nextList.get(i).name);
        }
    }
}
class BM {
    public BM() {

    }
    public BM(BM bm) {
        this.id = bm.id;
        this.name = bm.name;
        this.parentId = bm.parentId;
    }
    String id = "";
    String name = "";
    ArrayList<BM> nextList = new ArrayList<>();
    String parentId = "";
}
