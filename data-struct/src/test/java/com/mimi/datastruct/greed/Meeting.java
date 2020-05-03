package com.mimi.datastruct.greed;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * create by gary 2020/1/10
 * 技术交流请加QQ:498982703
 * 贪心算法
 */


class Me implements Comparable<Me> {

    private int meNum;

    private int startTime;

    private int endTime;

    @Override
    public int compareTo(Me o) {
        if (o.getEndTime() < this.getEndTime()) {
            return 1;
        }
        return -1;
    }

    public Me(int meNum, int startTime, int endTime) {
        this.meNum = meNum;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getMeNum() {
        return meNum;
    }

    public void setMeNum(int meNum) {
        this.meNum = meNum;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Me{" +
                "meNum=" + meNum +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}



public class Meeting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int meNum = scanner.nextInt();

        List<Me> meList = new ArrayList<>();

        for (int i = 0; i <meNum ; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            int meCode = i+1;
            Me me = new Me(meCode, startTime, endTime);
            meList.add(me);
        }
//        meList.sort(null);//实现排序 就是贪心的策略

        int current = 0;

        for (Me me : meList) {
            if (me.getStartTime() >=current) {
                System.out.println(me.toString());
                current = me.getEndTime();
            }
        }

        System.out.println();
    }
}
