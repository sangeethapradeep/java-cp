package com.enkode.javacp.practices.lc.integers;

/**
 * Problem 509
 *
 * <pre>
 *     Test Cases:
 *          n = 2
 *          n = 4
 *          n = 30
 * </pre>
 */
public class FibonacciNumber {
  public static void main(String[] args) {
    System.out.println(fib(30));
  }

  private static int fib(int n) {
    if (n < 2) return n;

    int f0 = 0, f1 = 1;
    for (int i = 2; i <= n; i++) {
      int f = f0 + f1;
      f0 = f1;
      f1 = f;
    }
    return f1;
  }
}
