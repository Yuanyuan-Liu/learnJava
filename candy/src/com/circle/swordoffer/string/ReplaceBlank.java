package com.circle.swordoffer.string;

import java.util.stream.IntStream;

public class ReplaceBlank {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        ReplaceBlank replaceBlank = new ReplaceBlank();
        System.out.println(replaceBlank.replaceSpace1(str));
        System.out.println("111"  + replaceBlank.replaceSpace3(str.toString()));


        long a = System.currentTimeMillis();
        IntStream.range(0,10000).forEach(x -> {
            replaceBlank.replaceSpace1(str);
        });
        long b = System.currentTimeMillis();


        IntStream.range(0,10000).forEach(x -> {
            replaceBlank.replaceSpace2(str);
        });
        long c = System.currentTimeMillis();

        IntStream.range(0,10000).forEach(x -> {
            replaceBlank.replaceSpace3(str.toString());
        });
        long d = System.currentTimeMillis();

        System.out.println(b-a);
        System.out.println(c-b);
        System.out.println(d-c);


    }

    /**
     * 将一个字符串中的每个空格替换成“%20”
     * @param str
     * @return
     */
    public String replaceSpace1(StringBuffer str) {
        String s = str.toString();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()){
            if(" ".equals(Character.toString(s.charAt(i)))){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }

    public String replaceSpace2(StringBuffer str) {
        int oldLen = str.length();

        for(int i = 0; i < oldLen; i ++) {
            if(str.charAt(i) == ' ') {//每出现一个空格，在结尾添加两个任意字符，扩充字符串长度
                str.append("12");
            }
        }

        int i = oldLen - 1;
        int j = str.length() - 1;

        while(i >= 0 && j > i) {
            char c = str.charAt(i);
            i --;

            if(c == ' ') {//每出现一个空格，替换为%20
                str.setCharAt(j, '0');
                j --;
                str.setCharAt(j, '2');
                j --;
                str.setCharAt(j, '%');
                j --;
            } else {//否则照旧
                str.setCharAt(j, c);
                j --;
            }
        }

        return str.toString();
    }

    public String replaceSpace3(String str) {
        return String.join("%20",str.split(" "));
    }
}
