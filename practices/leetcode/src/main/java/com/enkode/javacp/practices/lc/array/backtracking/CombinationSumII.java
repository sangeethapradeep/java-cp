package com.enkode.javacp.practices.lc.array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 40
 *
 * <pre>
 *     Test Cases:
 *      10,1,2,7,6,1,5        8
 *      2,5,2,1,2             5
 * </pre>
 *
 * Solution: Using backtracking (similar to DFS) go through each an d every solution.
 */
public class CombinationSumII {

  public static void main(String[] args) {
    int[] nums = {2, 3, 6, 7};
    int target = 7;
    System.out.println(combinationSum2(nums, target));
  }

  private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    findCombSum(result, new ArrayList<>(), candidates, target, 0);
    return result;
  }

  private static void findCombSum(
      List<List<Integer>> result, List<Integer> list, int[] nums, int target, int start) {
    if (target < 0) return;
    else if (target == 0) result.add(new ArrayList<>(list));
    else {
      for (int i = start; i < nums.length; i++) {
        if (i > start && nums[i] == nums[i - 1]) continue;
        list.add(nums[i]);
        findCombSum(result, list, nums, target - nums[i], i + 1);
        list.remove(list.size() - 1);
      }
    }
  }
}
