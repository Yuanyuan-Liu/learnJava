package com.circle.netease;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainMtethod {

    public static void main(String[] args) {
       /* int[] apples = OrderArrays.inputNum();
        int[] questions = OrderArrays.inputNum();

        Harvest harvest = new Harvest();
        int[] answers = harvest.belongToApples(apples,questions);

        OrderArrays.print(answers,"Harvest result is:");*/


        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), i = 0, j = 0;
        int[] grades = new int[n];

        System.out.println("請輸入一組數字");
        in = new Scanner(System.in);
        String str = in.nextLine();
        String[] mid = str.split(" ");
        while (i < n) {
            grades[i] = Integer.parseInt(mid[i]);
            i++;
        }

        List<Integer> gradelist = new ArrayList<>();
        for(int ii= 0;ii<grades.length;ii++){
            gradelist.add(grades[ii]);
        }

        gradelist.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue()-o2.intValue();
            }
        });

        int q = in.nextInt(),k=0;
        int[] ques = new int[q];
        while(k<q) {
            ques[k++] = in.nextInt();
        }
        for(int m = 0;m<q;m++){
            getOrder(n,gradelist,ques[m]);
        }
    }

    public static void getOrder(int n ,List<Integer> gradelist,int q){
        int accout = 0;
       for(Integer gr:gradelist){
           if(gr<=gradelist.get(q-1))
               accout++;
       }

        if(q==1) {
            System.out.println(0.0000);
        }else {
            System.out.println((double)(accout-1)/n);
        }

    }

}
