package com.mimi.datastruct.hash7map;

/**
 * create by gary 2020/2/7
 * 技术交流请加QQ:498982703
 */
public class Node {

    private Object context;

    private Node next;


    public Node(Object context, Node next) {
        this.context = context;
        this.next = next;
    }

    public static void main(String[] args) {
        Node header = new Node(new Object(), null);

//      插在尾部
        Node next = new Node(header.next, null);
        //插在头部
        Node behind = new Node(new Object(), header);
    }

}
