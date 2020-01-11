package com.mimi.datastruct.tree;

import java.util.Arrays;

/**
 * create by gary 2020/1/11
 * 技术交流请加QQ:498982703
 */
public class MergertTest {

    public static void main(String[] args) {
        int data[] = {9, 1, 3, 4, 5, 6, 7,0};
        mergerSort(data, 0, data.length-1);
        System.out.println(Arrays.toString(data));

    }

    public static void mergerSort(int data[], int left, int right) {
        if (left < right) {
//            分开
            int mid = (left + right) / 2;
            mergerSort(data, left, mid);
            mergerSort(data, mid + 1, right);
//            合
            merge(data, left, mid, right);

        }
    }

    public static void merge(int data[], int left, int mid, int right) {
        int temp[] = new int[data.length];

        int point1 = left;
        int point2 = mid +1;

        int loc = left;

        while (point1 <= mid && point2 <= right) {
            if (data[point1] <= data[point2]) {
                temp[loc] = data[point1];
                loc++;
                point1++;

            }else {
                temp[loc] = data[point2];
                loc++;
                point2++;
            }
        }

        while (point1 <= mid) {
            temp[loc++] = data[point1++];
        }
        while (point2 <= right) {
            temp[loc++] = data[point2++];
        }

        for (int i = left; i <= right; i++) {
            data[i] = temp[i];
        }




    }


}
