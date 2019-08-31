package com.circle.bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LateGetUp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("请输入一组数字：");
        in = new Scanner(System.in);
        HashMap<Integer,Integer> alarm = new HashMap<>();
        for(int i =0;i<n;i++){
            String str = in.nextLine();
            String[] mid = str.split(" ");
            for(int k = 0;k<mid.length;k++){
                alarm.put(Integer.parseInt(mid[0]),Integer.parseInt(mid[1]));
            }
        }

        Scanner in2 = new Scanner(System.in);
        System.out.println("起床耗费时间");
        int wasteTime = in2.nextInt();

        HashMap<Integer,Integer> classTime = new HashMap<>();
        System.out.println("上课时间");
        Scanner in3 = new Scanner(System.in);
        String str3 = in3.nextLine();
        String[] mid3 = str3.split(" ");
        classTime.put(Integer.parseInt(mid3[0]),Integer.parseInt(mid3[1]));

        getUp(alarm,wasteTime,classTime);

    }

    public static void getUp(HashMap<Integer,Integer> alarm, Integer wasteTime, HashMap<Integer,Integer> classTime){

        int lasteHour = 0,lastMinutes = 0;

        for(Map.Entry<Integer,Integer> entry:alarm.entrySet()){
            int hour = entry.getKey();
            int minutes = entry.getValue();
            if(minutes + wasteTime >=59){
                hour +=1;
                minutes = minutes + wasteTime -59;
            }
            for(Map.Entry<Integer,Integer> time:classTime.entrySet()){
                if(hour<= time.getKey()&&lasteHour<hour){
                    lasteHour = hour;
                    if(minutes<time.getValue()&&lastMinutes<minutes){
                        lastMinutes = minutes;
                    }
                }
            }
        }
        System.out.println("最迟起床时间：" +lasteHour +"时" + lastMinutes +"分");
    }
}
