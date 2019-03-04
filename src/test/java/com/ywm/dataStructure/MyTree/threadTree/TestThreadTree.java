package com.ywm.dataStructure.MyTree.threadTree;

public class TestThreadTree {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ThreadBinaryTree binaryTree = new ThreadBinaryTree();
        binaryTree.createBinaryTree(data);
        System.out.println(binaryTree);
        binaryTree.midShow();
        binaryTree.threadNodes();
        System.out.println(binaryTree);

        System.out.println("========threadIterate============");
        binaryTree.threadIterate();
    }
}
