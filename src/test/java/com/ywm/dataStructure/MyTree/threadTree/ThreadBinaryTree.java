package com.ywm.dataStructure.MyTree.threadTree;

import com.ywm.dataStructure.MyTree.tree.TreeNode;

/**
 * 数组-完全二叉树
 * <p>
 * n节点的左子节点 2*n+1
 * n节点的右子节点 2*n+2
 * n节点的父节点 (n-1)/2
 */
public class ThreadBinaryTree {
    //节点
    ThreadNode root;
    //临时存储前驱节点
    ThreadNode pre = null;

    public void createBinaryTree(int[] array) {
        ThreadNode node = createBinaryTree(array, 0);
        System.out.println(node);
        this.root = node;
    }

    public ThreadNode createBinaryTree(int[] array, int index) {
        ThreadNode node = null;
        if (index < array.length) {
            node = new ThreadNode(array[index]);
            node.leftNode = createBinaryTree(array, index * 2 + 1);
            node.rightNode = createBinaryTree(array, index * 2 + 2);
        }
        return node;
    }

    /**
     *   遍历线索二叉树
     */
    public void threadIterate(){
        //用于临时储存当前遍历节点
        ThreadNode node = root;

        while (node!=null){
            //循环找到最开始的节点
            while (node.leftType==0){
                node = node.leftNode;
            }
            //打印当前节点的值
            System.out.println(node.value);
            //如果当前节点的右指针指向的是后继节点，可能后继节点还是后继节点
            while (node.rightType==1){
                node = node.rightNode;
                System.out.println(node.value);
            }
            //替换遍历的节点
            node = node.rightNode;
        }
    }

    //中序线索化二叉树
    public void threadNodes() {
        threadNodes(root);
    }

    //中序线索化二叉树
    public void threadNodes(ThreadNode node) {
        //当前节点为null，直接返回
        if (node == null) {
            return;
        }
        //处理左子树
        threadNodes(node.leftNode);
        //处理前驱节点
        if (node.leftNode == null) {
            //让当前节点左指针指向前驱节点
            node.leftNode = pre;
            //改变当前节点左指针的类型
            node.leftType = 1;
        }
        //处理前驱右指针，如果前驱节点的右指针是null（没有右子树）
        if (pre != null && pre.rightNode == null) {
            //让前驱节点的右指针指向当前节点
            pre.rightNode = node;
            //改变前驱节点的右指针的类型
            pre.rightType = 1;
        }
        //每处理一个节点，当前节点是下一个节点的前驱节点
        pre = node;
        //处理右子树
        threadNodes(node.rightNode);
    }

    //设置根节点
    public void setRoot(ThreadNode root) {
        this.root = root;
    }

    //获取节点
    public ThreadNode getRoot() {
        return root;
    }

    //前序
    public void frontShow() {
        if (root == null) {
            System.out.println("null");
        } else {
            root.frontShow();
        }

    }

    //中序
    public void midShow() {
        if (root == null) {
            System.out.println("null");
        } else {
            root.midShow();
        }
    }

    //后序
    public void afterShow() {
        if (root == null) {
            System.out.println("null");
        } else {
            root.midShow();
        }
    }

    public ThreadNode frontSearch(int i) {
        return root.frontSearch(i);
    }

    public void delete(int i) {
        if (root.value == i) {
            root = null;
        } else {
            root.delete(i);
        }
    }
}
