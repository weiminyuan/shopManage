package com.ywm.dataStructure.MyTree.arrayTree;

/**
 * 数组-完全二叉树
 * <p>
 * n节点的左子节点 2*n+1
 * n节点的右子节点 2*n+2
 * n节点的父节点 (n-1)/2
 */
public class ArrayBinaryTree {
    int[] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    public void frontShow() {
        frontShow(0);
    }

    public void frontShow(int index) {
        if (data == null || data.length == 0) {
            return;
        }
        //先遍历当前
        System.out.println(data[index]);
        if (2 * index + 1 < data.length) {
            frontShow(2 * index + 1);
        }
        if (2 * index + 1 < data.length) {
            frontShow(2 * index + 2);
        }
    }

    public void midShow(int index) {
        if (data == null || data.length == 0) {
            return;
        }
        if (2 * index + 1 < data.length) {
            frontShow(2 * index + 1);
        }
        System.out.println(data[index]);
        if (2 * index + 1 < data.length) {
            frontShow(2 * index + 2);
        }
    }
}
