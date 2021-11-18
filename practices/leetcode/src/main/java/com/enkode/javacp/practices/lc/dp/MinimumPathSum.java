package com.enkode.javacp.practices.lc.dp;

/**
 * Problem 64
 *
 * <pre>
 *     Test Cases:
 *          [[1,3,1],[1,5,1],[4,2,1]]
 *          [[1,2,3],[4,5,6]]
 * </pre>
 */
public class MinimumPathSum {
  public static void main(String[] args) {
    int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(minPathSum(grid));
  }

  private static int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] minPath = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 & j == 0) minPath[i][j] = grid[i][j];
        else if (i == 0) minPath[i][j] = minPath[i][j - 1] + grid[i][j];
        else if (j == 0) minPath[i][j] = minPath[i - 1][j] + grid[i][j];
        else minPath[i][j] = Math.min(minPath[i - 1][j], minPath[i][j - 1]) + grid[i][j];
      }
    }

    return minPath[m - 1][n - 1];
  }
}
