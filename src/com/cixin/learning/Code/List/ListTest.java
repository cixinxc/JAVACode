package com.cixin.learning.Code.List;

/**
 * Created by cixinxc on 2017/3/1.
 */
public class ListTest {
    public static void main(String[] arg) {
        LinkList ll = new LinkList();
        ll.showList();
        ll.insert(new Node(1), "tail");
        ll.showList();
        ll.insert(new Node(12));
        ll.showList();
        ll.insert(new Node(13), "head");
        ll.showList();
    }
}
