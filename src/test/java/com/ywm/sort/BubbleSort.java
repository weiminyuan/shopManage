package com.ywm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * 从第一个开始，左右比较大小
 * 左边小于右边
 * 左边大于右边 左右替换
 * 直到比较到最后位位置，把最大值放在最后
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,4,3,6,8,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void bubbleSort(int[] arr){
        int change;
        // 一共多少轮
        for (int i = 0; i < arr.length-1; i++) {
            //控制比较次数
            for (int j = 0; j < arr.length-1-i; j++) {
                //如果左边大于右边
                if(arr[j] > arr[j+1]){
                    change = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = change;
                }
            }
        }
    }
}
