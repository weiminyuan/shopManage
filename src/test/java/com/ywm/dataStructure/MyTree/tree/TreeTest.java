package com.ywm.dataStructure.MyTree.tree;



public class TreeTest {
    public static void main(String[] args) {
        //创建一棵树
        BinaryTree binTree = new BinaryTree();
        //创建一个根节点
        TreeNode root = new TreeNode(1);
        //把根节点复制给数
        binTree.setRoot(root);
        //创建两个节点
        TreeNode rootL = new TreeNode(2);
        root.setLeftNode(rootL);
        TreeNode rootR = new TreeNode(3);
        root.setRightNode(rootR);
        //为第二层添加节点
        rootL.setLeftNode(new TreeNode(4));
        rootL.setRightNode(new TreeNode(5));
        rootR.setLeftNode(new TreeNode(6));
        rootR.setRightNode(new TreeNode(7));

        binTree.frontShow();
        System.out.println("------------------------");
        binTree.midShow();
        System.out.println("------------------------");
        binTree.afterShow();

        // 查找
        System.out.println("-------------search-----------");
        TreeNode result =  binTree.frontSearch(3);
        System.out.println(result);
        System.out.println(result==rootR);
        result =  binTree.frontSearch(8);
        System.out.println(result);
        //删除
        System.out.println("-------------delete-----------");
        binTree.delete(3);
        binTree.frontShow();
        System.out.println("-------------delete-----------");
        binTree.delete(4);
        binTree.frontShow();
        System.out.println("-------------delete-----------");
        binTree.delete(1);
        binTree.frontShow();
    }
}
