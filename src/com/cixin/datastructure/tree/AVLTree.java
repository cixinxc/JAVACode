package com.cixin.datastructure.tree;

import com.cixin.common.MyAVLNode;
import com.cixin.common.MyTreeNode;
import com.cixin.datastructure.TreeUtils;

/**
 * @author cixinxc
 * @create 2018-06-25 20:59
 * @desc �ҵ�AVL��
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
        *   ��E��ʼ��ƽ��
        *   ��Ҫ�޸�
        *       node�����ҽڵ�
        *       E���ҽڵ�
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
         *   ��D��ʼ��ƽ��
         *   ��Ҫ�޸�
         *       node�����ҽڵ�
         *       D����ڵ�
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
                System.out.println("��߲���"+node.getData());
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
                System.out.println("\n�ұ߲���"+node.getData());
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
            // û���ҵ��ڵ�
            return;
        } else if(root.getData().compareTo(node.getData())>0) {
            delete(node, root.getLeftChild(), root, -1);

        } else if(root.getData().compareTo(node.getData())<0) {
            delete(node, root.getRightChild(), root, 1);

        } else {
            // �ҵ��˽ڵ㣬ɾ���ýڵ�
            System.out.println("find the node:"+root.getData());
            if(root.getLeftChild()==null && root.getRightChild()==null) {
                // ��ɾ���ڵ���Ҷ�ӽڵ�
                if(type==1) {
                    pre.setRightChild(null);
                } else if(type==-1) {
                    pre.setLeftChild(null);
                } else {
                    this.root = null;
                }
            } else if(root.getLeftChild()!=null && root.getRightChild()==null) {
                // ��ɾ���ڵ�û�� �Һ��ӽڵ�
                if(type==1) {
                    pre.setRightChild(root.getLeftChild());
                } else if(type==-1) {
                    pre.setLeftChild(root.getLeftChild());
                } else {
                    this.root = root.getLeftChild();
                }
            } else if(root.getLeftChild()==null && root.getRightChild()!=null) {
                // ��ɾ���ڵ�û�� ���ӽڵ�
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
                    ���ҽ�����������ʹ��������������ڵ��滻����ǰ���
                    �����ҵ�������������Ľ��BL��Ȼ��ժ��BL�ڵ㣬��BL�ڵ��滻��ɾ���Ľڵ�root������root������������BL�������ӽڵ����������
                */
                    // pres:����������ڵ��ǰ���ڵ�
                    MyAVLNode pres =  root.getRightChild();
                    // LeftChildOfRightTree:��ɾ���ڵ���������������ӽڵ㣬�����ڴ˷�֧�п��Ա�֤��ɾ���ڵ�һ����������
                    MyAVLNode LeftChildOfRightTree = root.getRightChild();

                    if(pres.getLeftChild()==null) {
                        // ���������û����ν�������ӽڵ�==���������ڵ㼴Ϊ�����ӽڵ�
                        /*
                         *           8
                         *       4        12(root,��ɾ)
                         *      ...     9     15(pres)
                         *                      17
                         * */
                        root.setData(pres.getData());
                        root.setRightChild(pres.getRightChild());
                        root.setHeight(Math.max(height(root.getLeftChild()), height(root.getRightChild()))+1);
                        //root.setHeight(height(root)-1);
                        //return;
                    } else {
                        // �ҳ�������������ڵ�BL
                        while(LeftChildOfRightTree.getLeftChild()!=null) {
                            pres = LeftChildOfRightTree;
                            LeftChildOfRightTree = pres.getLeftChild();
                        }
                        // ժ��BL�ڵ�
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
                    ���ҽ�����������ʹ�������������ҽڵ��滻����ǰ���
                    �����ҵ������������ҵĽ��BR��Ȼ��ժ��BR�ڵ㣬��BR�ڵ��滻��ɾ���Ľڵ�root������root������������BR�������ӽڵ����������
                */
                    // pres:���������ҽڵ��ǰ���ڵ�
                    MyAVLNode pres =  root.getLeftChild();
                    // RightChildOfLeftTree:��ɾ���ڵ���������������ӽڵ㣬�����ڴ˷�֧�п��Ա�֤��ɾ���ڵ�һ����������
                    MyAVLNode RightChildOfLeftTree = root.getLeftChild();

                    if(pres.getRightChild()==null) {
                        // ���������û����ν�������ӽڵ�==���������ڵ㼴Ϊ�����ӽڵ�
                        /*
                         *           8
                         *       4        12(root,��ɾ)
                         *      ...     9     15(pres)
                         *                      17
                         * */
                        root.setData(pres.getData());
                        root.setLeftChild(pres.getLeftChild());
                        //root.setHeight(height(root)-1);
                        root.setHeight(Math.max(height(root.getLeftChild()), height(root.getRightChild()))+1);
                        //return;
                    } else {
                        // �ҳ������������ҽڵ�BR
                        while(RightChildOfLeftTree.getRightChild()!=null) {
                            pres = RightChildOfLeftTree;
                            RightChildOfLeftTree = pres.getRightChild();
                        }
                        // ժ��BR�ڵ�
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
