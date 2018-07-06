package com.cixin.datastructure.tree;

import com.cixin.common.MyAVLNode;
import com.cixin.common.MyTreeNode;
import com.cixin.datastructure.TreeUtils;

/**
 * @author cixinxc
 * @create 2018-06-25 20:59
 * @desc 我的AVL树
 **/
public class AVLTree<T extends Comparable> {
    private MyAVLNode<T> root;

    public AVLTree() {
        this.root = null;
    }

    public MyAVLNode getRoot() {
        return this.root;
    }

    public AVLTree(MyAVLNode node) {
        this.root = node;
    }

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
        System.out.println("LL");
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

        if(E.getLeftChild()==null && E.getRightChild()==null) {
            E.setHeight(1);
        } else {
            E.setHeight(Math.max(height(E.getLeftChild()), height(E.getRightChild()))+1);
        }
        if(node.getLeftChild()==null && node.getRightChild()==null) {
            node.setHeight(1);
        } else {
            node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild()))+1);
        }

    }

    private void RR(MyAVLNode node) {
        /*
         *              node 1                                D
         *           A           D 2                   node        E
         *                   C       E            A       C           F
         *                              F
         *
         *   从D开始不平衡
         *   需要修改
         *       node的左右节点
         *       D的左节点
         *
         * */
        System.out.println("RR");
        //TreeUtils.levelOrder(node);
        MyAVLNode D = node.getRightChild();
        MyAVLNode C = D.getLeftChild();
        MyAVLNode A = node.getLeftChild();

        MyAVLNode temp = new MyAVLNode();
        temp.setData(node.getData());
        node.setData(D.getData());
        node.setRightChild(D.getRightChild());

        D.setData(temp.getData());
        node.setLeftChild(D);
        D.setLeftChild(A);
        D.setRightChild(C);


        if(D.getLeftChild()==null && D.getRightChild()==null) {
            D.setHeight(1);
        } else {
            D.setHeight(Math.max(height(D.getLeftChild()), height(D.getRightChild()))+1);
        }
        if(node.getLeftChild()==null && node.getRightChild()==null) {
            node.setHeight(1);
        } else {
            node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild()))+1);
        }
    }

    private void LR(MyAVLNode node) {
        /*
        *               F                       F                   C
        *           E       G               C       G          E        F
        *       A       C               E       D             A B      D G
        *              B  D           A   B
        * */
        System.out.println("LR");
        //TreeUtils.levelOrder(node);
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
        System.out.println("RL");
        LL(node.getRightChild());
        RR(node);
    }

    public void insert(MyAVLNode node) {
        insert(node, this.root);
        if(height(root.getLeftChild())-height(root.getRightChild())>=2) {
            if(root.getLeftChild().getData().compareTo(node.getData())>0) {
                LL(root);
            } else {
                LR(root);
            }
        }
        if(height(root.getLeftChild())-height(root.getRightChild())<=-2) {
            if(root.getRightChild().getData().compareTo(node.getData())<0) {
                RR(root);
            } else {
                RL(root);
            }
        }
    }
    private void insert(MyAVLNode node, MyAVLNode root) {
        if(root==null) {
            root = node;
            //return;
        } else if(root.getData().compareTo(node.getData())>0) {
            //insert(node, root.getLeftChild());
            if(root.getLeftChild()==null) {
                root.setLeftChild(node);
                System.out.println("左边插入"+node.getData());
            } else {
                insert(node, root.getLeftChild());
                //if(height(root.getLeftChild())-height(root.getRightChild())==2) {
                if(height(root.getLeftChild())-height(root.getRightChild())>=2) {
                    if(root.getLeftChild().getData().compareTo(node.getData())>0) {
                        LL(root);
                    } else {
                        LR(root);
                    }
                }
            }

        } else if(root.getData().compareTo(node.getData())<0) {
            //insert(node, root.getRightChild());
            if(root.getRightChild()==null) {
                root.setRightChild(node);
                System.out.println("\n右边插入"+node.getData());
            } else {
                insert(node, root.getRightChild());
                //if(height(root.getLeftChild())-height(root.getRightChild())==-2) {
                //System.out.println(height(root.getLeftChild())+"   "+height(root.getRightChild()));
                if(height(root.getLeftChild())-height(root.getRightChild())<=-2) {
                    if(root.getRightChild().getData().compareTo(node.getData())<0) {
                        RR(root);
                    } else {
                        RL(root);
                    }
                }
            }

        }
        if(root.getLeftChild()==null && root.getRightChild()==null) {
            root.setHeight(1);
        } else {
            root.setHeight(Math.max(height(root.getLeftChild()), height(root.getRightChild()))+1);
        }
    }

    public void delete(MyAVLNode node){
        System.out.println("delete "+node.getData());
        delete(node, this.root);
    }
    private void delete(MyAVLNode node, MyAVLNode root) {
        MyAVLNode pre = new MyAVLNode();
        pre.setLeftChild(root);
        delete(node, root, pre, 0);
        if(root.getLeftChild()==null && root.getRightChild()==null) {
            root.setHeight(1);
        } else {
            root.setHeight(Math.max(height(root.getLeftChild()), height(root.getRightChild()))+1);
        }
        if(height(root.getLeftChild())-height(root.getRightChild())<=-2) {
            if(height(root.getRightChild().getRightChild())>height(root.getRightChild().getLeftChild())) {
                RR(root);
            } else {
                RL(root);
            }
        }
        if(height(root.getLeftChild())-height(root.getRightChild())>=2) {
            if(height(root.getLeftChild().getLeftChild())>height(root.getLeftChild().getRightChild())) {
                LL(root);
            } else {
                LR(root);
            }
        }
    }

    private static void reHeight(MyAVLNode root, int type) {
        if(type==-1) {
            if(root==null) {
                return;
            } else {
                reHeight(root.getLeftChild(), -1);
                if(root.getLeftChild()==null && root.getRightChild()==null) {
                    root.setHeight(1);
                } else {
                    root.setHeight(Math.max(height(root.getLeftChild()), height(root.getRightChild()))+1);
                }
            }
        } else if(type==1) {
            if(root==null) {
                return;
            } else {
                reHeight(root.getRightChild(), 1);
                if(root.getLeftChild()==null && root.getRightChild()==null) {
                    root.setHeight(1);
                } else {
                    root.setHeight(Math.max(height(root.getLeftChild()), height(root.getRightChild()))+1);
                }
            }
        }
    }

    private void delete(MyAVLNode node, MyAVLNode root, MyAVLNode pre, int type) {
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
                // 被删除节点是叶子节点
                if(type==1) {
                    pre.setRightChild(null);
                } else if(type==-1) {
                    pre.setLeftChild(null);
                } else {
                    this.root = null;
                }
            } else if(root.getLeftChild()!=null && root.getRightChild()==null) {
                // 被删除节点没有 右孩子节点
                if(type==1) {
                    pre.setRightChild(root.getLeftChild());
                } else if(type==-1) {
                    pre.setLeftChild(root.getLeftChild());
                } else {
                    this.root = root.getLeftChild();
                }
            } else if(root.getLeftChild()==null && root.getRightChild()!=null) {
                // 被删除节点没有 左孩子节点
                if(type==1) {
                    pre.setRightChild(root.getRightChild());
                } else if(type==-1) {
                    pre.setLeftChild(root.getRightChild());
                } else {
                    this.root = root.getRightChild();
                }
            } else {
                if(height(root.getRightChild())>height(root.getLeftChild())) {
/*
                    左右皆有子树，则使用右子树的最左节点替换到当前结点
                    首先找到右子树的最左的结点BL，然后摘除BL节点，用BL节点替换被删除的节点root，并将root的右子树放在BL的最右子节点的右子树处
                */
                    // pres:右子树最左节点的前驱节点
                    MyAVLNode pres =  root.getRightChild();
                    // LeftChildOfRightTree:被删除节点的右子树的最左子节点，并且在此分支中可以保证被删除节点一定有右子树
                    MyAVLNode LeftChildOfRightTree = root.getRightChild();

                    if(pres.getLeftChild()==null) {
                        // 如果右子树没有所谓的最左子节点==右子树根节点即为最左子节点
                        /*
                         *           8
                         *       4        12(root,待删)
                         *      ...     9     15(pres)
                         *                      17
                         * */
                        root.setData(pres.getData());
                        root.setRightChild(pres.getRightChild());
                        root.setHeight(Math.max(height(root.getLeftChild()), height(root.getRightChild()))+1);
                        //root.setHeight(height(root)-1);
                        //return;
                    } else {
                        // 找出右子树的最左节点BL
                        while(LeftChildOfRightTree.getLeftChild()!=null) {
                            pres = LeftChildOfRightTree;
                            LeftChildOfRightTree = pres.getLeftChild();
                        }
                        // 摘除BL节点
                        pres.setLeftChild(null);
                        MyAVLNode right = root.getRightChild();
                        MyAVLNode newRoot;
                        if(type==0) {
                            newRoot = this.root;
                        } else if(type==-1) {
                            newRoot = pre.getLeftChild();
                        } else {
                            newRoot = pre.getRightChild();
                        }
                        newRoot.setData(LeftChildOfRightTree.getData());
                        newRoot.setRightChild(LeftChildOfRightTree.getRightChild());
                        while(newRoot.getRightChild()!=null) {
                            newRoot = newRoot.getRightChild();
                        }
                        newRoot.setRightChild(right);
                        reHeight(root.getRightChild(), -1);
                    }
                } else {
                    /*
                    左右皆有子树，则使用左子树的最右节点替换到当前结点
                    首先找到左子树的最右的结点BR，然后摘除BR节点，用BR节点替换被删除的节点root，并将root的右子树放在BR的最右子节点的右子树处
                */
                    // pres:左子树最右节点的前驱节点
                    MyAVLNode pres =  root.getLeftChild();
                    // RightChildOfLeftTree:被删除节点的左子树的最右子节点，并且在此分支中可以保证被删除节点一定有右子树
                    MyAVLNode RightChildOfLeftTree = root.getLeftChild();

                    if(pres.getRightChild()==null) {
                        // 如果左子树没有所谓的最右子节点==左子树根节点即为最右子节点
                        /*
                         *           8
                         *       4        12(root,待删)
                         *      ...     9     15(pres)
                         *                      17
                         * */
                        root.setData(pres.getData());
                        root.setLeftChild(pres.getLeftChild());
                        //root.setHeight(height(root)-1);
                        root.setHeight(Math.max(height(root.getLeftChild()), height(root.getRightChild()))+1);
                        //return;
                    } else {
                        // 找出左子树的最右节点BR
                        while(RightChildOfLeftTree.getRightChild()!=null) {
                            pres = RightChildOfLeftTree;
                            RightChildOfLeftTree = pres.getRightChild();
                        }
                        // 摘除BR节点
                        pres.setRightChild(null);
                        MyAVLNode left = root.getLeftChild();
                        MyAVLNode newRoot;
                        if(type==0) {
                            newRoot = this.root;
                        } else if(type==-1) {
                            newRoot = pre.getLeftChild();
                        } else {
                            newRoot = pre.getRightChild();
                        }
                        newRoot.setData(RightChildOfLeftTree.getData());
                        newRoot.setLeftChild(RightChildOfLeftTree.getLeftChild());
                        while(newRoot.getLeftChild()!=null) {
                            newRoot = newRoot.getLeftChild();
                        }
                        newRoot.setLeftChild(left);
                        //System.out.println("reHeight "+left.getData());
                        reHeight(root.getLeftChild(), 1);
                    }
                }
            }
        }
        if(root.getLeftChild()==null && root.getRightChild()==null) {
            root.setHeight(1);
        } else {
            root.setHeight(Math.max(height(root.getLeftChild()), height(root.getRightChild()))+1);
        }
        if(height(root.getLeftChild())-height(root.getRightChild())<=-2) {
            //System.out.println(height(root.getLeftChild())+"  "+height(root.getRightChild()));
            //System.out.println(height(root.getRightChild().getRightChild())+"  "+height(root.getRightChild().getLeftChild()));
            if(height(root.getRightChild().getRightChild())>height(root.getRightChild().getLeftChild())) {
                RR(root);
            } else {
                RL(root);
            }
        }
        if(height(root.getLeftChild())-height(root.getRightChild())>=2) {
            //System.out.println(height(root.getLeftChild())+"  "+height(root.getRightChild()));
            //System.out.println(height(root.getLeftChild().getLeftChild())+"  "+height(root.getLeftChild().getRightChild()));
            if(height(root.getLeftChild().getLeftChild())>height(root.getLeftChild().getRightChild())) {
                LL(root);
            } else {
                LR(root);
            }
        }
    }

    private static int height(MyAVLNode node) {
        if(node==null) {
            return 0;
        }
        return node.getHeight();
    }

}
