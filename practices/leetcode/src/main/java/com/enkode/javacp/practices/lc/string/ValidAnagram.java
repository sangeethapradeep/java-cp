package com.enkode.javacp.practices.lc.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Problem 242.
 * <pre>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Test Cases:
 *      anagram     nagaram
 *      rat         rat
 * </pre>
 */
public class ValidAnagram {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string1 = br.readLine();
        String string2 = br.readLine();
        sb.append(isAnagram(string1, string2));
        System.out.println(sb);
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }

}
