package com.enkode.javacp.practices.lc.integers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * problem 268
 */
public class MissingNumber {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] string = br.readLine().split(",");
    int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
    sb.append(missingNumber(nums));
    System.out.println(sb);
  }

  private static int missingNumber(int[] nums) {
    int sum = (nums.length * (nums.length + 1)) / 2;
    for (int num : nums) {
      sum -= num;
    }
    return sum;
  }
}
