package com.circle.swordoffer.string;

public class ReplaceBlank {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        ReplaceBlank replaceBlank = new ReplaceBlank();
        System.out.println(replaceBlank.replaceSpace(str));
    }

    /**
     * 将一个字符串中的每个空格替换成“%20”
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
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
}
