package com.ywm.dataStructure.MyLine;

/**
 * 双向列表
 */
public class DoubleNode {
    DoubleNode pre = this;
    DoubleNode next = this;
    int data;
    public DoubleNode(int data){
        this.data = data;
    }

    public void after(DoubleNode node){
        DoubleNode nextNode = this.next;
        this.next = node;
        node.pre=this;
        node.next=nextNode;
        nextNode.pre=node;
    }

    public int getData(){
        return this.data;
    }

    public DoubleNode next(){
        return this.next;
    }

    public DoubleNode pre(){
        return this.pre;
    }

}
