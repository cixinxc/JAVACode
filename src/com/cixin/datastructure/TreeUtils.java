package com.cixin.datastructure;

import com.cixin.common.MyAVLNode;
import com.cixin.common.MyTreeNode;

/**
 * @author cixinxc
 * @create 2018-06-17 17:25
 * @desc MyTree的工具类
 **/
public class TreeUtils {

    /**
     * @author cixinxc
     * @create 2018-06-17 17:25
     * @desc 对节点的访问
     **/
    private static void visit(MyTreeNode node) {
        System.out.println(node.getData());
    }
    public static void preOrder(MyTreeNode root) {
        if(root==null) {
            return;
        }
        visit(root);
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    public static void inOrder(MyAVLNode root) {
        if(root==null) {
            return;
        }
        inOrder(root.getLeftChild());
        visit(root);
        inOrder(root.getRightChild());
    }

    public static void inOrder(MyTreeNode root) {
        if(root==null) {
            return;
        }
        inOrder(root.getLeftChild());
        visit(root);
        inOrder(root.getRightChild());
    }

    public static void postOrder(MyTreeNode root) {
        if(root==null) {
            return;
        }
        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        visit(root);
    }
}
