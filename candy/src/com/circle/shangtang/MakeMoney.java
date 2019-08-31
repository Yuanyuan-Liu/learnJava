package com.circle.shangtang;

import java.util.Scanner;

public class MakeMoney {
    public static long getNextMoney(int n,int a,int b, int c,int f0){
        if(n<0){
            System.out.println("000000:");
            return 0;
        }else if(n==0){
            System.out.println("f0:"+f0);
            return f0;
        }else {
            long nextCount = a*getNextMoney(n-1,a,b,c,f0)+b*getNextMoney(n-3,a,b,c,f0)+2*n*n-n+32767;
            System.out.println("nextCount:"+nextCount);
            return nextCount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String[] numArray = num.split(" ");
        int[] nums = new int[5];
        //将输入类型转换成int
        for(int i= 0 ;i< 5 ;i++) {
            nums[i] = Integer.parseInt(numArray[i]);
        }
        System.out.println(getNextMoney(nums[0],nums[1],nums[2],nums[3],nums[4]));
    }
}
