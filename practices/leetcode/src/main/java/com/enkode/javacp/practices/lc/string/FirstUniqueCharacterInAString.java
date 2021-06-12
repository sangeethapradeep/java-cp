package com.enkode.javacp.practices.lc.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Problem 387.
 * <pre>
 *   Test Cases:
 *        leetcode
 *        loveleetcode
 *        aabb
 *        malayalam
 * </pre>
 */
public class FirstUniqueCharacterInAString {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String string = br.readLine();
    sb.append(firstUniqChar(string));
    System.out.println(sb);
  }

  private static int firstUniqChar(String s) {
    int ans = Integer.MAX_VALUE;
    for (char c = 'a'; c <= 'z'; c++) {
      int index = s.indexOf(c);
      if (index != -1 && index == s.lastIndexOf(c)) {
        ans = Math.min(index, ans);
      }
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
}
