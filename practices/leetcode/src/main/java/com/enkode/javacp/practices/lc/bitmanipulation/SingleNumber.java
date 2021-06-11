package com.enkode.javacp.practices.lc.bitmanipulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Problem 136.
 * <pre>
 *   Test Case:
 *        2,2,1
 *        4,1,2,1,2
 *        1
 * </pre>
 */
public class SingleNumber {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] string = br.readLine().split(",");
    int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
    sb.append(singleNumber(nums));
    System.out.println(sb);
  }

  private static int singleNumber(int[] nums) {
    int x = 0;
    for (int num : nums) {
      x ^= num;
    }
    return x;
  }
}
