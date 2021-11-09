package com.enkode.javacp.practices.lc.array;

import java.util.Arrays;

/**
 * Problem 16
 *
 * <pre>
 *     Test Cases:
 *          -1,2,1,-4           1
 *          0,0,0               1
 * </pre>
 */
public class ThreeSumClosest {
  public static void main(String[] args) {
    int[] nums = {-1, 2, 1, -4};
    int target = 1;
    System.out.println(threeSumClosest(nums, target));
  }

  private static int threeSumClosest(int[] nums, int target) {
    int minDiff = Integer.MAX_VALUE;
    int closestSum = -1;
    int n = nums.length;
    Arrays.sort(nums);
    for (int pivot = 0; pivot < n; pivot++) {
      int low = pivot + 1;
      int high = n - 1;
      int currTarget = target - nums[pivot];
      while (low < high) {
        int currSum = nums[low] + nums[high];
        if (currSum < currTarget) {
          int diff = currTarget - currSum;
          if (diff < minDiff) {
            minDiff = diff;
            closestSum = currSum + nums[pivot];
          }
          low++;
        } else if (currTarget < currSum) {
          int diff = currSum - currTarget;
          if (diff < minDiff) {
            minDiff = diff;
            closestSum = currSum + nums[pivot];
          }
          high--;
        } else {
          return currSum + nums[pivot];
        }
      }
    }
    return closestSum;
  }
}
