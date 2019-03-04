package com.ywm.sort;

import java.util.Arrays;

/**
 * 基数排序
 * <p>
 * 第一次个位数排序
 * 第二次十位数排序
 * 第三次百位数排序
 * 。。。
 * 获取最大数，确定需要排序几次
 * 分0-9 10个数组
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 71, 431, 33, 621, 810, 109, 99, 444};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
        // 最大数字是几位数
        int length = (max + "").length();

        //  用于临时存储数据的二维数组
        int[][] arrays = new int[10][arr.length];
        // 用于记录在相应的数组中存放的数量
        int[] counts = new int[10];
        //根据最大数的长度，确认循环次数
        for (int i = 0, n = 1; i < length; i++, n *= 10) {
            // 把每个数字分别计算余数
            for (int j = 0; j < arr.length; j++) {
                //获取余数
                int a = arr[j] / n % 10;
                //获取指定数组
                arrays[a][counts[a]] = arr[j];
                //记录数量
                counts[a]++;
            }
            //取元素位置
            int index =0;
            // 把数字取出来
            for (int j = 0; j < counts.length; j++) {
                // 数量大于0，取数字
                if (counts[j]>0){
                    for (int k = 0; k < counts[j]; k++) {
                        arr[index] = arrays[j][k];
                        index++;
                    }
                    //把数据置为0
                    counts[j]=0;
                }
            }
        }

    }

}
