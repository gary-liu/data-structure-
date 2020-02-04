package com.mimi.datastruct.tree;


public class BinarySearchTree {
	
	int data;
	BinarySearchTree left;
	BinarySearchTree right;
	
	public BinarySearchTree(int data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	public void insert(BinarySearchTree root,int data) {		//构建树
		if(root.data < data) {		//根结点小于 data 插入右子树 
			if(root.right == null) {
				root.right = new BinarySearchTree(data);
			}else {		//表示子树不为空 ，那么还要继续往下找，要找到叶子结点才能插入
				insert(root.right, data);
			}
			//insert(root, data);
		}else {
			if(root.left == null) {
				root.left = new BinarySearchTree(data);
			}else {
				insert(root.left, data);
			}
		}
	}
	
	public void find(int key ,BinarySearchTree node) {	// 判断一个数在不在二叉搜索树里面
		boolean find = false;
		while (node != null) {
			if (node.data == key) {
				System.out.println("find");
				find = true;
				break;
			}
			if(key<node.data) node = node.left;
			else if(key>node.data) node = node.right;

		}
		if (!find) {
			System.out.println("not find");

		}
		
	}
	public void pre( BinarySearchTree root) {	// 前序遍历
		if(root != null) {
			System.out.print(root.data + " ");
			pre(root.left);
			pre(root.right);
		}
			
	}
	public void post( BinarySearchTree root) {	// 后序遍历
		if(root != null) {
			post(root.left);
			post(root.right);
			System.out.print(root.data + " ");
		}

		
	}
	public void in(BinarySearchTree root) {		//中序遍历
		if(root != null) {
			in(root.left);
			System.out.print(root.data + " ");
			in(root.right);
		}
	}
	public static void main(String[] args) {
		//快速排序，归并排序，二叉树排序
		int data[] = {0,5,9,1,2,3,10};
		BinarySearchTree root = new BinarySearchTree(data[0]);	//第一个点作为跟结点
		for(int i = 1 ; i < data.length ; i ++) {
			root.insert(root, data[i]);
		}
		System.out.println("中序遍历:");
		root.in(root);
	}
	
}
