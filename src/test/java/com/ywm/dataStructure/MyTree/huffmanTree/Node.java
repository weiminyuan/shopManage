package com.ywm.dataStructure.MyTree.huffmanTree;

/**
 * 赫夫曼编码
 */
public class Node implements Comparable<Node> {
    // 值
    Byte data;
    //个数
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return -(this.weight-o.weight);
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void left(Node left) {
        this.left=left;
    }

    public void right(Node right) {
        this.right=right;
    }
}
