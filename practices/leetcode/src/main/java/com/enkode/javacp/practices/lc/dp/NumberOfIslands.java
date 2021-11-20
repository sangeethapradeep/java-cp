package com.enkode.javacp.practices.lc.dp;

/**
 * Problem 200
 *
 * <pre>
 *     Test Cases:
 *          [['1','1','1','1','0'],['1','1','0','1','0'],['1','1','0','0','0'],['0','0','0','0','0']]
 *          [['1','1','0','0','0'],['1','1','0','0','0'],['0','0','1','0','0'],['0','0','0','1','1']]
 * </pre>
 */
public class NumberOfIslands {
  public static void main(String[] args) {
    char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    System.out.println(numIslands(grid));
  }

    private static int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length ==0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i< m; i++){
            for(int j=0;j <n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    findIslandByDfs(grid, i , j);
                }
            }
        }
        return count;
    }

    private static void findIslandByDfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || i >= m || j < 0 || j>= n || grid[i][j] != '1')
            return;

        grid[i][j] = 'X';

        findIslandByDfs(grid, i-1, j);
        findIslandByDfs(grid, i, j-1);
        findIslandByDfs(grid, i+1, j);
        findIslandByDfs(grid, i, j+1);
    }
}
