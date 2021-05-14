package com.enkode.javacp.practices.lc.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <pre>
 * Problem 394.
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is
 * being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid;
 * No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits
 * are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Test Cases:
 *      3[a]2[bc]
 *      3[a2[c]]
 *      2[abc]3[cd]ef
 *      abc3[cd]xyz
 *      100[leetcode]
 *      3[z]2[2[y]pq4[2[jk]e1[f]]]ef
 * </pre>
 */
public class DecodeString {

    private static StringBuilder sb = new StringBuilder();
    private static int idx = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        sb.append(decodeString(string));
        System.out.println(sb);
    }

    private static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int count = 0;

        while (idx < s.length()) {
            char c = s.charAt(idx++);

            if (Character.isAlphabetic(c)) {
                res.append(c);
                count = 0;
            } else if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                String temp = decodeString(s);
              for (int i = 0; i < count; i++) {
                res.append(temp);
              }
                count = 0;
            } else {  // c == ']'
                break;
            }
        }

        return res.toString();
    }


    private static String multiplyString(String s, int times) {
        String key = s;
        while (--times > 0) {
            s = s.concat(key);
        }
        return s;
    }

}
