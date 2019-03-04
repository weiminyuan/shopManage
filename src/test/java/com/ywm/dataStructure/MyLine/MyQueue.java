package com.ywm.dataStructure.MyLine;

/**
 * 队列 先进先出
 */
public class MyQueue {
    int[] elements;
    public MyQueue(){
        elements = new int[0];
    }
    //入队
    public void add(int element){
        //创建一个新的数组
        int[] newArr = new int[elements.length+1];
        //把原数组中的元素复制到新数组
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        //添加元素到新数组
        newArr[elements.length] = element;
        //新数组替换旧数组
        elements = newArr;
    }
    //出队
    public int poll(){
        int element = elements[0];
        //创建一个新的数组
        int[] newArr = new int[elements.length-1];
        //把原数组中的元素复制到新数组
        for (int i = 0; i < elements.length-1; i++) {
            newArr[i] = elements[i+1];
        }
        //新数组替换旧数组
        elements = newArr;
        return element;
    }
    public boolean isEmpty(){
        return elements.length==0;
    }
}
