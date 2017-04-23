package com.cixin.Learning.Code.Search.Search;

import com.cixin.Learning.Code.Search.ISearch.ISearch;
import com.cixin.Learning.Model.Data;

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
