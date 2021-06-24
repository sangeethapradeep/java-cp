package com.enkode.javacp.practices.lc.array;

import java.util.Arrays;

/**
 * Problem 733.
 */
public class FloodFill {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
    int sr = 1;
    int sc = 1;
    int newColor = 2;
    sb.append(Arrays.toString(floodFill(image, sr, sc, newColor)));
    System.out.println(sb);
  }

  private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int oldColor = image[sr][sc];
    image[sr][sc] = newColor;
    if (sc + 1 < image[sr].length && image[sr][sc + 1] == oldColor
      && image[sr][sc + 1] != newColor) {
      floodFill(image, sr, sc + 1, newColor);
    }
    if (sc - 1 > -1 && image[sr][sc - 1] == oldColor && image[sr][sc - 1] != newColor) {
      floodFill(image, sr, sc - 1, newColor);
    }
    if (sr + 1 < image.length && image[sr + 1][sc] == oldColor && image[sr + 1][sc] != newColor) {
      floodFill(image, sr + 1, sc, newColor);
    }
    if (sr - 1 > -1 && image[sr - 1][sc] == oldColor && image[sr - 1][sc] != newColor) {
      floodFill(image, sr - 1, sc, newColor);
    }
    return image;
  }
}
