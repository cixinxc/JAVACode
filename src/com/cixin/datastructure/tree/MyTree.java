package com.cixin.datastructure.tree;

import com.cixin.common.MyTreeNode;
import com.cixin.learning.Code.List.LinkList;

import java.util.LinkedList;
import java.util.TreeMap;

public class MyTree<T> {
    // ���ڵ�
    private MyTreeNode root = null;
    // ���췽��
    public MyTree() {}

    public MyTree(MyTreeNode root) {
        this.root = root;
    }
}
