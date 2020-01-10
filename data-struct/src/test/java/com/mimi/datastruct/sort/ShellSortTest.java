package com.mimi.datastruct.sort;

import java.util.Scanner;

/**
 * create by gary 2020/1/7
 * 技术交流请加QQ:498982703
 * 希尔排序
 * 是对插入排序的一种改进
 */
public class ShellSortTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int data []  = new int[a+1];
        for (int i = 0; i < a; i++) {
            data[i] = scanner.nextInt();
        }

        int step =a;
        while (step >= 1) {
            step = step / 2;//提高效率可以不写
            for (int i = step; i <a ; i++) {
                for (int j = i; j - step > 0; j -= step) {
                    if (data[j] < data[j - 1]) {
//                    交换
                        data[j] = data[j] + data[j - 1];
                        data[j - 1] = data[j] - data[j - 1];
                        data[j] = data[j] - data[j - 1];
                    }else {
                        break;

                    }
                }

            }
        }



        for (int i = 0; i <a ; i++) {
            System.out.print(data[i] + " ");

        }
        System.out.println();


    }
}
