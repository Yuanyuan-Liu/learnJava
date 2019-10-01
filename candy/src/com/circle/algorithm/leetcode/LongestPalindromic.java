package com.circle.algorithm.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestPalindromic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            System.out.println(longestPalindrome(sc.nextLine()));
        }
    }
    public static String findPalindrome(String s, int left, int right) {
        int n = s.length();
        int l = left;
        int r = right;
        while (l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n<=1) return s;

        String longest = "";

        String str;
        for (int i=0; i<n-1; i++) {
            str = findPalindrome(s, i, i);
            if (str.length() > longest.length()){
                longest = str;
            }
            str = findPalindrome(s, i, i + 1);
            if (str.length() > longest.length()){
                longest = str;
            }
        }
        return longest;
    }

    /**
     * 解题思路：
     * 如果从索引i到j-1之间的子字符串S[ij]已经被检查为没有重复字符.那则只需要检查s[j]对应的字符是否存在于子字符串s[ij];
     *
     * 通过HashSet作为活动窗口.那我们只需要用O(1)的时间来完成对字符是否在当前子字符串的检查.
     *
     * 我们使用HashSet将字符存储在当前窗口[i,j),最初i=j .然后我们向右侧滑动索引j,如果它不在HashSet中,则我们会继续滑动j.直到s[j]已经存在于HashSet中,此时,我们就已经找到的没有重复字符的最长子串将会以索引i开头.如果我们将所有的i,都做如此操作即可得到结果
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            //试图调整[i,j]的范围
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
