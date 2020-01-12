package com.mimi.datastruct.tree;

/**
 * create by gary 2020/1/12
 * 技术交流请加QQ:498982703
 * 二叉搜索树  左子树 比根结点小 右子树 比根结点大
 */


public class BinaryTreeSearchTest {

    int data;
    BinaryTreeSearchTest left;
    BinaryTreeSearchTest right;

    public BinaryTreeSearchTest(int data) {
        this.data = data;
    }

    public static void insert(BinaryTreeSearchTest root, int data) {
        if (root.data < data) {  //根结点小于 data 插入右子树
            if (root.right == null) {
                root.right = new BinaryTreeSearchTest(data);
            }else {          //表示子树不为空 ，那么还要继续往下找，要找到叶子结点才能插入
                insert(root.right, data);
            }
        }else {
            if (root.left == null) {
                root.left = new BinaryTreeSearchTest(data);
            }else {
                insert(root.left, data);
            }
        }

    }

    public static void find(BinaryTreeSearchTest root, int key) {
        boolean find = false;
        while (root != null) {
            if (root.data == key) {
                System.out.println("find");
                find = true;
                break;

            }

            if (root.data < key) {
                root = root.left;
            } else if (root.data > key) {
                root = root.right;
            }



        }

        if (!find) {
            System.out.println("not find");

        }
    }

    public static void pre(BinaryTreeSearchTest root) {
        if (root != null) {
            System.out.print(root.data + " ");
            pre(root.left);
            pre(root.right);
        }

    }
    public static void mid(BinaryTreeSearchTest root) {
        if (root != null) {
            mid(root.left);
            System.out.print(root.data + " ");
            mid(root.right);
        }

    }

    public static void main(String[] args) {
        int data[] = {0,5,9,1,2,3,10};
        BinaryTreeSearchTest root = new BinaryTreeSearchTest(data[0]);
        for (int i = 1; i <data.length ; i++) {
            insert(root, data[i]);
        }
        mid(root);
        System.out.println("前序遍历");
        pre(root);


    }



}
