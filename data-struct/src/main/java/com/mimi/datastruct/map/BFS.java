package com.mimi.datastruct.map;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

class Point {
	int x;
	int y;
}

public class BFS {

	// 定义一张图 我现在用矩阵的形式
	private int n; // 表示行
	private int m; // 表示列

	private int dx; // 表示目标位置的x坐标
	private int dy; // 表示目标位置的y坐标

	private int data[][]; // 表示图的矩阵
	private boolean mark[][]; // 用来标记我走过的路 防止死循环

	public BFS(int n, int m, int dx, int dy, int[][] data, boolean[][] mark) {
		super();
		this.n = n;
		this.m = m;
		this.dx = dx;
		this.dy = dy;
		this.data = data;
		this.mark = mark;
	}

	public void bfs(int startx, int starty) { // 表示我的起始位置
		mark[startx][starty] = true; // 表示我已经走过的点
		Queue<Point> queue = new ArrayBlockingQueue<>(n * m); // 队列的空间 有多少点就开多少
		Point start = new Point();
		start.x = startx;
		start.y = starty;
		queue.add(start); // 起始点加入队列
		// 定义一个方向向量
		int next[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };		//表示前后左右 二维数组
		

		while (!queue.isEmpty()) { // 队列不为空 就表示还可以走
			// 判断前后左右
			Point curPoint = queue.poll(); // 每次取队列的头 出队列
			for (int i = 0; i < 4; i++) {
				int nextx = curPoint.x + next[i][0];
				int nexty = curPoint.y + next[i][1];
				// 表示走前后左右的点，其实就是坐标系运算 y+1表示往下走了一步 x+1表示往左走了一步
				// 判断是否可以走
				System.out.println("下一个点：" + nextx + ":" + nexty);
				if (nextx < 1 || nextx > n || nexty < 1 || nexty > m)// 否则就出边了
					continue;
				if (!mark[nextx][nexty] && data[nextx][nexty] == 0) { // 判断有没有走过
					// 表示可以走
					// 判断是不是到了目的地
					if (nextx == dx && nexty == dy) {// 表示是目的地
						System.out.println("true");
						return;
					}
					Point newPoint = new Point();
					newPoint.x = nextx;
					newPoint.y = nexty;
					queue.add(newPoint);		//下一步加入队列 就是一步一步走下去了
					mark[nextx][nexty] = true;
				}

			}
		}
		System.out.println("false");
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
		BFS bfs = new BFS(n, m, dx, dy, data, mark);
		int startx = cin.nextInt();
		int starty = cin.nextInt();
		bfs.bfs(startx, starty);
	}

}
// 0 0 1 0
// 0 0 0 0
// 0 0 1 0
// 0 1 0 0
// 0 0 0 1


