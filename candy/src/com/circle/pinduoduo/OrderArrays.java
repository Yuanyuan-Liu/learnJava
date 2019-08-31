package com.circle.pinduoduo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OrderArrays {

    public static int[] sortArray(int[] arr1,int[] arr2){
        int index = 0;
        for (int i = 0;i<arr1.length-2;i++){
            if(arr1[i]>arr1[i+1]) {
                index = i+1;

                break;
            }
        }

        System.out.println(index+":"+arr1[index]);
        int target = -999;
        for(int i = 0;i<arr2.length;i++){
            if(arr2[i]>arr1[index] && arr2[i]>target ){
                target = arr2[i];
            }
        }

        arr1[index] = target;
        return arr1;
    }

    public static  int[] inputNum(){
        System.out.println("请输入一组数字:");
        Scanner in = new Scanner(System.in);
        List<Integer> list1 =new ArrayList<>();
        String intString  = in.nextLine();
        String[] strs = intString.split(" ");

        int[] arr = new int[strs.length];
        for(int i = 0;i<strs.length;i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        return arr;
    }

    public static void print(int[] res,String message){
        System.out.println(message);
        for(int i =0 ;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("请您输入1：");
        int[] array1 = inputNum();
        System.out.println("请您输入2：");
        int[] array2 = inputNum();
        System.out.println("arry1:" + Arrays.toString(array1));
        System.out.println("arry2:" + Arrays.toString(array2));
        int[] arr = sortArray(array1,array2);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }



}
