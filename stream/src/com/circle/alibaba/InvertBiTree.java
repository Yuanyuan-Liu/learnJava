package com.circle.alibaba;

import java.util.LinkedList;
import java.util.List;

public class InvertBiTree {

    public static BiTree invertTree(BiTree root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        BiTree temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static void createTree(int[] nodes) {
        List<BiTree>  nodeList = new LinkedList<BiTree>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < nodes.length; nodeIndex++) {
            nodeList.add(new BiTree(nodes[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < nodes.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).right = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = nodes.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (nodes.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }

    public static void preOrder(BiTree root) {
        if (null != root) {
            System.out.print(root.getData() + "\t");
            preOrder(root.left);
            preOrder(root.right);
        }
    }


    public static void main(String[] args) {
        int[] res = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        createTree(res);
        System.out.println(res);
//        BiTree inverttree = invertTree(tree);
//        preOrder(inverttree);
    }

}
