package com.ywm.dataStructure.MyTree.arrayTree;

/**
 * 二叉树节点对象
 */
public class TreeNode {
    //值
    int value;
    //左儿子
    TreeNode leftNode;
    //右儿子
    TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    //前序遍历
    public void frontShow() {
        System.out.println(value);
        if (leftNode != null) {
            leftNode.frontShow();
        }
        if (rightNode != null) {
            rightNode.frontShow();
        }
    }

    //中序遍历
    public void midShow() {

        if (leftNode != null) {
            leftNode.midShow();
        }
        System.out.println(value);
        if (rightNode != null) {
            rightNode.midShow();
        }
    }

    //后续遍历
    public void afterShow() {

        if (leftNode != null) {
            leftNode.afterShow();
        }
        if (rightNode != null) {
            rightNode.afterShow();
        }
        System.out.println(value);
    }

    //前序查询
    public TreeNode frontSearch(int i) {
        TreeNode target = null;
         //对比当前的值
        if (this.value == i) {
            return this;
        } else {
            //查找左儿子
            if (leftNode != null) {
                //可能查到，可能查不到，查不到：target还是null
                target = leftNode.frontSearch(i);
            }
            //如果不为空，说明在左儿子查到
            if (target != null) {
                return target;
            }
            //查找右儿子
            if (rightNode != null) {
                target = rightNode.frontSearch(i);
            }
        }
        return target;
    }

    //删除子树
    public void delete(int i) {
        TreeNode parent = this;
        if (parent.leftNode!=null && parent.leftNode.value==i){
            parent.leftNode=null;
            return;
        }
        if (parent.rightNode!=null && parent.rightNode.value==i){
            parent.rightNode=null;
            return;
        }
        parent = leftNode;
        if (parent!=null){
            parent.delete(i);
        }
        parent = rightNode;
        if (parent!=null){
            parent.delete(i);
        }
    }
}
