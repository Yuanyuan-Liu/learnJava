package com.circle.wenwalk;
import java.util.Scanner;

public class Coin {

    public static int getMinCoinCounts(int coinValue[], int coinKinds,int money) {
        // 存放每个金额需要的最小硬币数
        int[] coinUsed = new int[money + 1];
        // 当金额为0，初始化需要硬币数为0
        coinUsed[1] = 1;
        for (int i = 1; i <= money; i++) {
            // 申请一个变量存储临时的money,初始化无限大
            coinUsed[i]  = i;
            for (int j = 1; j <= coinKinds; j++) {
                if(coinValue[j-1]<=i){
                    int temp = coinUsed[i - coinValue[j-1]] + 1;
                    if(temp < coinUsed[i]){
                        coinUsed[i] = temp;
                    }
                }
            }
        }
        return coinUsed[coinUsed.length-1];

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int[] coinn = new int[str.length()];
        String[] mid = str.split(",");
        for(int k = 0;k<mid.length;k++){
            coinn[k] = Integer.parseInt(mid[k]);
        }
        in = new Scanner(System.in);
        int m = in.nextInt();
        System.out.println(getMinCoinCounts(coinn, coinn.length, m));
    }
}
