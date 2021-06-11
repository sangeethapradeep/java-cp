package com.enkode.javacp.practices.lc.bitmanipulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Problem 231.
 * <pre>
 *   Test Cases:
 *        1
 *        16
 *        3
 *        4
 *        5
 *        -23455658
 * </pre>
 */
public class PowerOfTwo {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    sb.append(isPowerOfTwo(n));
    System.out.println(sb);
  }

  private static boolean isPowerOfTwo(int n) {
    return n != 0 && n != -2147483648 && (n & n - 1) == 0;
  }
}
