package com.mimi.datastruct.sort;

import java.util.Arrays;

/**
 * create by gary 2020/2/3
 * 技术交流请加QQ:498982703
 */
public class QSortTest {

    public static void  qSort(int [] data,int left ,int right){

        int ll = left;
        int rr = right;
        int base = data[left];

        while (rr > ll) {
            while (rr > ll && data[rr] >= base) {
                rr--;
            }
            if (rr > ll) {
                int temp = data[rr];
                data[rr] = data[ll];
                data[ll] = temp;
                ll++;

            }
            while (rr > ll && data[ll] <= base) {
                ll++;
            }
            if (rr > ll) {
                int temp = data[rr];
                data[rr] = data[ll];
                data[ll] = temp;
                rr--;

            }

        }

        if (ll > left) {
            qSort(data, left, ll - 1);
        }
        if (rr < right) {
            qSort(data, ll + 1, right);
        }


    }
    public static void main(String[] args) {
        int data[] = { 45, 28, 80, 90, 50, 16, 100, 10 };
        qSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));

    }


}
