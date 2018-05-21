package com.cixin.learning.Code.Search;

import com.cixin.learning.Code.Search.Search.BinarySearch;
import com.cixin.learning.Common.Common;

/**
 * Created by cixinxc on 2017/3/1.
 */
public class SearchTest {
    public static void main(String[] args) {
        int data[] = Common.getSearchArray(10, 7, 14);
        int datas[] = Common.getArray(10);
        /*
        System.out.println("顺序查找");
        LinearSearch ls = new LinearSearch();
        System.out.println("查找到的位置: "+ls.search(data, 14));
        */
        // 注意数组下标 datas[datas.length]越界了
        System.out.println("二分查找");
        BinarySearch bs = new BinarySearch();
        System.out.println("查找到的位置: "+bs.search(datas, 3));
        System.out.println("查找到的位置: "+bs.binarySearch2(datas, 0, (datas.length-1), 3));

    }
}
