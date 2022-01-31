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
    int[] nums1 = {1, 5, 8, 10, 18, 20};
    int[] nums2 = {2, 3, 6, 7};
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
    right = nums1.length;

    double aLeft, aRight, bLeft, bRight;

    double median = 0f;

    while (left <= right) {
      mid1 = (right - left) / 2 + left;
      mid2 = half - mid1;

      aLeft = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
      aRight = mid1 == m ? Integer.MAX_VALUE: nums1[mid1];
      bLeft = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
      bRight = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];

      if(aLeft > bRight) right = mid1 - 1;
      else if (bLeft > aRight) left = mid1 + 1;
      else {
        if ((m + n) % 2 == 1) median =  Math.min(aRight, bRight);
        else median = (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
        break;
      }
    }
    return median;
  }
}
