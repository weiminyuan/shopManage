package com.ywm.dataStructure.MyTree.arrayTree;

import java.util.Arrays;

/**
 * 二叉树 堆排序
 * 升序排序-大顶堆（根节点大于子节点）
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 6, 9, 5, 7, 8, 1, 2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        //开始位置为最后一个节点的父节点
        int index = (arr.length - 1) / 2;
        //调整为大顶堆
        for (int i = index; i >= 0; i--) {
            maxHeap(arr, arr.length, i);
        }
        System.out.println(Arrays.toString(arr));
        //先把数组中的第0个和堆中第一个数交换，再把前面的处理为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));
            //因为第一个数交换，所以只需要对根节点做比较
            maxHeap(arr, i, 0);
        }
    }

    /**
     * 大顶堆排序
     *
     * @param arr
     * @param size
     * @param index
     */
    public static void maxHeap(int[] arr, int size, int index) {
        // 左子节点
        int leftNode = 2 * index + 1;
        //右子节点
        int rightNode = 2 * index + 2;
        //最大节点下标
        int max = index;
        if (leftNode < size && arr[leftNode] > arr[max]) {
            max = leftNode;
        }
        if (rightNode < size && arr[rightNode] > arr[max]) {
            max = rightNode;
        }
        //交换位置
        if (max != index) {
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            //交换位置后，重新调整堆无序
            maxHeap(arr, size, max);
        }
    }
}
