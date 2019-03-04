package com.ywm.dataStructure.MyLine;

/**
 * 节点
 */
public class Node {
    // 内容
    int data;
    // 下一个节点
    Node next;
    // 构造方法
    public Node(int data){
        this.data = data;
    }
    // 为节点追加节点
    public Node append(Node node){
        Node currentNode = this;
        while (true){
            Node nextNote = currentNode.next;
            if (nextNote==null){
                break;
            }
            currentNode = nextNote;
        }
        currentNode.next = node;
        return this;
    }

    public void after(Node node){
        //下一个节点
        Node nextNode = this.next;
        //设置当前节点下一个节点
        this.next=node;
        //设置添加节点的下一个节点
        node.next=nextNode;
    }

    /**
     * 显示所有节点内容
     */
    public void show(){
        Node currentNode = this;
        while (true){
            System.out.println(currentNode.data+" ");
            currentNode = currentNode.next;
            if (currentNode==null){
                break;
            }
        }
    }

    /**
     * 删除下一个节点
     */
    public void removeNode(){
        //获取下下个节点
        Node newNode = next.next;
        //设置下下个节点为当前节点的下个节点
        this.next=newNode;
    }

    public Node next(){
        return this.next;
    }

    public int getData(){
        return this.data;
    }

    public Boolean lastNode(Node node){
        return node.next==null;
    }
}
