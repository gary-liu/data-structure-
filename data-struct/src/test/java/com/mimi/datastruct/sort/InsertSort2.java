package com.mimi.datastruct.sort;

import org.junit.Test;

import java.util.Arrays;
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



    @Test
    public void testInsert() {
        int[] data = {3, 5, 2, 1};
        System.out.println(Arrays.toString(data));
        for (int i = 1; i <data.length ; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }else {
                    break;

                }
            }

        }
        System.out.println(Arrays.toString(data));

    }


    @Test
    public void testBullSort() {
        int[] data = {3, 5, 2, 1};
        System.out.println(Arrays.toString(data));

        for (int i = 0, a = data.length; i <a ; i++) {
            for (int j = 0; j < a - 1 - i; j++) {
                if (data[j + 1] < data[j]) {
                    int temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(data));


    }

    @Test
    public void testShell() {
        int[] data = {3, 5, 2, 1};
        System.out.println(Arrays.toString(data));
        int step = data.length;
        while (step >= 1) {
            step = step / 2;
            for (int i = step,a = data.length; i <a ; i++) {
                for (int j = i; j - step >=0; j -= step) {
                    if (data[j] < data[j - step]) {
                        int temp = data[j];
                        data[j] = data[j - step];
                        data[j-step] = temp;
                    }else {
                        break;
                    }
                }

            }

        }
        System.out.println(Arrays.toString(data));

    }






}
