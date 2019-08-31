package com.circle.shangtang;

import java.util.Scanner;

public class Mountain {
    public static int longestMountain(int[] arr){
        if(arr.length==0||arr.length<3)
            return 0;
        int res = 0;
        for(int i =1; i<arr.length-1;i++){
            if(arr[i-1]<arr[i]&&arr[i+1]<arr[i]){
                int left = i-1;
                int right = i+1;
                while (left>0&&arr[left-1]<arr[left]){
                    left--;
                }
                while (right<arr.length-1&&arr[right+1]<arr[right]){
                    right++;
                }
                res =Math.max(res,(right-left+1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc = new Scanner(System.in);
        String num = sc.nextLine();
        String[] numArray = num.split(" ");
        int[] nums = new int[n];
        //将输入类型转换成int
        for(int i= 0 ;i< n ;i++) {
            nums[i] = Integer.parseInt(numArray[i]);
        }
        System.out.println(longestMountain(nums));
    }
}
