package com.circle.bytedance;

public class IsAnagram {
    public static void main(String[] args) {
        String s = "rat", t = "car";
        char[] sLetters = sortLetter(s);
        char[] tLetters = sortLetter(t);
        System.out.println(isAnagram(sLetters, tLetters));
    }

    public static char[] sortLetter(String s) {
        char[] letters = s.toCharArray();
        char tmp;
        for (int i = 0; i < letters.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < letters.length; j++) {
                if (letters[j] < letters[minIndex]) {
                    minIndex = j;
                }
            }
            tmp = letters[i];
            letters[i] = letters[minIndex];
            letters[minIndex] = tmp;
        }
        return letters;
    }

    public static boolean isAnagram(char[] s, char[] t) {
        System.out.println(String.valueOf(s)+"\n"+String.valueOf(t));
        if (String.valueOf(s).equals(String.valueOf(t))) {
            return true;
        } else {
            return false;
        }
    }
}
