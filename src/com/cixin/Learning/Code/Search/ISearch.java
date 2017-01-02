package com.cixin.Learning.Code.Search;

import com.cixin.Learning.Model.Data;

/**
 * Created by cixinxc on 2017/1/2.
 */
public interface ISearch {
    public void showResult();
    public Object getResult();
    public Data[] sort();
    public Data[] sort(Data[] ds);
}
