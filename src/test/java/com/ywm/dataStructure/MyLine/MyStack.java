package com.ywm.dataStructure.MyLine;

/**
 * 栈 -后进先出
 */
public class MyStack {
    int[] elements;
    public MyStack(){
        elements = new int[0];
    }
    //压入元素
    public void push(int element){
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

    //取出元素
    public int pop(){
        //取出数组最后一个元素
        int element = elements[0];
        //创建一个新的数组
        int[] newArr = new int[elements.length-1];
        //把原数组中除了最后一个的其他元素移到新数组中
        for (int i = 0; i < elements.length-1; i++) {
            newArr[i] = elements[i];
        }
        //新数组替换旧数组
        elements = newArr;
        return element;
    }

    public boolean isEmpty(){
        return elements.length==0;
    }
}
