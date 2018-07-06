package com.cixin.common;

/**
 * @author cixinxc
 * @create 2018-07-01 20:19
 * @desc ºìºÚÊ÷½Úµã
 **/
public class MyRBNode<T extends Comparable> extends MyTreeNode{
    private RBColor color = RBColor.R;

    public MyRBNode getParent() {
        return parent;
    }

    public void setParent(MyRBNode parent) {
        this.parent = parent;
    }

    private MyRBNode parent;
    private MyRBNode leftChild;
    private MyRBNode rightChild;
    public MyRBNode() {
        super();
    }

    public MyRBNode(T t) {
        super();
        this.data = t;
    }

    public RBColor getColor() {
        return color;
    }

    public void setColor(RBColor color) {
        this.color = color;
    }

    @Override
    public MyRBNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(MyRBNode leftChild) {
        this.leftChild = leftChild;
    }
    @Override
    public MyRBNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(MyRBNode rightChild) {
        this.rightChild = rightChild;
    }
}
