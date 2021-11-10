package com.enkode.javacp.practices.lc.array.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 46
 *
 * <pre>
 *     Test Cases:
 *          1,2,3
 *          0,1
 *          1
 * </pre>
 */
public class Permutations {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    System.out.println(permute(nums));
  }

  private static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] isVisited = new boolean[nums.length];
    for (int i = 0; i < nums.length; i++) isVisited[i] = false;
    permutationByDfs(nums, result, new ArrayList<>(), isVisited);
    return result;
  }

  private static void permutationByDfs(
      int[] nums, List<List<Integer>> result, List<Integer> currList, boolean[] isVisited) {
    if (currList.size() == nums.length) result.add(new ArrayList<>(currList));
    else {
      for (int i = 0; i < nums.length; i++) {
        if (!isVisited[i]) {
          currList.add(nums[i]);
          isVisited[i] = true;
          permutationByDfs(nums, result, currList, isVisited);
          currList.remove(currList.size() - 1);
          isVisited[i] = false;
        }
      }
    }
  }
}
