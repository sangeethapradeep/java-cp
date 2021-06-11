package com.enkode.javacp.practices.lc.bitmanipulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Problem 191.
 * <pre>
 *   Test Cases:
 *        00000000000000000000000000001011
 *        00000000000000000000000010000000
 *        11111111111111111111111111111101
 * </pre>
 */
public class NumberOf1Bits {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    sb.append(hammingWeight(n));
    System.out.println(sb);
  }

  private static int hammingWeight(int n) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      if ((n & (1 << i)) != 0) {
        count++;
      }
    }
    return count;
  }
}
