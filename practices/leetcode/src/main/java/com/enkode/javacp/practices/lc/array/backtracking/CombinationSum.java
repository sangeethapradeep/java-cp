package com.enkode.javacp.practices.lc.array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 39
 *
 * <pre>
 *     Test Cases:
 *      2,3,6,7         7
 *      2,3,5           8
 *      2               1
 *      1               2
 * </pre>
 *
 * Solution: Using backtracking (similar to DFS) go through each an d every solution.
 */
public class CombinationSum {

  public static void main(String[] args) {
    int[] nums = {2, 3, 6, 7};
    int target = 7;
    System.out.println(combinationSum(nums, target));
  }

  private static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    Arrays.sort(candidates);
    findSum(result, list, candidates, target, 0);
    return result;
  }

  private static void findSum(
      List<List<Integer>> result, List<Integer> list, int[] nums, int target, int start) {
    if (target < 0) return;
    else if (target == 0) result.add(new ArrayList<>(list));
    else {
      for (int i = start; i < nums.length; i++) {
        list.add(nums[i]);
        findSum(result, list, nums, target - nums[i], i);
        list.remove(list.size() - 1);
      }
    }
  }
}
