package com.enkode.javacp.practices.lc.integers;

/**
 * Problem 278
 *
 * <pre>
 *     Test Cases:
 *          5               4
 *          1               1
 *          3               2
 *          2126753390      1702766719
 * </pre>
 */
public class FirstBadVersion {
  public static final int bad = 1702766719;

  public static void main(String[] args) {
    int num = 2126753390;
    System.out.println(firstBadVersion(num));
  }

  private static int firstBadVersion(int n) {
    int l = 1;
    int h = n;
    while (l < h) {
      int mid = l + (h - l) / 2;
      if (isBadVersion(mid)) h = mid;
      else l = mid + 1;
    }

    return l;
  }

  private static boolean isBadVersion(int num) {
    return num >= bad;
  }
}
