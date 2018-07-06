package com.cixin.datastructure.tree;

import com.cixin.common.MyRBNode;
import com.cixin.common.RBColor;
import com.cixin.datastructure.TreeUtils;

/**
 * @author cixinxc
 * @create 2018-07-01 20:58
 * @desc 我写的红黑树
 **/
public class MyRBTree {
    private MyRBNode root;


    public MyRBTree() {}

    public MyRBTree(MyRBNode root) {
        this.root = root;
        this.root.setColor(RBColor.B);
    }

    public void insert(MyRBNode node) {
        if(this.root==null) {
            this.root = node;
            this.root.setColor(RBColor.B);
        } else {
            insert(null, this.root, node);
        }
        //this.root.setColor(RBColor.B);
}

    private void insert(MyRBNode pre, MyRBNode root, MyRBNode node) {
        while(root!=null) {
            pre = root;
            if(root.getData().compareTo(node.getData())>0) {
                root = root.getLeftChild();
            } else if(root.getData().compareTo(node.getData())<0) {
                root = root.getRightChild();
            } else {
                return;
            }
        }
        if(pre.getData().compareTo(node.getData())>0) {
            pre.setLeftChild(node);
        } else if(pre.getData().compareTo(node.getData())<0) {
            pre.setRightChild(node);
        } else {
            return;
        }
        node.setParent(pre);
        node.setColor(RBColor.R);

        insertFixup(node);
    }


    /**
     * @param root
     *
     * 当插入节点后，会影响红黑树，此时修正
     */
    private void insertFixup (MyRBNode root){
        while(root.getParent()!=null && root.getParent().getColor()==RBColor.R) {
            MyRBNode uncle = getUncle(root);
            /*
            if ((uncle!=null) && uncle.getColor()==RBColor.R) {
                uncle.setColor(RBColor.B);
                root.getParent().setColor(RBColor.B);
                root.getParent().getParent().setColor(RBColor.R);
                root = root.getParent().getParent();
                continue;
            }
            */
            if (root.getParent() == root.getParent().getParent().getLeftChild()) {
                // Case 1条件：叔叔节点是红色

                if ((uncle!=null) && uncle.getColor()==RBColor.R) {
                    uncle.setColor(RBColor.B);
                    root.getParent().setColor(RBColor.B);
                    root.getParent().getParent().setColor(RBColor.R);
                    root = root.getParent().getParent();
                    int i = 1;
                    continue;
                }


                // Case 2条件：叔叔是黑色，且当前节点是右孩子
                if (root.getParent().getRightChild() == root) {
                    MyRBNode tmp;
                    RR(root.getParent());
                    tmp = root.getParent();
                    //root.getParent().setData(root.getData());
                    //root.getParent().setColor(root.getColor());
                    //MyRBNode p = root.getParent(); p = root;
                    //root = tmp;
                }

                // Case 3条件：叔叔是黑色，且当前节点是左孩子。
                root.getParent().setColor(RBColor.B);
                root.getParent().getParent().setColor(RBColor.R);
                LL(root.getParent().getParent());
            } else {    //若“z的父节点”是“z的祖父节点的右孩子”
                // Case 1条件：叔叔节点是红色

                if ((uncle!=null) && uncle.getColor()==RBColor.R) {
                    uncle.setColor(RBColor.B);
                    root.getParent().setColor(RBColor.B);
                    root.getParent().getParent().setColor(RBColor.R);
                    root = root.getParent().getParent();
                    continue;
                }

                // Case 2条件：叔叔是黑色，且当前节点是左孩子
                if (root.getParent().getLeftChild() == root) {
                    MyRBNode tmp;
                    LL(root.getParent());
                    tmp = root.getParent();
                    //root.getParent().setData(root.getData());
                    //root.getParent().setColor(root.getColor());
                    //MyRBNode p = root.getParent(); p = root;
                    //root = tmp;
                }

                // Case 3条件：叔叔是黑色，且当前节点是右孩子。
                root.getParent().setColor(RBColor.B);
                root.getParent().getParent().setColor(RBColor.R);
                RR(root.getParent().getParent());
            }
        }
        this.root.setColor(RBColor.B);
    }

    private static MyRBNode getUncle(MyRBNode node) {
        if(node==null) {
            System.out.println("error:节点为null");
            return null;
        }
        MyRBNode father = node.getParent();
        if(node==null) {
            System.out.println("error:父节点为null");
            return null;
        }
        MyRBNode grandFather = father.getParent();
        if(grandFather==null) {
            System.out.println("error:祖父节点为null");
            return null;
        }
        if(grandFather.getLeftChild()==father) {
            return grandFather.getRightChild();
        } else {
            return grandFather.getLeftChild();
        }
    }

    private static RBColor color(MyRBNode node) {
        if(node==null) {
            return RBColor.B;
        }
        return node.getColor();
    }

    public void delete(MyRBNode node) {
        System.out.println("\ndelete "+node.getData());
        if(this.root==null) {
            return;
        }

        deleteNodePre(this.root, node);
    }
    private void deleteNodePre(MyRBNode root, MyRBNode node) {
        if(root==null) {
            return;
        } else if(root.getData().compareTo(node.getData())>0) {
            deleteNodePre(root.getLeftChild(), node);
        } else if(root.getData().compareTo(node.getData())<0) {
            deleteNodePre(root.getRightChild(), node);
        } else {
            deleteNode(root);
        }
    }
    private void deleteNode(MyRBNode root) {
        MyRBNode child, parent;
        RBColor color;

        // 被删除节点的"左右孩子都不为空"的情况。
        if ( (root.getLeftChild()!=null) && (root.getRightChild()!=null) ) {
            // 被删节点的后继节点。(称为"取代节点")
            // 用它来取代"被删节点"的位置，然后再将"被删节点"去掉。
            MyRBNode replace = root;

            // 获取后继节点
            replace = replace.getRightChild();
            while (replace.getLeftChild() != null) {
                replace = replace.getLeftChild();
            }

            // "node节点"不是根节点(只有根节点不存在父节点)
            if (root.getParent()!=null) {
                if (root.getParent().getLeftChild() == root) {
                    root.getParent().setLeftChild(replace);
                } else {
                    root.getParent().setRightChild(replace);
                }
            } else {
                // "node节点"是根节点，更新根节点。
                this.root = replace;
            }

            // child是"取代节点"的右孩子，也是需要"调整的节点"。
            // "取代节点"肯定不存在左孩子！因为它是一个后继节点。
            child = replace.getRightChild();
            parent = replace.getParent();
            // 保存"取代节点"的颜色
            color = replace.getColor();

            // "被删除节点"是"它的后继节点的父节点"
            if (parent == root) {
                parent = replace;
            } else {
                // child不为空
                if (child!=null) {
                    child.setParent(parent);
                }
                parent.setLeftChild(child);
                replace.setRightChild(root.getRightChild());
                root.getRightChild().setParent(replace);
            }

            replace.setParent(root.getParent());
            replace.setColor(root.getColor());
            replace.setLeftChild(root.getLeftChild());
            root.getLeftChild().setParent(replace);

            if (color == RBColor.B) {
                deleteFixup(child, parent);
            }
            root = null;
            return ;
        }

        if (root.getLeftChild() !=null) {
            child = root.getLeftChild();
        } else {
            child = root.getRightChild();
        }

        parent = root.getParent();
        // 保存"取代节点"的颜色
        color = root.getColor();

        if (child!=null) {
            child.setParent(parent);
        }
        // "node节点"不是根节点
        if (parent!=null) {
            if (parent.getLeftChild() == root) {
                parent.setLeftChild(child);
            } else {
                parent.setRightChild(child);
            }
        } else {
            this.root = child;
        }

        if (color == RBColor.B) {
            deleteFixup(child, parent);
        }
        root = null;
    }

    private void deleteFixup (MyRBNode root, MyRBNode parent){
        MyRBNode other;
        //MyRBNode  = root.getParent();
        while ((root==null || color(root)==RBColor.B) && (root != this.root) && root!=null) {
            System.out.println("ss"+root+"   "+parent);
            if (parent.getLeftChild() == root) {
                other = parent.getRightChild();
                if (color(other)==RBColor.R) {
                    // Case 1: x的兄弟w是红色的
                    other.setColor(RBColor.B);
                    parent.setColor(RBColor.R);
                    RR(parent);
                    other = parent.getRightChild();
                }


                if (other!=null && (color(other.getLeftChild())== RBColor.B) &&
                        ( color(other.getRightChild())== RBColor.B)) {
                    // Case 2: x的兄弟w是黑色，且w的俩个孩子也都是黑色的
                    other.setColor(RBColor.R);
                    root = parent;
                } else {
                    if (other.getRightChild()==null || color(other.getRightChild())== RBColor.B) {
                        // Case 3: x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色。
                        other.getLeftChild().setColor(RBColor.B);
                        other.setColor(RBColor.R);
                        LL(other);
                        other = parent.getRightChild();
                    }
                    // Case 4: x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色。
                    other.setColor(parent.getColor());
                    parent.setColor(RBColor.B);
                    other.getRightChild().setColor(RBColor.B);
                    RR(parent);
                    root = this.root;
                    break;
                }
            } else {

                other = parent.getLeftChild();
                if(other==null) {
                    break;
                }
                if (other.getColor()==RBColor.R) {
                    // Case 1: x的兄弟w是红色的
                    other.setColor(RBColor.B);
                    parent.setColor(RBColor.R);

                    LL(parent);
                    other = parent.getLeftChild();
                }

                if ((other.getLeftChild()==null || other.getLeftChild().getColor()==RBColor.B) &&
                        (other.getRightChild()==null || other.getRightChild().getColor()==RBColor.B)) {
                    // Case 2: x的兄弟w是黑色，且w的俩个孩子也都是黑色的
                    other.setColor(RBColor.R);
                    System.out.println("ssss"+root);
                    if(root==null) {
                        root = null;
                        parent = null;
                    } else {
                        root = root.getParent();
                    }


                } else {

                    if (other.getLeftChild()==null || other.getLeftChild().getColor()==RBColor.B) {
                        // Case 3: x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色。
                        if(other.getLeftChild()!=null) {
                            other.getLeftChild().setColor(RBColor.B);
                        }
                        other.setColor(RBColor.R);
                        RR(other);
                        other = parent.getLeftChild();
                    }

                    // Case 4: x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色。
                    other.setColor(parent.getColor());
                    parent.setColor(RBColor.B);
                    other.getLeftChild().setColor(RBColor.B);

                    LL(parent);
                    root = this.root;
                    break;
                }
            }
        }

        if (root!=null) {
            root.setColor(RBColor.B);
        }
    }

    private static void LL(MyRBNode node) {
        /*
         *              node                   node(E)
         *           E         H          D          E(node)
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
        //TreeUtils.levelOrder(node);
        MyRBNode E = node.getLeftChild();
        MyRBNode F = E.getRightChild();
        MyRBNode H = node.getRightChild();

        MyRBNode temp = new MyRBNode();
        temp.setData(node.getData());
        temp.setParent(node.getParent());
        temp.setColor(node.getColor());

        node.setData(E.getData());
        node.setLeftChild(E.getLeftChild());
        node.setColor(E.getColor());
        if(E.getLeftChild()!=null) {
            E.getLeftChild().setParent(node);

        }
        if(E!=null){
            E.setData(temp.getData());
            E.setColor(temp.getColor());
            E.setParent(node);
        }

        node.setRightChild(E);
        if(E!=null) {
            E.setLeftChild(F);
            E.setRightChild(H);
        }
        if(F!=null) {
            F.setParent(E);
        }
        if(H!=null) {
            H.setParent(E);
        }
    }

    private static void RR(MyRBNode node) {
        /*
         *              node                                 node(D)
         *           A           D                    D(node)     E
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
        //TreeUtils.levelOrder(node);
        MyRBNode D = node.getRightChild();
        MyRBNode C = D.getLeftChild();
        MyRBNode A = node.getLeftChild();

        MyRBNode temp = new MyRBNode();
        temp.setData(node.getData());
        temp.setParent(node.getParent());
        temp.setColor(node.getColor());

        node.setData(D.getData());
        node.setColor(D.getColor());
        node.setRightChild(D.getRightChild());
        if(D.getRightChild()!=null) {
            D.getRightChild().setParent(node);
        }
        if(D!=null) {
            D.setData(temp.getData());
            D.setColor(temp.getColor());
            D.setParent(node);
        }

        node.setLeftChild(D);
        if(D!=null) {
            D.setParent(node);
            D.setLeftChild(A);
            D.setRightChild(C);
        }
        if(A!=null) {
            A.setParent(D);
        }
        if(C!=null) {
            C.setParent(D);
        }


    }

    private static void LR(MyRBNode node) {
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

    private static void RL(MyRBNode node) {
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

    public MyRBNode getRoot() {
        return root;
    }

    public void setRoot(MyRBNode root) {
        this.root = root;
    }

}
