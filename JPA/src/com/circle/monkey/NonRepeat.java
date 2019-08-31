package com.circle.monkey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NonRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] num = new int[str.length()];
        String[] strings = str.split(" ");
        int i =0;
        for(String s:strings){
            num[i] = Integer.parseInt(s);
            i++;
        }
        int[] arr = getArr(num[0]);
        String resStr = Arrays.toString(getNonRepeat(arr,num[1]));
        System.out.println(resStr.substring(1,resStr.length()-1).replace(","," "));
    }

    public static int[] getArr(int n){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = new int[n];
        String[] strings = str.split(" ");
        int i =0;
        for(String s:strings){
            arr[i] = Integer.parseInt(s);
            i++;
        }
        return arr;
    }

    public static int[] getNonRepeat(int[] arr,int m){
        List list = new ArrayList<>(Arrays.asList(arr));
        List<Integer> resList = new ArrayList<>();

        for(int i = 0;i<arr.length;i++){
            int accout = 0;
            for(int j =0;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    accout+=1;
                }
            }
            if(accout<=m){
                resList.add(arr[i]);
            }
        }
        int[] resArr = new int[resList.size()];
        int k =0;
       for(Integer i:resList){
           resArr[k] = i;
           k++;
       }
       return resArr;
    }
}
