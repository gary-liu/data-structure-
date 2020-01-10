package com.mimi.datastruct.sort;

import java.util.Scanner;

/**
 * create by gary 2020/1/7
 * 技术交流请加QQ:498982703
 */
public class BulleSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int data[] = new int[n];
        for (int i = 0; i <n ; i++) {
            data[i] = scanner.nextInt();

        }

        for (int i = 0,len = data.length; i <len-1 ; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }

        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
