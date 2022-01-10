package com.enkode.javacp.practices.lc.advanced;

/**
 * Problem 1092
 *
 * <pre>
 *     str1 = "abac", str2 = "cab"
 *     str1 = "aaaaaaaa", str2 = "aaaaaaaa"
 * </pre>
 */
public class ShortestCommonSupersequence {
  public static void main(String[] args) {
    String str1 = "abac";
    String str2 = "cab";
    System.out.println("Shortest Common Supersequence: " + shortestCommonSupersequence(str1, str2));
  }

  private static String shortestCommonSupersequence(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();
    String[][] dp = new String[m + 1][n + 1];

    for (int i = m; i >= 0; i--) {
      for (int j = n; j >= 0; j--) {
        if (i == m || j == n) dp[i][j] = "";
        else if (str1.charAt(i) == str2.charAt(j)) dp[i][j] = str1.charAt(i) + dp[i + 1][j + 1];
        else dp[i][j] = dp[i][j + 1].length() > dp[i + 1][j].length() ? dp[i][j + 1] : dp[i + 1][j];
      }
    }

    String lcs = dp[0][0];

    StringBuilder result = new StringBuilder();

    int p1 = 0;
    int p2 = 0;
    for (char c : lcs.toCharArray()) {
      while (str1.charAt(p1) != c) result.append(str1.charAt(p1++));
      while (str2.charAt(p2) != c) result.append(str2.charAt(p2++));
      result.append(c);
      p1++;
      p2++;
    }

    return result + str1.substring(p1) + str2.substring(p2);
  }
}
