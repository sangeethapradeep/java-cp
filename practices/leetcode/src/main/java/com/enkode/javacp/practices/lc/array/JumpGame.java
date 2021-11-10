package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Problem 55.
 *
 * <pre>
 *   Test Cases:
 *        2,3,1,1,4
 *        3,2,1,0,4
 *        2,0,0
 * </pre>
 */
public class JumpGame {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] string = br.readLine().split(",");
    int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
    sb.append(canJump(nums));
    System.out.println(sb);
  }

  private static boolean canJump(int[] nums) {
    int n = nums.length;
    int reachable = n - 1;
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i] + i >= reachable) reachable = i;
    }
    return reachable <= 0;
  }
}
