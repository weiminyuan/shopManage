package com.ywm.dataStructure.MyArray;

public class MyFindArray {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        myArray.addAll(arr);
        int target =4;
        int index = myArray.findArray(target);
        System.out.println(index);
    }
}