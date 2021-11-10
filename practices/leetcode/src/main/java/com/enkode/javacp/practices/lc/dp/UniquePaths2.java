package com.enkode.javacp.practices.lc.dp;

/**
 * Problem 63
 *
 * <pre>
 *     Test Cases:
 *          [[0,0,0],[0,1,0],[0,0,0]]
 *          [[0,1],[0,0]]
 *          [[1,0]]
 *          [[0,0],[1,1],[0,0]]
 *          [[0,1,0,0,0],[1,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]]
 * </pre>
 */
public class UniquePaths2 {

  public static void main(String[] args) {
    int[][] obstacleGrid = {{0, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
    System.out.println(uniquePathsWithObstacles(obstacleGrid));
  }

  private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

    for (int i = 0; i < m; i++) {
      if (obstacleGrid[i][0] == 1 || (i > 0 && dp[i - 1][0] == 0)) dp[i][0] = 0;
      else dp[i][0] = 1;
    }

    for (int j = 0; j < n; j++) {
      if (obstacleGrid[0][j] == 1 || (j > 0 && dp[0][j - 1] == 0)) dp[0][j] = 0;
      else dp[0][j] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
        else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }

    return dp[m - 1][n - 1];
  }
}
