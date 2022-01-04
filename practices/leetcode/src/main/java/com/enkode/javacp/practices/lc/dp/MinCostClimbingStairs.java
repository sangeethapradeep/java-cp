package com.enkode.javacp.practices.lc.dp;

/**
 * Problem 746
 *
 * <pre>
 *     Test Cases:
 *          cost = [10,15,20]
 *          cost = [1,100,1,1,1,100,1,1,100,1]
 * </pre>
 */
public class MinCostClimbingStairs {
  public static void main(String[] args) {
    int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    System.out.println("Min Cost: " + minCostClimbingStairs(cost));
  }

  private static int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = cost[0];

    for (int i = 2; i < n + 1; i++) {
      dp[i] = cost[i - 1] + Math.min(dp[i - 1], dp[i - 2]);
    }

    return Math.min(dp[n], dp[n - 1]);
  }
}
