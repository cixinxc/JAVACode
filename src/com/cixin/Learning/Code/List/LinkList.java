package com.cixin.Learning.Code.List;

/**
 * Created by cixinxc on 2017/3/1.
 */
public class LinkList {
    private Node head = new Node();
    public LinkList() {

    }
    public LinkList(Node node) {
        this.head.setNextNode(node);
    }
    public void insert(Node node, String type) {
        if("head".equals(type)) {
            headInsert(node);
        }
        else if("tail".equals(type)) {
            tailInsert(node);
        }
    }
    public void insert(Node node) {
        insert(node, "tail");
    }
    private void tailInsert(Node node) {
        Node p = this.head;
        while(p.getNextNode()!=null) {
            p = p.getNextNode();
        }
        p.setNextNode(node);
    }
    private void headInsert(Node node) {
        node.setNextNode(this.head.getNextNode());
        this.head.setNextNode(node);
    }

    public void showList() {
        Node p = this.head;
        System.out.println("");
        while(p.getNextNode()!=null) {
            p = p.getNextNode();
            System.out.print("value:"+p.getValue()+"    ");
        }
    }
}
