package com.ywm.dataStructure.MyTree.arrayTree;


/**
 *  二叉树
 */
public class BinaryTree {
    //节点
    TreeNode root;
    //设置节点
    public void setRoot(TreeNode root){
        this.root=root;
    }
    //获取节点
    public TreeNode getRoot(){
        return root;
    }
    //前序
    public void frontShow(){
        if (root==null){
            System.out.println("null");
        }else {
            root.frontShow();
        }

    }
    //中序
    public void midShow(){
        if (root==null){
            System.out.println("null");
        }else {
            root.midShow();
        }
    }
    //后序
    public void afterShow(){
        if (root==null){
            System.out.println("null");
        }else {
            root.midShow();
        }
    }

    public TreeNode frontSearch(int i) {
        return  root.frontSearch(i);
    }

    public void delete(int i) {
        if (root.value==i){
            root=null;
        }else {
            root.delete(i);
        }
    }
}
