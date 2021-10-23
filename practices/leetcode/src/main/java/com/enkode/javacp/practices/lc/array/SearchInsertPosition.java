package com.enkode.javacp.practices.lc.array;

/**
 * Problem 35
 *
 * <pre>
 *     Test Case:
 *     1,3,5,6      5
 *     1,3,5,6      2
 *     1,3,5,6      7
 *     1,3,5,6      0
 *     1            0
 * </pre>
 */
public class SearchInsertPosition {

  public static void main(String[] args) {
    int[] nums = {1, 3, 5, 6};
    int target = 5;
    System.out.println(searchInsert(nums, target));
  }

  private static int searchInsert(int[] nums, int target) {
    int l = 0;
    int u = nums.length;
    while (l < u) {
      int mid = (l + u) / 2;
      if (nums[mid] == target) return mid;
      else if (nums[mid] < target) l = mid + 1;
      else u = mid;
    }
    return l;
  }
}
