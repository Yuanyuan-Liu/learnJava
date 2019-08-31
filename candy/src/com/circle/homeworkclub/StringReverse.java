package com.circle.homeworkclub;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str  = sc.nextLine();
        reverse(str);
    }
    public static void reverse(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1;i>0;i--){
            sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
