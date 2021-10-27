package com.enkode.javacp.practices.lc.array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 90
 *
 * <pre>
 *     Test Cases:
 *     1,2,2
 *     4,4,4,1,4
 *     0
 * </pre>
 */
public class SubsetsII {
  public static void main(String[] args) {
    int[] nums = {4, 4, 4, 1, 4};
    System.out.println(subsetsWithDup(nums));
  }

  private static List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    subsetdfs(nums, 0, new ArrayList<>(), result);
    return result;
  }

  private static void subsetdfs(
      int[] nums, int pos, List<Integer> path, List<List<Integer>> result) {
    if (pos <= nums.length) result.add(path);
    for (int i = pos; i < nums.length; i++) {
      path.add(nums[i]);
      subsetdfs(nums, i + 1, new ArrayList<>(path), result);
      path.remove(path.size() - 1);
      while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
    }
  }
}
