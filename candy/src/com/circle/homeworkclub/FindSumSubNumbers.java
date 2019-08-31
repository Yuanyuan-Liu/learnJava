package com.circle.homeworkclub;

import java.util.*;

public class FindSumSubNumbers {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String str =sc.nextLine();
       String strsub =str.substring(1,str.length()-1);
       String[] strArr = strsub.split(",");
       int[] arr = new int[strArr.length];
       for(int i = 0;i<strArr.length;i++){
           arr[i] = Integer.parseInt( strArr[i]);
       }
       int target = sc.nextInt();
       getSubNums(arr,target);
    }

    public static void getSubNums(int[] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            int num1 = arr[i];
            int num2 = 0 ;
            for(int j=0;j<arr.length&&j!=i;j++){
                if((target-num1) == arr[j]){
                    num2 = target - num1;
                    map.put(num1,num2);
                }
            }
        }

        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            System.out.println(entry.getKey() + " " +entry.getValue());
        }

    }
}
