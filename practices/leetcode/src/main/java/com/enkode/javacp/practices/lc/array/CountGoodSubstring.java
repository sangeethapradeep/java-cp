package com.enkode.javacp.practices.lc.array;

/**
 * Problem 1876
 *
 * <pre>
 *     Test Cases:
 *          s = "xyzzaz"
 *          s = "aababcabc"
 * </pre>
 */
public class CountGoodSubstring {
  public static void main(String[] args) {
    String s = "aababcabc";
    System.out.println("Coutn of Good Substrings: " + countGoodSubstrings(s));
  }

  private static int countGoodSubstrings(String s) {
    int count = 0;
    for (int i = 1; i < s.length() - 1; i++) {
      if (s.charAt(i) != s.charAt(i - 1)
          && s.charAt(i) != s.charAt(i + 1)
          && s.charAt(i + 1) != s.charAt(i - 1)) count++;
    }
    return count;
  }
}
