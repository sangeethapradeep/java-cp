package com.enkode.javacp.practices.interview.top200;

/**
 * Problem 300
 *
 * <pre>
 *     nums = [10,9,2,5,3,7,101,18]
 *     nums = [0,1,0,3,2,3]
 *     nums = [7,7,7,7,7,7,7]
 * </pre>
 */
public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 2, 3};
    System.out.println("Count of longest increasing subsequence O(nlogn): " + lengthOfLIS(nums));
    System.out.println("Count of longest increasing subsequence O(n^2): " + lengthOfLIS2(nums));
  }

  // O(nlogn) logic
  private static int lengthOfLIS(int[] nums) {
    int[] lis = new int[2500];
    int index = -1;

    lis[++index] = nums[0];

    for (int i = 1; i < nums.length; i++) {

      if (lis[index] < nums[i]) lis[++index] = nums[i];
      else {
        int start = 0;
        int end = index;

        while (start < end) {
          int mid = (end - start) / 2 + start;
          if (lis[mid] < nums[i]) start = mid + 1;
          if (lis[mid] >= nums[i]) end = mid;
        }

        lis[start] = nums[i];
      }
    }

    return index + 1;
  }

  // O(n^2)
  private static int lengthOfLIS2(int[] nums) {
    int n = nums.length;
    int[] lis = new int[n];
    lis[0] = 1;

    int maxLength = lis[0];

    for (int i = 1; i < n; i++) {
      lis[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i] && lis[j] + 1 > lis[i]) lis[i] = lis[j] + 1;
      }
      if (lis[i] > maxLength) maxLength = lis[i];
    }

    return maxLength;
  }
}
