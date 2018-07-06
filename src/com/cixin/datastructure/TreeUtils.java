package com.cixin.datastructure;

import com.cixin.common.MyAVLNode;
import com.cixin.common.MyRBNode;
import com.cixin.common.MyTreeNode;
import com.cixin.datastructure.tree.MyRBTree;

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

    public static void levelOrder(MyRBNode root) {
        ArrayList<ArrayList<MyRBNode>> lists = new ArrayList<>();
        ArrayList<MyRBNode> l = new ArrayList<MyRBNode>();
        l.add(root);
        lists.add(l);
        levelOrders(lists);
        levelPrints(lists);
    }

    private static void levelPrints(ArrayList<ArrayList<MyRBNode>> lists) {
        System.out.println();
        int index = 1;
        int str = 1;
        int len = lists.size();
        int wordLen = 6;

        for(ArrayList<MyRBNode> list:lists) {
            str = (int)Math.pow(2, len-index-1);
            //System.out.println(str);
            if((len==index)) {
                System.out.printf("%-"+wordLen/2+"s", " ");
            }
            for(MyRBNode node:list) {

                for(int i = 0;i<str;i++) {
                    System.out.printf("%-"+wordLen+"s", "");
                }

                if(node!=null) {
                    System.out.printf("%-"+wordLen+"s", (""+node.getData()+"("+node.getColor()+")"));
                } else {
                    System.out.printf("%-"+wordLen+"s", "nil");
                }
            }
            index++;
            System.out.println();
        }
        System.out.println();
    }
    private static void levelOrders(ArrayList<ArrayList<MyRBNode>> list) {
        ArrayList<MyRBNode> pre = list.get(list.size()-1);
        ArrayList<MyRBNode> cur = new ArrayList<>();
        int t = pre.size();
        int nullNum = 0;
        for(MyRBNode node:pre) {
            if(node==null) {
                cur.add(null);cur.add(null);
                nullNum++;
            } else {
                cur.add(node.getLeftChild());
                cur.add(node.getRightChild());

            }
        }
        //System.out.println(t+"  "+nullNum);
        if(t==nullNum) {
            return;
        } else {
            list.add(cur);
            levelOrders(list);
        }
    }



    public static void levelOrder(MyAVLNode root) {
        ArrayList<ArrayList<MyAVLNode>> lists = new ArrayList<>();
        ArrayList<MyAVLNode> l = new ArrayList<MyAVLNode>();
        l.add(root);
        lists.add(l);
        levelOrder(lists);
        levelPrint(lists);
    }
    private static void levelPrint(ArrayList<ArrayList<MyAVLNode>> lists) {
        System.out.println();
        int index = 1;
        int str = 1;
        int len = lists.size();
        int wordLen = 6;

        for(ArrayList<MyAVLNode> list:lists) {
            str = (int)Math.pow(2, len-index-1);
            //System.out.println(str);
            if((len==index)) {
                System.out.printf("%-"+wordLen/2+"s", " ");
            }
            for(MyAVLNode node:list) {

                for(int i = 0;i<str;i++) {
                    System.out.printf("%-"+wordLen+"s", "");
                }

                if(node!=null) {
                    System.out.printf("%-"+wordLen+"s", (""+node.getData()+"("+node.getHeight()+")"));
                } else {
                    System.out.printf("%-"+wordLen+"s", "nil");
                }
            }
            index++;
            System.out.println();
        }
        System.out.println();
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
    //System.out.println(t+"  "+nullNum);
        if(t==nullNum) {
            return;
        } else {
            list.add(cur);
            levelOrder(list);
        }
    }
}
