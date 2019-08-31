package com.circle.netease;

public class Harvest {
    public int[] belongToApples(int[] apples,int[] questions){
        int[] answers = new int[questions.length];
        for(int i= 0;i<questions.length;i++){
            int sumApples = 0;
            for(int j =0;j<apples.length;j++){
                sumApples+=apples[j];
                if(questions[i]<=sumApples){
                    answers[i] = j+1;
                    break;
                }
            }
        }
        return answers;
    }
}
