package com.mimi.datastruct.tree;

import java.util.*;

/**
 * create by gary 2020/1/17
 * 技术交流请加QQ:498982703
 */
class MyNodeTest implements Comparable<MyNodeTest>{
    private String chars = "";
    private int weight;
    private MyNodeTest leftNode;

    private MyNodeTest rightNode;
    private MyNodeTest parent;


    @Override
    public int compareTo(MyNodeTest o) {
        return this.getWeight()-o.weight;
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

    public MyNodeTest getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(MyNodeTest leftNode) {
        this.leftNode = leftNode;
    }

    public MyNodeTest getRightNode() {
        return rightNode;
    }

    public void setRightNode(MyNodeTest rightNode) {
        this.rightNode = rightNode;
    }

    public MyNodeTest getParent() {
        return parent;
    }

    public void setParent(MyNodeTest parent) {
        this.parent = parent;
    }
}

public class HumanTreeTest {

    private MyNodeTest root ;
    private List<MyNodeTest> leafs;
    Map<Character,Integer> weights;

    public HumanTreeTest( Map<Character, Integer> weights) {
        this.leafs = new ArrayList<>();
        this.weights = weights;
    }

    private Map<Character, String> codeInfo() {
        Map<Character, String> map = new HashMap<>();
        for (MyNodeTest node : leafs) {
            Character c = new Character(node.getChars().charAt(0));
            String code = "";
            MyNodeTest curNode = node;
            do {
                if (curNode.getParent() != null && curNode.getParent().getLeftNode() == curNode) {
                    code = "0" + code;
                }else {
                    code = "1" + code;
                }

                curNode = curNode.getParent();
            } while (curNode.getParent() != null);
            map.put(c, code);
        }
        return map;
    }


    private static Character getKey(Map<Character,String> map, String value){

        Character result  = null;
        for(Character key: map.keySet()){
            if(map.get(key).equals(value)){
                result = key;
            }
        }
        return result ;
    }




    private String  docode(Map<Character,String> map ,String  codeStr) {
        int start = 0 ;
        int end = 1;
        String result = "";
        while (end <= codeStr.length()) {
            String  strc = codeStr.substring(start, end);
            if (map.containsValue(strc)) {
                result+=getKey(map, strc);
                start = end;
            }
            end++;
        }

        return  result;

    }

    public void createTree() {
        PriorityQueue<MyNodeTest> priorityQueue = new PriorityQueue<>();
        Character[] keys = weights.keySet().toArray(new Character[0]);
        for (Character c : keys) {
            MyNodeTest node = new MyNodeTest();
            node.setChars(c.toString());
            node.setWeight(weights.get(c));
            priorityQueue.add(node);
            leafs.add(node);

        }
        int len = priorityQueue.size();
        for (int i = 0; i < len - 1; i++) {
            MyNodeTest node1 = priorityQueue.poll();
            MyNodeTest node2 = priorityQueue.poll();

            MyNodeTest node = new MyNodeTest();
            node.setWeight(node1.getWeight() + node2.getWeight());
            node.setChars(node1.getChars() + node2.getChars());
            node.setLeftNode(node1);
            node.setRightNode(node2);
            node1.setParent(node);
            node2.setParent(node);
            priorityQueue.add(node);
        }

        root = priorityQueue.poll();
        System.out.println("create finish");

    }

    public static void main(String[] args) {
        Map<Character, Integer> weightMap = new HashMap<>();
        weightMap.put('A', 7);
        weightMap.put('B', 0);
        weightMap.put('C', 2);
        weightMap.put('D', 4);
        HumanTreeTest humanTree = new HumanTreeTest(weightMap);
        humanTree.createTree();
        Map<Character, String> map = humanTree.codeInfo();
        System.out.println("A:"+map.get('A'));
        System.out.println("B:"+map.get('B'));
        System.out.println("C:"+map.get('C'));
        System.out.println("D:"+map.get('D'));
        System.out.println("AB的密文:"+(map.get('A')+map.get('B')));
        System.out.println(humanTree.docode(map, "10010100000"));



    }


}
