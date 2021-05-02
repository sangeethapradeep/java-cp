package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * <pre>
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Test Cases:
 *      -2,1,-3,4,-1,2,1,-5,4
 *      1
 *      5,4,-1,7,8
 * </pre>
 */
public class MaximumSubArray {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(",");
        int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
        sb.append(maxSubArray(nums));
        System.out.println(sb);
    }

    private static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = maxSum;
        for (int index = 1; index < nums.length; index++) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += nums[index];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
