package com.ywm.dataStructure.MyArray;

import java.util.Arrays;

public class MyArray {
    private int[] elements;

    public MyArray(){
        elements=new int[0];
    }

    /**
     * 返回数量
     * @return
     */
    public int size(){
        return elements.length;
    }

    /**
     * 打印内容
     */
    public void show() {
        System.out.println(Arrays.toString(elements));
    }

    /**
     * 在最后 添加元素
     * @param element
     */
    public void add(int element){
        int[] newArr = new int[elements.length+1];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = element;
        elements = newArr;
    }

    public void addAll(int[] emptys){
        int[] newArr = new int[elements.length+emptys.length];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        for (int i = 0; i < emptys.length; i++) {
            newArr[elements.length+i]=emptys[i];
        }
        elements = newArr;
    }

    /**
     * 在指定位置插入
     * @param size
     * @param element
     */
    public void insert(int size, int element){
        if(size<0 || size>elements.length){
            throw new RuntimeException("数组下标越界");
        }
        int[] newArr = new int[elements.length+1];
        for (int i = 0; i < elements.length; i++) {
            if(i<size){
                newArr[i] = elements[i];
            }else {
                newArr[i+1] = elements[i];
            }
        }
        newArr[size] = element;
        elements = newArr;
    }

    /**
     * 获取指定位置
     * @param size
     */
    public int get(int size){
        if(size<0 || size>elements.length-1){
            throw new RuntimeException("数组下标越界");
        }
        return elements[size];
    }

    /**
     * 删除指定位置
     * @param size
     */
    public void delete(int size){
        if(size<0 || size>elements.length-1){
            throw new RuntimeException("数组下标越界");
        }
        int[] newArr = new int[elements.length-1];
        for (int i = 0; i < newArr.length; i++) {
            if(i<size){
                newArr[i] = elements[i];
            }else {
                newArr[i] = elements[i+1];
            }
        }
        elements = newArr;
    }

    public int findArray(int target){
        int begin = 0;
        int end = elements.length-1;
        int mid =(begin+end)/2;
        while (true){
            if (elements[mid]==target){
                return mid;
            }else {
                if (elements[mid]>target){
                    end = mid-1;
                }else {
                    begin = mid+1;
                }
            }
            mid=(begin+end)/2;
        }
    }

}
