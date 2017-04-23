package com.cixin.Learning.Code.List;

/**
 * Created by cixinxc on 2017/3/1.
 */
public class Node {
    private int value;
    private Node nextNode = null;
    public Node() {

    }
    public Node(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
