package com.cixin.common;

public class MyTreeNode<T extends Comparable> implements Comparable {
    protected T data;
    protected MyTreeNode leftChild = null;
    protected MyTreeNode rightChild = null;

    public MyTreeNode() {}

    public MyTreeNode(T data) {
        this.data = data;
    }


    public boolean equals() {
        return equals();
    }

    @Override
    public boolean equals(Object data) {
        return this.data.equals(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(MyTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public MyTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(MyTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(Object o) {
        return this.data.compareTo(((MyTreeNode)o).getData());
    }
}
