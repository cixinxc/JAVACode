package com.cixin.datastructure.tree;

import com.cixin.common.MyTreeNode;

/**
 * @author cixin
 */
public class BinarySortTree<T> extends MyTree{
    private MyTreeNode root = null;

    public BinarySortTree() {}

    public BinarySortTree(MyTreeNode root) {
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
            System.out.println("find the node:"+root.getData());
            if(root.getLeftChild()==null && root.getRightChild()==null) {
                if(type==1) {
                    pre.setRightChild(null);
                } else if(type==-1) {
                    pre.setLeftChild(null);
                } else {
                    this.root = null;
                }
            } else if(root.getLeftChild()!=null && root.getRightChild()==null) {
                if(type==1) {
                    pre.setRightChild(root.getLeftChild());
                } else if(type==-1) {
                    pre.setLeftChild(root.getLeftChild());
                } else {
                    this.root = root.getLeftChild();
                }
            } else if(root.getLeftChild()==null && root.getRightChild()!=null) {
                if(type==1) {
                    pre.setRightChild(root.getRightChild());
                } else if(type==-1) {
                    pre.setLeftChild(root.getRightChild());
                } else {
                    this.root = root.getRightChild();
                }
            } else {
                /*
                    左右皆有子树，则使用右子树的最左节点替换到当前结点
                    首先找到右子树的最左的结点BL，然后用BL节点替换被删除的节点root，并将root的右子树放在BL的最右子节点的右子树处
                    首先找到右子树的最左的结点BL
                */
                // LeftChildOfRightTree:被删除节点的右子树的最左子节点，并且在此分支中可以保证被删除节点一定有右子树
                MyTreeNode LeftChildOfRightTree = root.getRightChild();
                // pres:LeftChildOfRightTree的前驱节点
                MyTreeNode pres = LeftChildOfRightTree;

                if(LeftChildOfRightTree.getLeftChild()==null) {
                    //
                    pres = root;
                    pres.setData(LeftChildOfRightTree.getData());
                    pres.setRightChild(LeftChildOfRightTree.getRightChild());
                    return;
                } else {
                    while(LeftChildOfRightTree.getLeftChild()!=null) {
                        pres = LeftChildOfRightTree;
                        LeftChildOfRightTree = pres.getLeftChild();
                    }
                    pres.setLeftChild(null);
                }

                MyTreeNode right = root.getRightChild();
                MyTreeNode left = root.getLeftChild();
                MyTreeNode newRoot = LeftChildOfRightTree;
                if(type==0) {
                    this.root.setData(LeftChildOfRightTree.getData());
                } else if(type==-1) {
                    pre.getLeftChild().setData(LeftChildOfRightTree.getData());
                } else {
                    pre.getRightChild().setData(LeftChildOfRightTree.getData());
                }
                newRoot.setLeftChild(left);
                while(newRoot.getRightChild()!=null) {
                    newRoot = newRoot.getRightChild();
                }
                newRoot.setRightChild(right);
            }
        }
    }
}
