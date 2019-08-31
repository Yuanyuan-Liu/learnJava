package com.circle.netease;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GradePercent {

    public void getOrder(int n ,int[] grades,int q){

        List<Integer> gradelist = new ArrayList<>();
        for(int i= 0;i<grades.length;i++){
            gradelist.add(grades[i]);
        }

        gradelist.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue()-o2.intValue();
            }
        });

        double[] orderPercent = new double[grades.length];
        for(int  i = 0;i<gradelist.size();i++){
            if(i == 0) {
                orderPercent[i] = 0.0;
            }else {
                orderPercent[i] = ((i-1)/n);
            }
        }

        for(int j = 0;j<q;j++){
            System.out.println(orderPercent[j]);
        }
    }
}
