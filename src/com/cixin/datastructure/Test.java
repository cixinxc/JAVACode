package com.cixin.datastructure;

import com.cixin.common.MyTreeNode;
import com.cixin.datastructure.tree.BST;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        BST bst = new BST(new MyTreeNode(50));
        System.out.println(bst);
        Random rand = new Random();
        for(int i = 1;i<100;i++) {
            bst.insert(new MyTreeNode(rand.nextInt(100)), bst.getRoot());
        }

        System.out.println();
        inOrder(bst.getRoot());
    }

    public static void inOrder(MyTreeNode root) {
        if(root==null) {
            return;
        }
        inOrder(root.getLeftChild());
        System.out.println(root.getData());
        inOrder(root.getRightChild());
    }
}
