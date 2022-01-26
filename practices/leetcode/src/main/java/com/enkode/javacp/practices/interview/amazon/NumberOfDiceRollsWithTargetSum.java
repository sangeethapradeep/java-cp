package com.enkode.javacp.practices.interview.amazon;

/**
 * Amazon
 * Problem 1155
 *
 * <pre>
 *     Test Cases:
 *          n = 1, k = 6, target = 3
 *          n = 2, k = 6, target = 7
 *          n = 30, k = 30, target = 500
 * </pre>
 */
public class NumberOfDiceRollsWithTargetSum {
  static final int MOD = (int) (1e9 + 7);
  static int[][] dp;

  public static void main(String[] args) {
    int n = 30;
    int k = 30;
    int target = 500;
    System.out.println("Number of Dice Rolls With Target Sum: " + numRollsToTarget(n, k, target));
  }

  public static int numRollsToTarget(int n, int k, int target) {
    dp = new int[n + 1][target + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < target + 1; j++) {
        dp[i][j] = -1;
      }
    }
    return helper(n, k, target);
  }

  private static int helper(int n, int k, int target) {
    if (target == 0 && n == 0) return 1;
    if (target <= 0 || n <= 0) return 0;

    if (dp[n][target] != -1) return dp[n][target];

    int count = 0;

    for (int j = 1; j <= k; j++) count = (count + helper(n - 1, k, target - j)) % MOD;

    return dp[n][target] = count;
  }
}
