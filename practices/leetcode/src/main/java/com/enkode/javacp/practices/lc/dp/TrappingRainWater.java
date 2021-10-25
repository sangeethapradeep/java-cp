package com.enkode.javacp.practices.lc.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem 42
 *
 * <pre>
 *     [0,1,0,2,1,0,1,3,2,1,2,1]
 *     [4,2,0,3,2,5]
 * </pre>
 *
 * <pre>
 * There are three approaches
 *      1. Brute Force O(n^2), O(1)
 *      2. Improvement of 1. with memoization O(3n), O(n)
 *      3. Improvementn of 2 using stack O(n), O(n)
 * </pre>
 */
public class TrappingRainWater {
  public static void main(String[] args) {
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trap(height));
  }

  /*Approach 1*/
  /*  private static int trap(int[] height) {
    int ans = 0;
    for(int i = 0; i < height.length; i++) {
      int left_max = 0;
      int right_max = 0;
      for(int k=i; k >=0; k--) {
        left_max = Math.max(left_max, height[k]);
      }
      for(int j=i; j < height.length; j++) {
        right_max = Math.max(right_max, height[j]);
      }
      ans += Math.min(left_max, right_max) - height[i];
    }
    return ans;
  }*/

  /*Approach 2*/
  /*private static int trap(int[] height) {
    int ans = 0;
    int[] right_max = new int[height.length];
    int[] left_max = new int[height.length];
    int max = 0;
    for (int k = 0; k < height.length; k++) {
      left_max[k] = Math.max(max, height[k]);
      max = left_max[k];
    }
    max = 0;
    for (int k = height.length - 1; k >= 0; k--) {
      right_max[k] = Math.max(max, height[k]);
      max = right_max[k];
    }
    for (int i = 0; i < height.length; i++) {
      ans += Math.min(left_max[i], right_max[i]) - height[i];
    }
    return ans;
  }*/

  /*Approach 3*/
  private static int trap(int[] height) {
    int ans = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for(int i =0; i< height.length; i++) {
      while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
        int top = stack.pop();
        if(stack.isEmpty()) break;
        int distance = i - stack.peek() - 1;
        int bounding_height = Math.min(height[i], height[stack.peek()]) - height[top];
        ans += distance * bounding_height;
      }
      stack.push(i);
    }
    return ans;
  }
}
