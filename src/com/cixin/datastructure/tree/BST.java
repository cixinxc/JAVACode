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

    public MyTreeNode getRoot() {
        return root;
    }

    public void setRoot(MyTreeNode root) {
        this.root = root;
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

    public boolean find(MyTreeNode node, MyTreeNode root) {
        MyTreeNode result = findNode(node, root);
        if(result==null) {
            return false;
        } else {
            return true;
        }
    }

    private MyTreeNode findNode(MyTreeNode node, MyTreeNode root) {
        if(root==null) {
            return null;
        } else if(root.getData().compareTo(node.getData())>0) {
            return findNode(node, root.getLeftChild());
        } else if(root.getData().compareTo(node.getData())<0) {
            return findNode(node, root.getRightChild());
        } else {
            return root;
        }
    }

    public void delete(MyTreeNode node, MyTreeNode root) {
        MyTreeNode pre = new MyTreeNode();
        pre.setLeftChild(root);
        delete(node, root, pre, 0);
    }
    private void delete(MyTreeNode node, MyTreeNode root, MyTreeNode pre, int type) {
        if(root==null) {
            // 没有找到节点
            return;
        } else if(root.getData().compareTo(node.getData())>0) {
            delete(node, root.getLeftChild(), root, -1);
        } else if(root.getData().compareTo(node.getData())<0) {
            delete(node, root.getRightChild(), root, 1);
        } else {
            // 找到了节点，删除该节点
            System.out.println("find the node");
            if(root.getLeftChild()==null && root.getRightChild()==null) {
                if(type==1) {
                    pre.setRightChild(null);
                } else if(type==-1) {
                    pre.setLeftChild(null);
                } else {
                    this.root = null;
                }
            } else if(root.getLeftChild()!=null && root.getRightChild()==null) {
                //root = root.getLeftChild();
                if(type==1) {
                    pre.setRightChild(root.getLeftChild());
                } else if(type==-1) {
                    pre.setLeftChild(root.getLeftChild());
                } else {
                    root.setData(root.getLeftChild().getData());
                    MyTreeNode t = root.getLeftChild();
                    root.setLeftChild(t.getLeftChild());
                    root.setRightChild(t.getRightChild());
                }
            } else if(root.getLeftChild()==null && root.getRightChild()!=null) {
                //root = root.getRightChild();
                if(type==1) {
                    pre.setRightChild(root.getRightChild());
                } else if(type==-1) {
                    pre.setLeftChild(root.getRightChild());
                } else {
                    root.setData(root.getRightChild().getData());
                    MyTreeNode t = root.getRightChild();
                    root.setLeftChild(t.getLeftChild());
                    root.setRightChild(t.getRightChild());
                }
            } else {
                // 左右皆有子树，则使用右子树的最左节点替换到当前结点
                // 首先找到右子树的最左的结点
                MyTreeNode t = root.getRightChild();
                while(t.getLeftChild()!=null) {
                    pre = t;
                    t = t.getLeftChild();
                }
                // 设置被删除结点
                root.setData(t.getData());
                pre.setLeftChild(null);
            }
        }
    }
}
