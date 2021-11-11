package com.enkode.javacp.practices.lc.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Probelm 15
 *
 * <pre>
 *     Test Cases:
 *          -1,0,1,2,-1,-4
 *          []
 *          0
 * </pre>
 */
public class ThreeSum {
  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    System.out.println(threeSum(nums));
  }

  private static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new LinkedList<>();
    int n = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i + 2 < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int low = i + 1;
      int high = n - 1;
      int target = -(nums[i]);
      while (low < high) {
        int currentSum = nums[low] + nums[high];
        if (currentSum < target) low++;
        else if (currentSum > target) high--;
        else {
          List<Integer> curList = Arrays.asList(nums[i], nums[low], nums[high]);
          result.add(curList);
          low++;
          high--;
          while (low < high && nums[low] == nums[low - 1]) low++;
          while (low < high && nums[high] == nums[high + 1]) high--;
        }
      }
    }
    return result;
  }
}
