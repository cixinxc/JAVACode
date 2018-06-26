package com.cixin.datastructure.tree;

import com.cixin.common.MyAVLNode;

/**
 * @author cixinxc
 * @create 2018-06-25 20:59
 * @desc 我的AVL树
 **/
public class AVLTree<T extends Comparable> {
    private MyAVLNode<T> root;

    private void LL(MyAVLNode node) {
        /*
        *              node                   E
        *           E         H          D          node
        *       D      F             C            F     H
        *   C
        *
        *   从E开始不平衡
        *   需要修改
        *       node的左右节点
        *       E的右节点
        *
        * */
        MyAVLNode E = node.getLeftChild();
        MyAVLNode F = E.getRightChild();
        MyAVLNode H = node.getRightChild();

        MyAVLNode temp = new MyAVLNode();
        temp.setData(node.getData());
        node.setData(E.getData());
        node.setLeftChild(E.getLeftChild());

        E.setData(temp.getData());
        node.setRightChild(E);
        E.setLeftChild(F);
        E.setRightChild(H);
    }

    private void RR(MyAVLNode node) {
        /*
         *              node                                D
         *           A           D                   node        E
         *                   C       E            A       C           F
         *                              F
         *
         *   从D开始不平衡
         *   需要修改
         *       node的左右节点
         *       D的左节点
         *
         * */
        MyAVLNode D = node.getLeftChild();
        MyAVLNode C = D.getRightChild();
        MyAVLNode A = node.getRightChild();

        MyAVLNode temp = new MyAVLNode();
        temp.setData(node.getData());
        node.setData(D.getData());
        node.setRightChild(D.getLeftChild());

        D.setData(temp.getData());
        node.setRightChild(D);
        D.setLeftChild(A);
        D.setRightChild(C);
    }

    private void LR(MyAVLNode node) {
        /*
        *               F                       F                   C
        *           E       G               C       G          E        F
        *       A       C               E       D             A B      D G
        *              B  D           A   B
        * */
        RR(node.getLeftChild());
        LL(node);
    }

    private void RL(MyAVLNode node) {
        /*
         *               F                       F                   C
         *           E       G               C       G          E        F
         *       A       C               E       D             A B      D G
         *              B  D           A   B
         * */
        LL(node.getRightChild());
        RR(node);
    }

    public void insert(MyAVLNode node) {
        insert(this.root, node);
    }
    private void insert(MyAVLNode root, MyAVLNode node) {
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
        reBalance(root);
    }

    private static void reBalance(MyAVLNode root) {

    }


}
