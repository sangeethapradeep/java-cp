package com.enkode.javacp.practices.lc.integers;

/**
 * Problem 204
 *
 * <pre>
 *       Test Cases:
 *              10
 *              1
 *              0
 * </pre>
 */
public class CountPrimes {

  public static void main(String[] args) {
    int n = 10;
    System.out.println(countPrimes(n));
  }

  private static int countPrimes(int n) {
    if (n < 3) return 0;
    int counter = 1;
    boolean[] notPrime = new boolean[n];
    for (int i = 3; i < n; i += 2) {
      if (!notPrime[i]) {
        counter++;
        for (int j = i * 3; j < n; j += i) {
          notPrime[j] = true;
        }
      }
    }
    return counter;
  }
}
