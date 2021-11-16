package com.enkode.javacp.practices.lc.array;

import java.util.Arrays;

/**
 * Problem 167
 * <pre>
 *     Test Cases:
 *          2,7,11,15   9
 *          2,3,4       6
 *          -1,0        -1
 * </pre>
 */
public class TwoSumIIInputArraySorted {
  public static void main(String[] args) {
    int[] numbers= {2,7,11,15 };
    int target = 9;
    System.out.println(Arrays.toString(twoSum(numbers, target)));
  }

  private static int[] twoSum(int[] numbers, int target) {
      int l = 0, r = numbers.length -1;
      while(numbers[l] + numbers[r] != target) {
          if(numbers[l] + numbers[r] < target) l++;
          else r--;
      }
      return new int[]{l+1, r+1};
  }
}
