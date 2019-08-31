package com.circle.beike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestOrder {

    public static void main(String[] args) {
        int[] nums = input();
        System.out.println(solute(nums));
    }

    public static int[] input(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        System.out.println("请输入一组数字：");
        int[] nums = new int[n];
        in = new Scanner(System.in);
        for(int  i =0;i<n;i++){
            nums[i] = in.nextInt();
        }
        return nums;
    }

    public static int solute(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (dp.contains(nums[i])) continue;
            else if (nums[i] > dp.get(dp.size()-1)) dp.add(nums[i]);
            else if (nums[i] < dp.get(dp.size()-1)) {
                int l = 0, r = dp.size()-1;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (dp.get(mid) < nums[i]) l = mid + 1;
                    else r = mid;
                }
                dp.set(r, nums[i]);
            }
        }
        return dp.size();
    }
}
