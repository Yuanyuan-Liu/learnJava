package com.circle.beike;

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        int[] arr = input();
        find(arr);
    }
    public static int[] input(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("请输入一组数字：");
        in = new Scanner(System.in);
        String str = in.nextLine();
        int[] nums = new int[n];
        String[] mid = str.split(" ");
        for(int k = 0;k<mid.length;k++){
            nums[k] = Integer.parseInt(mid[k]);
        }
        return  nums;
    }

    public static void find(int[] nums){
        int compare = Math.abs(nums[0]-nums[1]);
        int index = 0;
        for(int i = 0;i<nums.length-1;i++){
            if(compare>Math.abs(nums[i]-nums[i+1])){
                compare = Math.abs(nums[i]-nums[i+1]);
                index = i;
            }
        }
        System.out.println(nums[index] +" " + nums[index+1]);
    }
}
