package com.ywm.sort;

import com.ywm.dataStructure.MyLine.MyQueue;

import java.util.Arrays;

public class RadixQueueSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 71, 431, 33, 621, 810, 109, 99, 444};
        radixQueueSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixQueueSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
        // 最大数字是几位数
        int length = (max + "").length();

        //  用于临时存储数据的队列数组
        MyQueue[] queues = new MyQueue[10];
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new MyQueue();
        }
        //根据最大数的长度，确认循环次数
        for (int i = 0, n = 1; i < length; i++, n *= 10) {
            // 把每个数字分别计算余数
            for (int j = 0; j < arr.length; j++) {
                //获取余数
                int a = arr[j] / n % 10;
                //获取指定数组
                queues[a].add(arr[j]);
            }
            //取元素位置
            int index =0;
            // 把数字取出来
            for (int j = 0; j < queues.length; j++) {
                while (!queues[j].isEmpty()){
                    arr[index] = queues[j].poll();
                    index++;
                }
            }
        }
    }
}
