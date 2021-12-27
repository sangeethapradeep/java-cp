package com.enkode.javacp.practices.lc.array.matrix;

import java.util.Arrays;

/**
 * Problem 661
 *
 * <pre>
 *     img = [[1,1,1],[1,0,1],[1,1,1]]
 *     img = [[100,200,100],[200,50,200],[100,200,100]]
 * </pre>
 */
public class ImageSmoother {
  public static void main(String[] args) {
    int[][] img = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
    System.out.println(Arrays.deepToString(imageSmoother(img)));
  }

  private static int[][] imageSmoother(int[][] img) {
    int m = img.length;
    int n = img[0].length;
    int[][] result = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result[i][j] = smoother(img, i, j);
      }
    }
    return result;
  }

  private static int smoother(int[][] img, int i, int j) {
    int m = img.length;
    int n = img[0].length;

    int count = 0;
    int sum = 0;

    for (int a = i - 1; a <= i + 1; a++) {
      for (int b = j - 1; b <= j + 1; b++) {
        if (a < 0 || a >= m || b < 0 || b >= n) continue;
        count++;
        sum += img[a][b];
      }
    }
    return sum / count;
  }
}
