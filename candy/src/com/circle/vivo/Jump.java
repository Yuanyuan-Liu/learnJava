package com.circle.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jump {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution2(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution2(int[] input) {

        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i =0;i<input.length-1;i++){
            maxPosition = Math.max(maxPosition,input[i]+i);
            if(i==end){
                end = maxPosition;
                steps++;
            }
        }

        return steps;
    }

    private static int solution(int[] nums) {

        int f[] = new int[nums.length];
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 0;
        }
        f[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            f[i] = findMin(f, i, nums[i]) + 1;
            if (f[i] < 0) f[i] = Integer.MAX_VALUE;
        }

        return f[0];
    }

    private static int findMin(int[] f, int i, int num) {
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= num && i + j < f.length; j++) {
            min = Math.min(min, f[i + j]);
        }
        return min;
    }
}
