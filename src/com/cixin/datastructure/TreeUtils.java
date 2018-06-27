package com.cixin.datastructure;

import com.cixin.common.MyAVLNode;
import com.cixin.common.MyTreeNode;

import java.util.ArrayList;
import java.util.List;

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

    public static void levelOrder(MyAVLNode root) {
        ArrayList<ArrayList<MyAVLNode>> lists = new ArrayList<>();
        ArrayList<MyAVLNode> l = new ArrayList<MyAVLNode>();
        l.add(root);
        lists.add(l);
        levelOrder(lists);
        for(ArrayList<MyAVLNode> list:lists) {
            System.out.println();
            for(MyAVLNode node:list) {
                if(node!=null) {
                    System.out.print(""+node.getData()+"("+node.getHeight()+")\t");
                } else {
                    System.out.print("nil"+"\t");
                }

            }
        }
    }
    private static void levelOrder(ArrayList<ArrayList<MyAVLNode>> list) {
        ArrayList<MyAVLNode> pre = list.get(list.size()-1);
        ArrayList<MyAVLNode> cur = new ArrayList<>();
        int t = pre.size();
        int nullNum = 0;
        for(MyAVLNode node:pre) {
            if(node==null) {
                cur.add(null);cur.add(null);
                nullNum++;
            } else {
                cur.add(node.getLeftChild());
                cur.add(node.getRightChild());
            }
        }
        list.add(cur);
        if(nullNum==t) {
            return;
        } else {
            levelOrder(list);
        }
    }
}
