package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Problem 532.
 * <pre>
 *   Test Cases:
 *        3,1,4,1,5               2
 *        1,2,3,4,5               1
 *        1,3,1,5,4               0
 *        1,2,4,4,3,3,0,9,2,3     3
 *        -1,-2,-3                1
 * </pre>
 */
public class KDiffPairsInAnArray {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] string = br.readLine().split(",");
    int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
    int k = Integer.parseInt(br.readLine());
    sb.append(findPairs(nums, k));
    System.out.println(sb);
  }

  private static int findPairs(int[] nums, int k) {
    Arrays.sort(nums);
    int count = 0;
    int i = 0;
    int n = nums.length;
    if (k == 0) {
      while (i < n - 1) {
        if (nums[i] == nums[i + 1]) {
          count++;
          while (i < n - 1 && nums[i] == nums[i + 1]) {
            i++;
          }
        }
        i++;
      }
      return count;
    }

    i = 0;
    int j = 1;

    while (j < n) {
      while (i < n - 1 && nums[i] == nums[i + 1]) {
        i++;
      }
      while (j < n - 1 && nums[j] == nums[j + 1]) {
        j++;
      }

      if (i == j) {
        j++;
        continue;
      }
      if (Math.abs(nums[j] - nums[i]) == k) {
        count++;
        i++;
        j++;
      } else if (Math.abs(nums[j] - nums[i]) < k) {
        j++;
      } else {
        i++;
      }
    }

    return count;
  }
}
