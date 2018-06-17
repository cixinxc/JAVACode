package com.cixin.datastructure;

import com.cixin.common.MyTreeNode;
import com.cixin.datastructure.tree.BinarySortTree;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        BinarySortTree bst = new BinarySortTree(new MyTreeNode(50));
        System.out.println(bst);
        Random rand = new Random();
        for(int i = 1;i<100;i++) {
            bst.insert(new MyTreeNode(rand.nextInt(100)), bst.getRoot());
        }
        //inOrder(bst.getRoot());
        bst = new BinarySortTree(new MyTreeNode(8));
        //bst.insert(new MyTreeNode(8), bst.getRoot());

        bst.insert(new MyTreeNode(4), bst.getRoot());
        bst.insert(new MyTreeNode(2), bst.getRoot());
        bst.insert(new MyTreeNode(6), bst.getRoot());
        bst.insert(new MyTreeNode(1), bst.getRoot());
        bst.insert(new MyTreeNode(3), bst.getRoot());
        bst.insert(new MyTreeNode(5), bst.getRoot());
        bst.insert(new MyTreeNode(7), bst.getRoot());

        bst.insert(new MyTreeNode(12), bst.getRoot());
        bst.insert(new MyTreeNode(10), bst.getRoot());
        bst.insert(new MyTreeNode(14), bst.getRoot());
        bst.insert(new MyTreeNode(9), bst.getRoot());
        bst.insert(new MyTreeNode(11), bst.getRoot());
        bst.insert(new MyTreeNode(13), bst.getRoot());
        bst.insert(new MyTreeNode(15), bst.getRoot());
        int c = 1;
        if(c==1) {
            for(int i = 1;i<16;i++) {
                int t = rand.nextInt(15)+1;
                System.out.println("delete "+t);
                bst.delete(new MyTreeNode(t), bst.getRoot());
                inOrder(bst.getRoot());
            }
        } else {
            bst.delete(new MyTreeNode(8), bst.getRoot());
            inOrder(bst.getRoot());
        }


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