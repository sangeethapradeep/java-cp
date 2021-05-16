package com.enkode.javacp.practices.lc.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 139.
 * <pre>
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
 * space-separated sequence of one or more dictionary words. Note that the same word in the
 * dictionary may be reused multiple times in the segmentation.
 *
 * Test Cases:
 *      leetcode        leet,code
 *      applepenapple   apple, pen
 *      catsandog       cats,dog,sand,and,cat
 *      aaaaaaa         aaaa,aaa
 * </pre>
 */
public class WordBreak {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        List<String> wordDict = Arrays.asList(br.readLine().split(","));
        sb.append(wordBreak(string, wordDict));
        System.out.println(sb);
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
