package com.circle.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class PrintTreeRecurse {

    public static TreeNode createTree(int[] array){
        ArrayList<TreeNode> datas=new ArrayList<TreeNode>();
        //首先把一个数组的值转换成节点，存入到一个ArrayList中去
        for (int object : array) {
            datas.add(new TreeNode(object));
        }

        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex  = 0; parentIndex  < array.length/2-1; parentIndex ++) {
            datas.get(parentIndex).left = datas.get(parentIndex * 2 + 1);
            datas.get(parentIndex).right = datas.get(parentIndex * 2 + 2);
        }
        //最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;

        datas.get(lastParentIndex).left = datas
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            datas.get(lastParentIndex).right = datas
                    .get(lastParentIndex * 2 + 2);
        }
        return datas.get(0);
    }

    //先序遍历
    public void preorder(TreeNode root){
        if(root!=null){
            System.out.println(root.val);
            preorder(root.right);
            preorder(root.left);
        }

    }
    //中序遍历
    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }

    }
    //后序遍历
    public void afterorder(TreeNode root){
        if(root!=null){
            afterorder(root.left);
            afterorder(root.right);
            System.out.println(root.val);
        }

    }

    public static void main(String[] args) {
        TreeNode root = createTree(new int[]{1,2,3,4,5,6,7});

        System.out.println(Print(root).toString());
    }

    static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        depth(pRoot,1,lists);
        return lists;
    }

    private static void depth(TreeNode pRoot,int i,ArrayList<ArrayList<Integer>> lists){
        if(pRoot == null) return;

        if(i>lists.size()){
            lists.add(new ArrayList<Integer>());
        }

        lists.get(i-1).add(pRoot.val);

        depth(pRoot.left,i+1,lists);
        depth(pRoot.right,i+1,lists);
    }
}
