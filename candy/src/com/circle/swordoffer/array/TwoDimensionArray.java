package com.circle.swordoffer.array;

import java.util.Scanner;

public class TwoDimensionArray {

    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{2,3,4,5},{3,4,5,6},{6,7,8,9}};
        System.out.println(find(7,array));
    }
    //查找二维数组中的特定值大小，先从右上角开始寻找
    public static boolean find(int target,int[][] array){
        if(array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int m = 0, n = array[0].length - 1;//从右上角开始找，array[0][n-1]

        while(m <= array.length - 1 && n >= 0) {
            if(target == array[m][n])
                return true;
            else if(target > array[m][n])  //若target大于右上角的值时候，行数+1
                m ++;
            else   //若target小于右上角的值，则列数-1
                n --;
        }

        return false;
    }

    /**
     * 采用二分查找的方法 ，在每一行中进行二分查找，array[i][col] 若是小于target  col列+1 否则大于target 则col列-1
     * @param target
     * @param array
     * @return
     */
    public static boolean binarySearch(int target,int[][] array){
        int collef,colrig,midcol;
        int i = 0;
        while(i<array.length)
        {
            collef = 0;
            colrig = array[0].length-1;
            while(collef <= colrig)
            {
                midcol = (collef+colrig)/2;
                if(array[i][midcol] == target)
                    return true;
                if(array[i][midcol]>target)
                {
                    colrig=midcol-1;
                }
                if(array[i][midcol]<target)
                {
                    collef=midcol+1;
                }
            }
            i++;
        }
        return false;
    }
}