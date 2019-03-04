package com.ywm.dataStructure.MyTree.arrayTree;

public class TestArrayTree {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayBinaryTree tree = new ArrayBinaryTree(data);
        //前序遍历
        tree.frontShow();
        System.out.println("=============================");
        tree.midShow(0);
        System.out.println("=============================");
        tree.midShow(2);
    }

}
