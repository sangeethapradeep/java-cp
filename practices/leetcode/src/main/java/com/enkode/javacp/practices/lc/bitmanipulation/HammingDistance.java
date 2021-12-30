package com.enkode.javacp.practices.lc.bitmanipulation;

/**
 * Problem 461
 *
 * <pre>
 *     Test Cases:
 *          x = 1, y = 4
 *          x = 3, y = 1
 * </pre>
 */
public class HammingDistance {
  public static void main(String[] args) {
    System.out.println(hammingDistance(1, 4));
  }

  private static int hammingDistance(int x, int y) {
    int xor = x ^ y;
    int count = 0;
    while (xor != 0) {
      xor &= (xor - 1);
      ++count;
    }

    return count;
  }
}
