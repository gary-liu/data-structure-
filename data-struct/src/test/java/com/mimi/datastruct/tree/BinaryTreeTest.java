package com.mimi.datastruct.tree;

/**
 * create by gary 2020/1/11
 * 技术交流请加QQ:498982703
 */

class Node{
    private char data;

    private Node leftNode;
    private Node rightNode;

    public Node(char data, Node leftNode, Node rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}

public class BinaryTreeTest {

    public static void print(Node root) {
        System.out.print(root.getData());
    }
//    根节点(输出)  左子树  右子树

    public  static void pre(Node node) {
        print(node);
        if (node.getLeftNode() != null) {
            pre(node.getLeftNode());

        }
        if (node.getRightNode() != null) {
            pre(node.getRightNode());
        }
    }
    //   左子树   根节点(输出)   右子树
    public  static void mid(Node node) {

        if (node.getLeftNode() != null) {
            pre(node.getLeftNode());

        }
        print(node);
        if (node.getRightNode() != null) {
            pre(node.getRightNode());
        }

    }
    //   左子树    右子树 根节点(输出)
    public static void post(Node node) {

        if (node.getLeftNode() != null) {
            pre(node.getLeftNode());
        }
        if (node.getRightNode() != null) {
            pre(node.getRightNode());
        }
        print(node);

    }

    public static void main(String[] args) {

        Node D = new Node('D', null, null);
        Node C = new Node('C', D, null);
        Node B = new Node('B', null, C);
        Node H = new Node('H', null, null);
        Node K = new Node('K', null, null);
        Node G = new Node('G', H, K);
        Node F = new Node('F', G, null);
        Node E = new Node('E', null, F);
        Node A = new Node('A', B, E);

        pre(A);



    }


}
