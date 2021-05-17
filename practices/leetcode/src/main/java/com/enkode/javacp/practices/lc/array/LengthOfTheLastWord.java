package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Problem 58.
 * <pre>
 * Given a string s consists of some words separated by spaces,
 * return the length of the last word in the string. If the last word does not exist, return 0. *
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Test Cases:
 *      Hello World
 *      <space>
 * </pre>
 */
public class LengthOfTheLastWord {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        sb.append(lengthOfLastWord(string));
        System.out.println(sb);
    }

    private static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int length = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }

}
