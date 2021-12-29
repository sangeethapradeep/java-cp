package com.enkode.javacp.practices.lc.array;

/**
 * problem 303
 *
 * <pre>
 *     Test Cases:
 *          ["NumArray", "sumRange", "sumRange", "sumRange"]
 *          [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * </pre>
 */
public class PrefixSum {

  public static void main(String[] args) {
    NumArray obj = new NumArray(new int[]{-2,0,3,-5,2,-1});
    System.out.println("Sum Range 0-2: " + obj.sumRange(0,2));
    System.out.println("Sum Range 2-5: " + obj.sumRange(2,5));
    System.out.println("Sum Range 0-5: " + obj.sumRange(0,5));
  }

  private static class NumArray {

    private int[] prefixSum;

    public NumArray(int[] nums) {
      prefixSum = new int[nums.length + 1];
      for (int i = 1; i < nums.length + 1; i++) {
        prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
      }
    }

    public int sumRange(int left, int right) {
      return prefixSum[right + 1] - prefixSum[left];
    }
  }
}
