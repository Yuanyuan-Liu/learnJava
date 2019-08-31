package com.circle.candy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Candy {
    public static void main(String[] args) throws IOException {
        int[] score = inputScore();
//        int[] score = {80, 90, 99, 80, 70};

        sortScore(score);
        System.out.println("分配的糖果数目为：" + allocateCandy(score));
    }

    public static int[] inputScore() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        int[] score = null;
        int i = 0;
        while ((str = br.readLine()) != null ) {
            if("".equals(str))
                break;
            int length = str.split(" ").length;
            score = new int[length];
            for (String s : str.split(" ")) {
                score[i] = Integer.parseInt(s);
                i++;
            }
        }
        return score;
    }

    public static void sortScore(int[] score) {
        int length = score.length;

        for (int i = 0; i < length; i++) {
            int obj = score[i];
            for (int j = i + 1; j < length; j++) {
                if (obj > score[j]) {
                    int tmp = score[j];
                    score[j] = score[i];
                    score[i] = tmp;
                }
            }
        }
    }

    public static int allocateCandy(int[] score) {
        int sum = 1;
        Map<Integer, Integer> res = new HashMap<>();
        res.put(score[0], 1);
        int temp = 0;
        for (int i = 1; i < score.length; i++) {
            int candy = 1;
            if (i == 4) {
                sum += temp + 1;
                break;
            }
            if (score[i - 1] < score[i] && score[i] <= score[i + 1]) {
                candy += 1;
            }
            if (score[i - 1] <= score[i] && score[i] < score[i + 1]) {
                candy += 0;
            }
            temp = candy;
            sum += candy;
        }
        return sum;
    }

}
