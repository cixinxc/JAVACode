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
        System.out.println("˳�����");
        LinearSearch ls = new LinearSearch();
        System.out.println("���ҵ���λ��: "+ls.search(data, 14));
        */
        // ע�������±� datas[datas.length]Խ����
        System.out.println("���ֲ���");
        BinarySearch bs = new BinarySearch();
        System.out.println("���ҵ���λ��: "+bs.search(datas, 3));
        System.out.println("���ҵ���λ��: "+bs.binarySearch2(datas, 0, (datas.length-1), 3));

    }
}
