
package com.circle.monkey;

import java.util.*;

public class Pay {
   public static int getLuckyPrice(int price, List<Integer> unLuckyNumbers) {
       /*StringBuilder finaPrice = new StringBuilder();
       String strPrice = String.valueOf(price);
       for (int i = 0; i < strPrice.length(); i++) {
           if (unLuckyNumbers.contains(strPrice.charAt(i))) {
               Integer inte = Integer.valueOf(strPrice.charAt(i)) + 1;
               if (!unLuckyNumbers.contains(inte)) {
                   finaPrice.append(inte);
               } else {
                   continue;
               }
           }
       }*/

       String[] strPrice = String.valueOf(price).split("");
       unLuckyNumbers.add(new Integer(0));

       List<Integer> listPrice = new ArrayList<>();
       Collections.sort(unLuckyNumbers, Comparator.comparingInt(o -> o));
       for(String s:strPrice) {
           Integer integer = Integer.valueOf(s);
           for (Integer iPrice : unLuckyNumbers) {
                if(integer.equals(iPrice)){
                    integer = iPrice+1;
                    if(integer.equals(10)){
                        continue;
                    }
                    if(unLuckyNumbers.contains(integer)){
                        continue;
                    }
                    listPrice.add(integer);
                    break;
                }
           }
       }
       StringBuilder sb = new StringBuilder();
       for(Integer in:listPrice){
           sb.append(in);
       }

       return Integer.valueOf(sb.toString());
   }

    public static void main(String[] args) {
       Integer[] unLuckNumbers ={1,4,7,8};
       List<Integer> list = new ArrayList(Arrays.asList(unLuckNumbers));
        System.out.println(getLuckyPrice(1000,list));
    }
    
}
