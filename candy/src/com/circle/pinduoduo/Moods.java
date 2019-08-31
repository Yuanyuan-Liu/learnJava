package com.circle.pinduoduo;


import java.util.Scanner;

public class Moods {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("请输入 积木的数量");
        int accout = in.nextInt();
        System.out.println("请输入积木的长度和宽度");
        int[] moodsLength = OrderArrays.inputNum();
        System.out.println("请输入积木的重量");
        int[] moodsWeight = OrderArrays.inputNum();


    }
}
