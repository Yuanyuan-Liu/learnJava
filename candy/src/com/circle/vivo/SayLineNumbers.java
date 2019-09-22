package com.circle.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SayLineNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution3(input);
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

    private static String solution(int[] input) {

        ArrayList list1 = new ArrayList();//原始数组｛0，1，2，3，4｝
        ArrayList list2 = new ArrayList(); //输出数组

        for(int j = 1;j <= input[0];j++){
            list1.add(j);
        }

        Object obj = null;
        int k = 0;

        //while循环原理：如果传进来的参数m小于原始数组list1的长度，就直接移除list1的第m-1个元素，并加入到list2
        //如果大于list1的长度，取模得到k，分两种情况，如果等于0，直接得到list1的第0个元素，否则去list1的第k-1个元素，兵加入list2
        while(!list1.isEmpty()){
            if(input[1] <= list1.size()){
                obj = list1.remove(input[1] - 1);
                list2.add(obj);
            }else{
                k = input[1] % list1.size();//取模
                if(k != 0){
                    obj = list1.remove(k - 1);
                    list2.add(obj);
                }
                else{
                    obj = list1.remove(0);
                    list2.add(obj);
                }
            }
        }

        System.out.print("输出数组：");
        for(int j = 0;j < list2.size();j++){
            System.out.print(list2.get(j) + ",");
        }

        return list2.toString();
    }



    public static String  solution3(int[] input){
        List<Integer> ins = new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for(int i =1;i<=input[0];i++){
            ins.add(i);
        }
        int index = 0;//被T的人在列表中下标
        for(int i =0;i<input[0];i++){
            //从0开始数数
            index = (index+input[1])%ins.size();
            res.add(ins.get(index));
            System.out.print(ins.remove(index)+" ");
        }
        return res.toString();
    }
}
