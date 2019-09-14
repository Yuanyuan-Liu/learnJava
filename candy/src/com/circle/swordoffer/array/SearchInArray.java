package com.circle.swordoffer.array;

/**
 * 题目：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 解题：因为矩阵中的每一个数，左边都比它小，下边都比它大。因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间
 *
 */
public class SearchInArray {

    public static void main(String[] args) {

    }

    public static boolean find(int target,int[][] arr){
        if(arr==null||arr.length==0||arr[0].length==0){
            return false;
        }

        int m = 0,n = arr[0].length-1;
        while (m <= arr.length-1 && n>=0){
            if(target == arr[m][n]){
                return true;
            }
            if(target<arr[m][n]){
                n--;
            }else {
                m++;
            }
        }
        return false;
    }
}