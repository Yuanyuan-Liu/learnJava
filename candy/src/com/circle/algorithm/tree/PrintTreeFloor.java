package com.circle.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class PrintTreeFloor {

    public static ArrayList<ArrayList<Integer> > print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int flag = 1;
        TreeNode t = null;
        q1.add(pRoot);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (flag % 2 != 0) {
                while (!q1.isEmpty()) {
                    t = q1.poll();
                    temp.add(t.val);
                    if (t.left != null) {
                        q2.add(t.left);
                    }
                    if (t.right != null) {
                        q2.add(t.right);
                    }
                }
            } else {
                while (!q2.isEmpty()) {
                    t = q2.poll();
                    temp.add(t.val);
                    if (t.left != null) {
                        q1.add(t.left);
                    }
                    if (t.right != null) {
                        q1.add(t.right);
                    }
                }
            }
            res.add(new ArrayList<>(temp));
            temp.clear();
            flag++;
        }
        return res;
    }
}
