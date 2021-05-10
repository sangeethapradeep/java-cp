package com.enkode.javacp.practices.lc.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <pre>
 * Problem 151:
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words.
 * Do not include any extra spaces.
 *
 * Test Cases:
 *      the sky is blue
 *        hello world
 *      a good   example
 *        Bob    Loves  Alice
 *      Alice does not even like bob
 * </pre>
 */
public class ReverseWordsInAString {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        sb.append(reverseWords(string));
        System.out.println(sb);
    }

    private static String reverseWords(String s) {
        String result = "";
        int i = s.length() - 1;
        int j;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
            } else {
                j = i;
                while (i >= 0 && s.charAt(i) != ' ') {
                    i--;
                }
                String word = s.substring(i + 1, j + 1);
                result = result.equals("") ? result + word : result + " " + word;
            }
        }
        return result;
    }
}
