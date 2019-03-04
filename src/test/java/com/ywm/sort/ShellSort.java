package com.ywm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 插入排序优化版，主要用于处理小值排在很后面
 *  分组插入排序 数组个数/2 直到结果=0结束
 *
 *
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,4,3,6,8,1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void shellSort(int[] arr){
        // 遍历所有的步长
        for (int d = arr.length/2; d > 0; d/=2) {
            // 遍历所有数字, 让当前元素在指定数组进行排序
            for (int i = d; i < arr.length; i++) {
                //遍历本组的所有元素，在当前元素，前的本组数组排序
                int temp = arr[i];
                int j;
                for (j = i-d; j>=0 && temp < arr[j]; j-=d) {
                    //如果当前元素大于步长后的元素
                    arr[j+d]=arr[j];
                }
                arr[j+d] = temp;
            }
        }
    }
}
