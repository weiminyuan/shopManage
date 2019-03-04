package com.ywm.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 从第二个开始，查询往前有序数据
 * 找到合适位置 替换
 *
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,4,3,6,8,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void insertSort(int[] arr){
        // 遍历所有数字
        for (int i = 1; i < arr.length; i++) {
            //如果当前数字比前一个数字小
            if (arr[i]<arr[i-1]){
                int temp = arr[i];
                int j;
                //遍历之前的有序数组，将大于当前值都往后挪一个。
                for (j = i-1; j >=0 && temp < arr[j]; j--) {
                    //把前一个值复制给后一个
                    arr[j+1] = arr[j];
                }
                //因为for循环最后会执行j--，所以需要j+1来还原替换位置
                arr[j+1]=temp;
            }
        }
    }
}
