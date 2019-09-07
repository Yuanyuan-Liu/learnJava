package com.circle.offer;

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
                n--；
            }else {
                m++;
            }
        }
    }
}