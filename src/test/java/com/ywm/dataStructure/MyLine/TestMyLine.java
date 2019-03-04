package com.ywm.dataStructure.MyLine;

public class TestMyLine {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.append(n2);
        n1.append(n3);
        n1.append(n4);

        System.out.println(n1.next().next().getData());
        n1.show();
        Node n5 = new Node(5);
        n1.next.after(n5);
        n1.show();

        LoopNode ln1 = new LoopNode(1);
        LoopNode ln2 = new LoopNode(2);
        LoopNode ln3 = new LoopNode(3);
        LoopNode ln4 = new LoopNode(4);
        ln1.after(ln2);
        ln2.after(ln3);
        ln3.after(ln4);
        System.out.println("---------");
        System.out.println(ln1.next.data);
        System.out.println(ln2.next.data);
        System.out.println(ln3.next.data);
        System.out.println(ln4.next.data);

    }
}
