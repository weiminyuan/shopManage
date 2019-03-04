package com.ywm.dataStructure.MyLine;

/**
 * 循环节点
 */
public class LoopNode {
    // 内容
    int data;
    // 下一个节点
    LoopNode next = this;
    // 构造方法
    public LoopNode(int data){
        this.data = data;
    }


    public void after(LoopNode node){
        //下一个节点
        LoopNode nextNode = this.next;
        //设置当前节点下一个节点
        this.next=node;
        //设置添加节点的下一个节点
        node.next=nextNode;
    }


    /**
     * 删除下一个节点
     */
    public void removeNode(){
        //获取下下个节点
        LoopNode newNode = next.next;
        //设置下下个节点为当前节点的下个节点
        this.next=newNode;
    }

    public LoopNode next(){
        return this.next;
    }

    public int getData(){
        return this.data;
    }

    public Boolean lastNode(LoopNode node){
        return node.next==null;
    }
}
