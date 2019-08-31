package com.circle.bytedance;

import java.util.Scanner;

public class PaySalery {
    public static void main(String[] args) {
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
        pay(nums);
    }

    public static void pay(int[] stayTime){
        int sumSalery = 0;
        int[] paySalery = new int[stayTime.length];
        paySalery[0] =100;
        for(int i = 0;i<stayTime.length;i++){
            paySalery[i] = 100;
            if(i!=0){
                if(stayTime[i]>stayTime[i-1]){
                    while (paySalery[i]<=paySalery[i-1]) {
                        paySalery[i] += 100;
                    }
                }
            }
            sumSalery +=paySalery[i];
        }
        System.out.println(paySalery.toString());
        System.out.println(sumSalery);
    }
}
