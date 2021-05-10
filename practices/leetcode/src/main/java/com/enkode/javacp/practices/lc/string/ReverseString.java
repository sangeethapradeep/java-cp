package com.enkode.javacp.practices.lc.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <pre>
 * Problem 344:
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * Test Cases:
 *        h,e,l,l,o
 *        H,a,n,n,a,h
 *
 * </pre>
 */
public class ReverseString {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string = br.readLine().replace(",", "").toCharArray();
        reverseString(string);
        sb.append(string);
        System.out.println(sb);
    }

    private static void reverseString(char[] s) {
        char temp;
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            temp = s[j];
            s[j--] = s[i];
            s[i++] = temp;
        }
    }
}
