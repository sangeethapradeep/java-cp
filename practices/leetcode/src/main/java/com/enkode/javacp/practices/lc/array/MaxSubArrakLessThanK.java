package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Problem 713.
 * <pre>
 *   Test Cases:
 *        10, 5, 2, 6         100
 *        1, 2, 3             0
 *        1, 1, 1             1
 * </pre>
 */
public class MaxSubArrakLessThanK {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] string = br.readLine().split(",");
    int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
    int k = Integer.parseInt(br.readLine());
    sb.append(numSubarrayProductLessThanK(nums, k));
    System.out.println(sb);
  }

  private static int numSubarrayProductLessThanK(int[] nums, int k) {
    int count = 0;
    int p = 1;
    int left = 0;
    if (k <= 1) {
      return 0;
    }
    for (int i = 0; i < nums.length; i++) {
      p *= nums[i];
      while (p >= k) {
        p /= nums[left++];
      }
      count += i - left + 1;
    }
    return count;
  }
}
