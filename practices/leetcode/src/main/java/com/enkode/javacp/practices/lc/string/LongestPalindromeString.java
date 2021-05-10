package com.enkode.javacp.practices.lc.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <pre>
 * Problem 5:
 * Given a string s, return the longest palindromic substring in s.
 *
 * Test Cases:
 *      babad
 *      cbbd
 *      a
 *      ac
 * </pre>
 */
public class LongestPalindromeString {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        sb.append(longestPalindrome(string));
        System.out.println(sb);
    }

    private static String longestPalindrome(String s) {
        String longestString = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = longestPalindrome(i - 1, i + 1, s);
            String s2 = longestPalindrome(i, i + 1, s);
            String maxString = s1.length() > s2.length() ? s1 : s2;
            longestString = maxString.length() > longestString.length() ? maxString : longestString;
        }
        return longestString;
    }

    private static String longestPalindrome(int start, int end, String s) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }

}
