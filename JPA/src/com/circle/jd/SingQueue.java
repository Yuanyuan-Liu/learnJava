package com.circle.jd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SingQueue {

    public static void main(String[] args) {
        int[] arr = getArr();
        quickSort(arr,0,arr.length-1);
        System.out.println(arr.length);
    }

    public static int[] getArr(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] num = new int[str.length()];
        String[] strings = str.split(" ");
        int i =0;
        for(String s:strings){
            num[i] = Integer.parseInt(s);
            i++;
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int k=0; k<num.length; k++) {
            if(!list.contains(num[k])) {
                list.add(num[k]);
            }
        }
        //返回一个包含所有对象的指定类型的数组
        int[] newArrStr =  new int[list.size()];
        for(int l=0;i<list.size();l++){
            newArrStr[l] = list.get(l);
        }
//        System.out.println(Arrays.toString(newArrStr));

        return newArrStr;
    }

    private static void quickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if(left>=right) {
            return;
        }
        //设置最左边的元素为基准值
        int key=num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i=left;
        int j=right;
        while(i<j){
            //j向左移，直到遇到比key小的值
            while(num[j]>=key && i<j){
                j--;
            }
            //i向右移，直到遇到比key大的值
            while(num[i]<=key && i<j){
                i++;
            }
            //i和j指向的元素交换
            if(i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        num[left]=num[i];
        num[i]=key;
        quickSort(num,left,i-1);
        quickSort(num,i+1,right);
    }
}