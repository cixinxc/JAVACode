package com.cixin.datastructure;

import com.cixin.common.MyAVLNode;
import com.cixin.common.MyTreeNode;
import com.cixin.datastructure.tree.AVLTree;
import com.cixin.datastructure.tree.BinarySortTree;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        /*
        BinarySortTree bst = new BinarySortTree(new MyTreeNode(50));
        Random rand = new Random();
        for(int i = 1;i<100;i++) {
            bst.insert(new MyTreeNode(rand.nextInt(100)), bst.getRoot());
        }
        bst = new BinarySortTree(new MyTreeNode(8));
        int[] leftNode = {4, 2, 6, 1, 3, 5, 7};
        //int[] rightNode = {12, 10, 14, 9, 11, 13, 15};
        int[] rightNode = {12, 10, 15, 9, 11, 13, 17, 14};
        for(int i:leftNode) {
            bst.insert(new MyTreeNode(i), bst.getRoot());
        }
        for(int i:rightNode) {
            bst.insert(new MyTreeNode(i), bst.getRoot());
        }

        int c = 1;
        if(c==1) {
            for(int i = 1;i<16;i++) {
                int t = rand.nextInt(15)+1;
                System.out.println("delete "+t);
                bst.delete(new MyTreeNode(t), bst.getRoot());
                TreeUtils.inOrder(bst.getRoot());
            }
        } else {
            bst.delete(new MyTreeNode(12), bst.getRoot());
            TreeUtils.inOrder(bst.getRoot());
        }
        */

        Random rand = new Random();

        AVLTree bst = new AVLTree(new MyAVLNode(8));
        //int[] leftNode = {4, 2, 6, 1, 3, 5, 7};
        int[] leftNode = {15, 14, 13, 12 , 11, 10 ,9 , 1, 2, 3, 4, 5, 6, 7};
        int[] rightNode = {12, 10, 14, 9, 11, 13, 15};
        //int[] rightNode = {12, 10, 15};
        for(int i:leftNode) {
            bst.insert(new MyAVLNode(i));
            //TreeUtils.levelOrder(bst.getRoot());
        }
        for(int i:rightNode) {
            //bst.insert(new MyAVLNode(i));
            //TreeUtils.levelOrder(bst.getRoot());
        }
        System.out.println("\ninsert complete!");
        //TreeUtils.inOrder(bst.getRoot());
        int c = 1;
        if(c==1) {
            for(int i = 1;i<16;i++) {
                int t = rand.nextInt(15)+1;
                System.out.println("delete "+t);
                bst.delete(new MyAVLNode(t));
                TreeUtils.levelOrder(bst.getRoot());
            }
        } else if(c==2) {
            bst.delete(new MyAVLNode(12));
            TreeUtils.levelOrder(bst.getRoot());
        } else {
            int[] delete = {5, 15, 12, 1, 11, 10, 9};
            for(int i:delete) {
                bst.delete(new MyAVLNode(i));
                TreeUtils.levelOrder(bst.getRoot());
            }
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