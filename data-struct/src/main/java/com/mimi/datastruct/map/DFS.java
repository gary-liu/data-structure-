package com.mimi.datastruct.map;

import java.util.Scanner;



public class DFS {

	// 定义一张图 我现在用矩阵的形式
	private int n; // 表示行
	private int m; // 表示列

	private int dx; // 表示目标位置的x坐标
	private int dy; // 表示目标位置的y坐标

	private int data[][]; // 表示图的矩阵
	private boolean mark[][]; // 用来标记我走过的路 防止死循环

	private int minStep = Integer.MAX_VALUE;

	public DFS(int n, int m, int dx, int dy, int[][] data, boolean[][] mark) {
		super();
		this.n = n;
		this.m = m;
		this.dx = dx;
		this.dy = dy;
		this.data = data;
		this.mark = mark;
	}

	//问题：写出 从 startx starty 计算出到 dx dy最短需要走几步路，用递归
	public void dfs(int x,int y,int step) {		//x 和 y表示当前走到的点，step表示走到当前已经走了几步了
		int next[][] = {{0,1},{0,-1},{1,0},{-1,0}};
		if (x == dx && y == dy) {  //判断终止 也就是到了目的地
			if (step < minStep) {
				minStep = step;  //判断当前步数是不是最小的
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nextx = x + next[i][0];
			int nexty = y + next[i][1];
			if (nextx < 1 || nextx > n || nexty < 1 || nexty > m) {
				continue;
			}
			if (data[nextx][nexty] == 0 && !mark[nextx][nexty]) {
				mark[nextx][nexty] = true;  //走下一步
				dfs(nextx, nexty, step + 1);
				mark[nextx][nexty] = false; //回溯
			}
		}
		return;

		
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();

		int data[][] = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				data[i][j] = cin.nextInt();
			}
		}
		int dx = cin.nextInt();
		int dy = cin.nextInt();
		boolean mark[][] = new boolean[n + 1][m + 1];
		DFS bfs = new DFS(n, m, dx, dy, data, mark);
		int startx = cin.nextInt();
		int starty = cin.nextInt();
		////问题：写出 从 startx starty 计算出到 dx dy最短需要走几步路，用递归
		bfs.dfs(startx, starty,1);
	}

}
// 0 0 1 0
// 0 0 0 0
// 0 0 1 0
// 0 1 0 0
// 0 0 0 1


