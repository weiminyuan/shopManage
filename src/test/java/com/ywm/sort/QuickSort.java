package com.ywm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 选第一个作为基准数，左右标为数组开始 low，结束位置 high。
 *
 * 比基准数大，右标左移 high-- ,  标准数坐标 low
 * 比基准数小，右标复制顶替左位置，arr[low]=arr[high] ，标准数坐标high
 * 比基准数小，左标右移 low++ ,  标准数坐标 high
 * 比基准数大，左标复制顶替右标，arr[high]=arr[low] ，标准数坐标low
 * 直到 low>=high结束一个排序，将标准数复制到low坐标位置完成一次排序
 *
 * 2,7,4,3,6,8,1    -->2
 * 1,7,4,3,6,8,1 --> 1,7,4,3,6,8,7 --> 1,7,4,3,6,8,7 --> ... 1,2,4,3,6,8,7
 * 将2坐标为界限，左右2组数组，递归排序
 *
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,4,3,6,8,1};
        int start =0;
        int end = arr.length-1;
        quickSort(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int start, int end){
        if (start<end){
            //把数组中第0个数字做为标准数
            int stard = arr[start];
            //记录需要排序的下标
            int low = start;
            int high = end;
            while (low<high){
                //右边比标准输大
                while (low<high && stard <= arr[high]){
                    high--;
                }
                //使用右边替换左边的数
                arr[low]=arr[high];
                //左边比标准数小
                while (low<high && arr[low] <= stard){
                    low++;
                }
                arr[high]=arr[low];
            }
            arr[low]=stard;
            //处理所有小的数字
            quickSort(arr, start, low);
            //处理所有大的数字
            quickSort(arr, low+1, end);
        }

    }
}
