package com.enkode.javacp.practices.lc.integers;

/**
 * Problem 70
 *
 * <pre>
 *     Test Cases
 *     2
 *     3
 * </pre>
 *
 *
 * This problem can be reduced to solving fibinocci series.
 * When n =1
 * 0-1
 *
 * When n =2
 * 0-1-2, 0-2
 *
 * When n=3
 * 0-1-2, 0-1-2-3, 0-2-3 (combining previous two)
 *
 * When n=4
 * 0-1-2-4, 0-2-4, 0-1-2-4, 0-1-2-3-4, 0-2-3-4
 *
 */
public class ClimbingStairs {
  public static void main(String[] args) {
    int n = 2;
    System.out.println(climbStairs(n));
  }

  private static int climbStairs(int n) {
    int curr = 1;
    int prev = 1;
    for(int i= 1; i < n; i++) {
      curr = curr + prev;
      prev = curr - prev;
    }
    return curr;
  }
}
