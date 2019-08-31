package com.circle.wenwalk;

import java.util.Scanner;

public class MaxCapactity {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int[] nums = new int[str.length()];
        String[] mid = str.split(",");
        for(int k = 0;k<mid.length;k++){
            nums[k] = Integer.parseInt(mid[k]);
        }
        System.out.println(maxArea(nums));
    }

    public static int maxArea(int[] height) {
        //利用贪心算法
        //在这里容积就是面积，它受长和高的影响，当长度减小的时候，只能增大高才有可能提升面积，所以我们从长度最长时开始递减，然后用更高的线来补齐

        int max_area = 0;
        int max_temp = 0;
        int min_height = 0;
        int start=0, end = height.length-1;
        for(; start<end;){
            min_height = height[start] < height[end]?height[start]:height[end];
            max_temp = (end-start)*min_height;
            if(max_temp > max_area){
                max_area = max_temp;
            }
            if(height[start]>height[end]){
                end--;
            }else{
                start++;
            }
        }
        return max_area;
    }
}
