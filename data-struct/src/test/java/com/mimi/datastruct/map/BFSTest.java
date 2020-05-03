package com.mimi.datastruct.map;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * create by gary 2020/2/4
 * 技术交流请加QQ:498982703
 */
class  pointTest{
    int x;
    int y;
}

public class BFSTest {
    private int n ; //行
    private int m;//列

    private int dx;//目标行
    private int dy ;//目标列

    private int [][] data;//图的矩阵
    private boolean mark[][];

    public BFSTest(int n, int m, int dx, int dy, int[][] data, boolean[][] mark) {
        this.n = n;
        this.m = m;
        this.dx = dx;
        this.dy = dy;
        this.data = data;
        this.mark = mark;
    }

    public void bfs(int startx, int starty) {
        mark[startx][starty] = true;

        Queue<pointTest> queue = new ArrayBlockingQueue<>(n * m);
        pointTest start = new pointTest();
        start.x = startx;
        start.y = starty;
        queue.add(start);
//定义一个方向向量
        int next[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            pointTest curPoint = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextx = curPoint.x + next[i][0];
                int nexty = curPoint.y + next[i][1];

                System.out.println("下一个点：" + nextx + ":" + nexty);
                if (nextx < 1 || nextx > n || nexty < 1 || nexty > m) {
                    continue;
                }

                if (!mark[nextx][nexty] && data[nextx][nexty] == 0) {
                    if (nextx == dx && nexty == dy) {
                        System.out.println("true");
                        return;
                    }
                }
                pointTest newPoint = new pointTest();
                newPoint.x =nextx;
                newPoint.y = nexty;
                queue.add(newPoint);
                mark[nextx][nexty] = true;

            }

        }
        System.out.println("false");
        return;


    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();

        int data[][] = new int[n+1 ][m+1 ];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                data[i][j] = cin.nextInt();
            }
        }

        int dx = cin.nextInt();
        int dy = cin.nextInt();

        boolean mark[][] = new boolean[n+1 ][m+1 ];
        BFSTest bsf = new BFSTest(n, m, dx, dy, data, mark);
        int startx = cin.nextInt();
        int starty = cin.nextInt();
        bsf.bfs(startx, starty);

    }



}
