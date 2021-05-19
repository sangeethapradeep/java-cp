package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Problem 283.
 * <pre>
 * Test Cases:
 *          0,1,0,3,12
 *          0
 *          1,0,1
 * </pre>
 */
public class MoveZeroes {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] string = br.readLine().split(",");
    int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
    moveZeroes(nums);
    sb.append(Arrays.toString(nums));
    System.out.println(sb);
  }

  private static void moveZeroes(int[] nums) {
    int current = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[current] = nums[i];
        current++;
      }
    }
    for (int i = current; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}
