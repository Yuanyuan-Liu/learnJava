package com.circle.netease;

import java.util.Scanner;

public class MinSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = new int[in.nextInt()];
        int i=0;

        while (i < num.length) {
            in = new Scanner(System.in);
            num[i] = in.nextInt();
            System.out.println(getResult(num[i],num[i]));
            i++;
        }



    }

    public static int getMinInteger(int num){
        int wanWei=num/10000;
        int qianWei=num%10000/1000;
        int baiWei=num%1000/100;
        int shiWei=num%100/10;
        int geWei=num%10;
        int Sn = wanWei+qianWei+baiWei+shiWei+geWei;
        return Sn;
    }

    public static int getResult(int x,int n){
        int Sn = getMinInteger(n);
        if(x>Sn){
            n++;
            int res = getResult(x,n);
            return res;
        }
        return -1;
    }
}
