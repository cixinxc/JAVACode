package com.cixin.datastructure;

import com.cixin.common.MyAVLNode;
import com.cixin.common.MyRBNode;
import com.cixin.common.MyTreeNode;
import com.cixin.datastructure.tree.AVLTree;
import com.cixin.datastructure.tree.BinarySortTree;
import com.cixin.datastructure.tree.MyRBTree;

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
        /*
        Random rand = new Random();

        AVLTree bst = new AVLTree(new MyAVLNode(3));
        //int[] leftNode = {4, 2, 6, 1, 3, 5, 7};
        int[] leftNode = {2, 1, 4, 5, 6, 7, 16 ,15, 14 ,13, 12, 11, 10, 8, 9};
        int[] rightNode = {12, 10, 14, 9, 11, 13, 15};
        //int[] rightNode = {12, 10, 15};
        for(int i:leftNode) {
            bst.insert(new MyAVLNode(i));
            TreeUtils.levelOrder(bst.getRoot());
        }
        for(int i:rightNode) {
            //bst.insert(new MyAVLNode(i));
            //TreeUtils.levelOrder(bst.getRoot());
        }
        System.out.println("\ninsert complete!");
        //TreeUtils.inOrder(bst.getRoot());
        int c = 3;
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
            int[] delete = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
            for(int i:delete) {
                bst.delete(new MyAVLNode(i));
                TreeUtils.levelOrder(bst.getRoot());
            }
        }
        */
        Random rand = new Random();

        MyRBTree rbt = new MyRBTree(new MyRBNode(0));
        int[] leftNode = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        for(int i:leftNode) {
            rbt.insert(new MyRBNode(i));
            //TreeUtils.levelOrder(rbt.getRoot());
        }
        TreeUtils.levelOrder(rbt.getRoot());

        int[] deleteNode = {12, 1, 9, 2, 0, 11, 7, 19, 4, 15, 18, 5, 14, 13, 10, 16, 6, 3, 8, 17};
        for(int i = 0;i<20;i++) {
            rbt.delete(new MyRBNode(rand.nextInt(20)));
            //
        }TreeUtils.levelOrder(rbt.getRoot());
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