package com.cixin.common;


/**
 * @author cixin
 */
public class MyNode<T> {

    private T data;
    private MyNode nextNode = null;

    public MyNode() {}

    public MyNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
    public void setT(T data) {
        this.data = data;
    }

    public MyNode getNextNode() {
        return nextNode;
    }
    public void setNextNode(MyNode nextNode) {
        this.nextNode = nextNode;
    }
}
