package com.cixin.learning.Code.Search.Search;

import com.cixin.learning.Code.Search.ISearch.ISearch;

/**
 * Created by cixinxc on 2017/3/1.
 */
public class LinearSearch implements ISearch{

    @Override
    public int search(int[] data, int value) {
        int i = 0;
        for(;i<data.length;i++) {
            if(data[i]==value) {
                break;
            }
        }
        if(i>=data.length) {
            return -1;
        }else{
            return i;
        }
    }
}
