package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * <pre>
 * Given an integer array nums, find a contiguous non-empty subarray within the array
 * that has the largest product, and return the product.
 * It is guaranteed that the answer will fit in a 32-bit integer. *
 * A subarray is a contiguous subsequence of the array.
 *
 * Test cases:
 *      2,3,-2,4
 *     -2,0,-1
 * </pre>
 */

public class MaximumProductSubArray {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(",");
        int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
        sb.append(maxProduct(nums));
        System.out.println(sb);
    }

    private static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int index = 1; index < nums.length; index++) {
            int max = currentMax * nums[index];
            currentMax = Math.max(Math.max(max, currentMin * nums[index]), nums[index]);
            currentMin = Math.min(Math.min(max, currentMin * nums[index]), nums[index]);
            maxProduct = Math.max(maxProduct, currentMax);
        }
        return maxProduct;
    }
}
