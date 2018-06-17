package com.cixin.datastructure.tree;

import com.cixin.common.MyTreeNode;

public class MyTree<T> {

    private MyTreeNode root = null;

    public MyTree() {}

    public MyTree(MyTreeNode root) {
        this.root = root;
    }

    public void preOrder() {
        preOrder(this.root);
    }
    public void preOrder(MyTreeNode root) {
        if(root==null) {
            return;
        }
        System.out.println(root.getData());
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    public void inOrder() {
        inOrder(this.root);
    }
    public void inOrder(MyTreeNode root) {
        if(root==null) {
            return;
        }
        inOrder(root.getLeftChild());
        System.out.println(root.getData());
        inOrder(root.getRightChild());
    }

    public void postOrder() {
        postOrder(this.root);
    }
    public void postOrder(MyTreeNode root) {
        if(root==null) {
            return;
        }
        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        System.out.println(root.getData());
    }
}
