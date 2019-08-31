package com.circle.netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Diamond {
    public  int[] inputNum(){
        Scanner in = new Scanner(System.in);
        List<Integer> list1 =new ArrayList<>();
        String intString  = in.nextLine();
        String[] strs = intString.split(" ");

        int[] arr = new int[strs.length];
        for(int i = 0;i<strs.length;i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        return arr;
    }



    public    int  getMaxInterestPoint(int k,int[] interestPoint,int[] awake){
        int maxInterest = 0,account = 0;
        int n = interestPoint.length;
        for(int i=0;i<n;i++){
            if(awake[i]!=0){
                maxInterest +=interestPoint[i];
                account++;
                if(account ==3)
                    break;
            }
        }
        return maxInterest;
    }
}
