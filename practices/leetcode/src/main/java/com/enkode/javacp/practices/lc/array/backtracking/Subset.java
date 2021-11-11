package com.enkode.javacp.practices.lc.array.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 78
 *
 * <pre>
 *     Test Cases:
 *          1,2,3
 *          0
 * </pre>
 */
public class Subset {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    System.out.println(subsets(nums));
  }

  private static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    subsetByDfs(nums, 0, new ArrayList<>(), result);
    return result;
  }

  private static void subsetByDfs(
      int[] nums, int pos, List<Integer> path, List<List<Integer>> result) {
    result.add(new ArrayList<>(path));
    for (int i = pos; i < nums.length; i++) {
      path.add(nums[i]);
      subsetByDfs(nums, i + 1, path, result);
      path.remove(path.size() - 1);
    }
  }
}
