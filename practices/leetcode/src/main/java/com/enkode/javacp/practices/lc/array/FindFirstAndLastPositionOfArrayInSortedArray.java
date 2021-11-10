package com.enkode.javacp.practices.lc.array;

import java.util.Arrays;

/**
 * Problem 34
 *
 * <pre>
 *     Test Cases:
 *          5,7,7,8,8,10        8
 *          5,7,7,8,8,10        6
 *          []                  0
 *          2,2                 2
 * </pre>
 */
public class FindFirstAndLastPositionOfArrayInSortedArray {
  public static void main(String[] args) {
    int[] nums = {5, 7, 7, 8, 8, 10};
    int target = 8;
    System.out.println(Arrays.toString(searchRange(nums, target)));
  }

  private static int[] searchRange(int[] nums, int target) {
    int l = 0;
    int u = nums.length;
    while (l < u) {
      int mid = (l + u) / 2;
      if (nums[mid] < target) l = mid + 1;
      else if (nums[mid] > target) u = mid;
      else {
        int start = mid;
        while (start - 1 >= 0 && nums[start] == nums[start - 1]) start--;
        while (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) mid++;
        return new int[] {start, mid};
      }
    }
    return new int[] {-1, -1};
  }
}
