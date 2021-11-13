package com.enkode.javacp.practices.lc.array;

/**
 * Problem 33
 *
 * <pre>
 *     Test Cases:
 *          4,5,6,7,0,1,2       0
 *          4,5,6,7,0,1,2       3
 *          1                   0
 * </pre>
 */
public class SearchInRotatedSortedArray {
  public static void main(String[] args) {
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    int target = 3;
    System.out.println(search(nums, target));
  }

  private static int search(int[] nums, int target) {
    int l = 0;
    int u = nums.length - 1;
    while (l <= u) {
      int mid = (l + u) / 2;
      if (nums[mid] == target) return mid;

      if (nums[l] <= nums[mid]) {
        if (target >= nums[l] && target < nums[mid]) {
          u = mid - 1;
        } else l = mid + 1;
      }

      if (nums[mid] <= nums[u]) {
        if (target > nums[mid] && target <= nums[u]) {
          l = mid + 1;
        } else u = mid - 1;
      }
    }
    return -1;
  }
}
