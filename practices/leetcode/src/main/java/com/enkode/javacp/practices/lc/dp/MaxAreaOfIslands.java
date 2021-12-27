package com.enkode.javacp.practices.lc.dp;

/**
 * Problem 695
 *
 * <pre>
 *     Test Cases:
 *          [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * </pre>
 */
public class MaxAreaOfIslands {
  public static void main(String[] args) {
    int[][] grid = {
      {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };
    System.out.println(maxAreaOfIsland(grid));
  }

  public static int maxAreaOfIsland(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int maxArea = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          maxArea = Math.max(maxArea, areaOfIsland(grid, i, j));
        }
      }
    }
    return maxArea;
  }

  private static int areaOfIsland(int[][] grid, int i, int j) {
    int m = grid.length;
    int n = grid[0].length;
    int area = 0;

    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return area;

    area++;
    grid[i][j] = -1;

    area += areaOfIsland(grid, i - 1, j);
    area += areaOfIsland(grid, i + 1, j);
    area += areaOfIsland(grid, i, j - 1);
    area += areaOfIsland(grid, i, j + 1);

    return area;
  }
}
