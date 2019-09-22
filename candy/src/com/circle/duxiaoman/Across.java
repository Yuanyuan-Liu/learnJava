package com.circle.duxiaoman;

import java.util.Scanner;

public class Across {
    public static void main(String[] args) {
        System.out.println("输入x y n：");
        Scanner sc = new Scanner(System.in);
        String str_xyn = sc.nextLine();
        String[] str_xynArr = str_xyn.split(" ");
        int[] xyn = new int[3];
        for(int i = 0;i<str_xynArr.length;i++){
            xyn[i] = Integer.parseInt(str_xynArr[i]);
        }

        int[][] barr = new int[xyn[2]][2];
        for(int j = 0;j<xyn[2];j++){
            System.out.println("输入障碍物坐标x y :");
            sc = new Scanner(System.in);
            String temp = sc.nextLine();
            String[] tempNums = temp.split(" ");
            barr[j][0] = Integer.parseInt(tempNums[0]);
            barr[j][1] = Integer.parseInt(tempNums[1]);
        }

        System.out.println(getMinAcross(xyn[0],xyn[1],barr));
    }

    public static int getMinAcross(int x,int y,int[][] barr){
        int ox = 0 , oy = 0;
        int count = 0;
        for(int i = 0;i<=x;i++){
            for(int j = 0;j<=y;j++){
                if(barr[i][0] == i&&barr[i][1]==j){
                    continue;
                }else if(barr[i][0] > i||barr[i][0]>j){
                    count++;
                }
                count++;
            }
        }
       return count;
    }
}
