package com.cixin.datastructure.tree;

import com.cixin.common.MyTreeNode;
import com.cixin.learning.Code.List.LinkList;

import java.util.LinkedList;
import java.util.TreeMap;

public class MyTree<T> {
    // 根节点
    private MyTreeNode root = null;
    // 构造方法
    public MyTree() {}

    public MyTree(MyTreeNode root) {
        this.root = root;
    }
}
