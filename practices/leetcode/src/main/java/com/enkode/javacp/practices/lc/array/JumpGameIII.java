package com.enkode.javacp.practices.lc.array;

/**
 * Problem 1306
 *
 * <pre>
 *     Test Cases:
 *          arr = [4,2,3,0,3,1,2], start = 5
 *          arr = [4,2,3,0,3,1,2], start = 0
 *          arr = [3,0,2,1,2], start = 2
 * </pre>
 */
public class JumpGameIII {
  public static void main(String[] args) {
    int[] arr = {4, 2, 3, 0, 3, 1, 2};
    int start = 5;
    System.out.println("Is Jump Possible? : " + canReach(arr, start));
  }

  private static boolean canReach(int[] arr, int start) {
    if (start < arr.length && start >= 0 && arr[start] < arr.length) {
      int jump = arr[start];
      arr[start] += arr.length;
      return jump == 0 || canReach(arr, start + jump) || canReach(arr, start - jump);
    }
    return false;
  }
}
