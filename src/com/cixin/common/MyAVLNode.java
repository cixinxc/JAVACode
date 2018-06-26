package com.cixin.common;

import java.util.Comparator;

/**
 * @author cixinxc
 * @create 2018-06-25 20:59
 * @desc 我自己的AVL节点
 **/
public class MyAVLNode<T extends Comparable> extends MyTreeNode {

    protected MyAVLNode leftChild = null;
    protected MyAVLNode rightChild = null;
    private int height;


    public MyAVLNode() {
        this.height = 0;
        this.leftChild = null;
        this.rightChild = null;
        this.data = null;
    }

    public MyAVLNode(T data) {
        this();
        this.data = data;
    }

    public int getHeight() {
        if(this==null) {
            return 0;
        }
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public MyAVLNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(MyAVLNode leftChild) {
        this.leftChild = leftChild;
    }
    @Override
    public MyAVLNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(MyAVLNode rightChild) {
        this.rightChild = rightChild;
    }
}
