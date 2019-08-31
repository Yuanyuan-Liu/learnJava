package com.circle.beike;

import java.util.List;
import java.util.Scanner;

public class Weight {
    public static void main(String[] args) {
        int[] weight = inputWeight();
        System.out.println(compete(weight));
    }
    public static  int[] inputWeight(){
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

    public static int compete(int[] nums){
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;i<nums.length&&j!=i;j++){
                int minWeight = Math.min(nums[i],nums[j]);
                int maxWeighht = Math.max(nums[i],nums[j]);
                if(minWeight>=maxWeighht*0.9){
                    sum +=1;
                }
            }
        }
        return sum;
    }
}
