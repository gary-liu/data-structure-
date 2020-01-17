package com.mimi.datastruct.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * create by gary 2020/1/17
 * 技术交流请加QQ:498982703
 */
class MyNode implements Comparable<MyNode>{
    private String chars = "";
    private int weight;
    private MyNode leftNode;

    private MyNode rightNode;
    private MyNode parent;


    @Override
    public int compareTo(MyNode o) {
        return this.weight-o.weight;
    }

    public String getChars() {
        return chars;
    }

    public void setChars(String chars) {
        this.chars = chars;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public MyNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(MyNode leftNode) {
        this.leftNode = leftNode;
    }

    public MyNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(MyNode rightNode) {
        this.rightNode = rightNode;
    }

    public MyNode getParent() {
        return parent;
    }

    public void setParent(MyNode parent) {
        this.parent = parent;
    }

    public MyNode(String chars, int weight, MyNode leftNode, MyNode rightNode, MyNode parent) {
        this.chars = chars;
        this.weight = weight;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "chars='" + chars + '\'' +
                ", weight=" + weight +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                ", parent=" + parent +
                '}';
    }
}

public class HumanTreeTest {

    private MyNode root ;
    private List<MyNode> leafs;
    Map<Character,Integer> weights;

    public HumanTreeTest( Map<Character, Integer> weights) {
        this.leafs = new ArrayList<>();
        this.weights = weights;
    }

    public void createTree() {

    }

}
