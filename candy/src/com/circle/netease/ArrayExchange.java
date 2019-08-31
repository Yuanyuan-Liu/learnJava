package com.circle.netease;

import java.util.Scanner;

public class ArrayExchange {
    public static void exchange(int[] arr){
        for(int i =0;i<arr.length-1;i++){
            if((arr[i]+arr[i+1])/2!=0){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = new int[in.nextInt()];
        in = new Scanner(System.in);
        int i=0;
        String str = in.nextLine();
        String[] mid = str.split(" ");

        while (i < num.length) {
            num[i] = Integer.parseInt(mid[i]);
            i++;
        }
        exchange(num);
        for(int j= 0;j<num.length;j++)
            System.out.println(num[j]);
    }
}
