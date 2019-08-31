package com.circle.beike;

import java.util.Scanner;

public class HumpOrder {
    public static void main(String[] args) {
        int[] arr = input();
        System.out.println(hump(arr));
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

    public static int hump(int[] arr){
        int sum = 0;
        int low = 0,high = arr.length-1;

        while (low < high) {
            int tmp = arr[low];
            int htmp = arr[high];
            low++;
            // 当队首元素小于等于tmp时,向前挪动low指针
            if (low < high && arr[low] <= tmp) {
                int midd = 0;
                midd = arr[low];
                arr[low] = tmp+1;
                sum += arr[low] - midd;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            high--;
            if (low < high && arr[high] <= htmp) {
                int midd = 0;
                midd = arr[high] ;
                arr[high] = htmp+1;
                sum += arr[high] - midd;
            }
            if((high-low)==1&&arr[low]==arr[high]){
                sum+=1;
            }
        }
        return sum;
    }
}
