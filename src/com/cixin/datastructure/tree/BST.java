package com.cixin.datastructure.tree;

import com.cixin.common.MyTreeNode;

/**
 * @author cixin
 */
public class BST<T> extends MyTree{
    private MyTreeNode root = null;

    public BST() {}

    public BST(MyTreeNode root) {
        this.root = root;
    }

    public void insert(MyTreeNode node) {
        insert(node, this.root);
    }
    public void insert(MyTreeNode node, MyTreeNode root) {
        if(root==null) {
            root = node;
        } else if(root.getData().compareTo(node.getData())>0) {
            if(root.getLeftChild()==null) {
                root.setLeftChild(node);
            } else {
                insert(node, root.getLeftChild());
            }
        } else if(root.getData().compareTo(node.getData())<0) {
            if(root.getRightChild()==null) {
                root.setRightChild(node);
            } else {
                insert(node, root.getRightChild());
            }
        } else {
            return;
        }
    }

    public MyTreeNode getRoot() {
        return root;
    }

    public void setRoot(MyTreeNode root) {
        this.root = root;
    }
}
