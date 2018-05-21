package com.cixin.learning.Code.Search.Search;

import com.cixin.learning.Code.Search.ISearch.ISearch;

/**
 * Created by cixinxc on 2017/3/1.
 */
public class BinarySearch implements ISearch {
    @Override
    public int search(int[] data, int value) {
        return binarySearch(data, 0, (data.length-1), value);
    }
    public int binarySearch(int[] data, int start, int end,int value) {
        int index = (start+end)/2;
        int goal = -1;
        if(data[start]<=value && data[index]>value) {
            goal = binarySearch(data, start, (index-1), value);
        }else if(data[index]<value && data[end]>=value) {
            goal = binarySearch(data, (index+1), end, value);
        }else if(data[index]==value){
            goal =  index;
        }else {
            return goal;
        }
        return goal;
    }
    public int binarySearch2(int[] data, int start, int end,int value) {
        int goal = -1;
        // 此处start<=end和start!=end的区别
        while(start<=end) {
            int index = (start+end)/2;
            if(data[index]==value) {
                System.out.println("zhong  "+index);
                return index;
            }else if(data[start]<=value && data[index]>value) {
                end = index-1;
            }else if(data[index]<value && data[end]>=value) {
                start = index+1;
            }else{
                return -1;
            }
        }
        return goal;
    }
}
