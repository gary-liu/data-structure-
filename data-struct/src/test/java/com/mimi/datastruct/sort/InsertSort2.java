package com.mimi.datastruct.sort;

import java.util.Scanner;

/**
 * create by gary 2020/1/6
 * 技术交流请加QQ:498982703
 */
public class InsertSort2 {
    public static void main(String[] args) {
        //4 2 3 1
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int data []  = new int[a+1];
        for (int i = 0; i < a; i++) {
            data[i] = scanner.nextInt();
        }

//        插入排序
        for (int i = 1; i <a ; i++) {
            for (int j = i; j > 0; j--) {
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

        for (int i = 0; i <a ; i++) {
            System.out.print(data[i] + " ");

        }
        System.out.println();

    }
}
