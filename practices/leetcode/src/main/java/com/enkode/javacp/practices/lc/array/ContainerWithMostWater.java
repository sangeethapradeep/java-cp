package com.enkode.javacp.practices.lc.array;

/**
 * Problem 11
 *
 * <pre>
 *     Test cases:
 *          1,8,6,2,5,4,8,3,7
 *          1,1
 *          4,3,2,1,4
 *          1,2,1
 * </pre>
 */
public class ContainerWithMostWater {
  public static void main(String[] args) {
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(maxArea(height));
  }

  private static int maxArea(int[] height) {
    int maxArea = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
      if (height[left] < height[right]) left++;
      else right--;
    }
    return maxArea;
  }
}
