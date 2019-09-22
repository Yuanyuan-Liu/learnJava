package com.circle.zhaoshangtrustcard;

import java.util.Arrays;
import java.util.Scanner;

public class RLRobot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rl = sc.nextLine();
        if(rl.charAt(0)=='R'&&rl.charAt(rl.length()-1)=='L'){
           int[] res = getRobots(rl);
            System.out.println(Arrays.toString(res));
        }else {
            System.out.println("输入有误");
        }
    }

    public static int[] getRobots(String s){
        int[] res = new int[s.length()];
        for(int k = 0;k<res.length;k++){
            res[k] = 0;
        }
        int m = 0;
        while(m<= 2){
            for(int i = 0;i<s.length();i++){
                if(i==0&&s.charAt(i)=='R'){
                    res[i+1] += 1;
                }
                if(isLeft(s.charAt(i))){
                    res[i-1] += 1;
                }
                if(i==s.length()-1&&s.charAt(i)=='L'){
                    res[i-1] += 1;
                }
            }
            m++;
        }


        return res;
    }

    public static boolean isLeft(char ch){
        return ch =='L';
    }
}
