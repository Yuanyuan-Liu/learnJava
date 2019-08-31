package com.circle.monkey;

import java.util.Scanner;

public class Role {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arrRole = new int[3][];
        for(int i =0;i<n;i++){
            arrRole[i] = inputRole();
        }


    }

    public static int[] inputRole(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        int[] arr = new int[str.length()];
        int i =0;
        for (String s:strings){
            arr[i] = Integer.parseInt(s);
            i++;
        }
        return arr;
    }

    public static void getRes(int[] arrRole){
        for(int i =0;i<arrRole.length;i++){

        }
    }
}
