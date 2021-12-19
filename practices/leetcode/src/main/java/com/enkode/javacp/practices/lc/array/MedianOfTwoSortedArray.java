package com.enkode.javacp.practices.lc.array;

/**
 * Problem 4
 *
 * <pre>
 *     num1 = 1,3       num2 = 2
 *     num1 = 1,2       num2 = 3,4
 *     num1 = 3,4       num2 = 1,2
 * </pre>
 */
public class MedianOfTwoSortedArray {
  public static void main(String[] args) {
    int[] nums1 = {1, 3};
    int[] nums2 = {2};
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }

  private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      int[] temp = nums1;
      nums1 = nums2;
      nums2 = temp;
    }

    int m = nums1.length;
    int n = nums2.length;

    int half = (m + n) / 2;

    int left, right, mid1, mid2;
    left = 0;
    right = nums1.length - 1;

    double aLeft, aRight, bLeft, bRight;

    while (true) {
      mid1 = (int)Math.floor(((float)right + left) / 2);
      mid2 = half - mid1 - 2;

      aLeft = mid1 < 0 ? Integer.MIN_VALUE : nums1[mid1];
      aRight = mid1 + 1 < m ? nums1[mid1 + 1] : Integer.MAX_VALUE;
      bLeft = mid2 < 0 ? Integer.MIN_VALUE : nums2[mid2];
      bRight = mid2 + 1 < n ? nums2[mid2 + 1] : Integer.MAX_VALUE;

      if (aLeft <= bRight && bLeft <= aRight) {
        if ((m + n) % 2 == 1) return Math.min(aRight, bRight);
        return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
      } else if (aLeft > bRight) {
        right = mid1 - 1;
      } else left = mid1 + 1;
    }
  }
}
