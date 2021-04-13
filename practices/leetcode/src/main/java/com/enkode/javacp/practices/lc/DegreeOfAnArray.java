package com.enkode.javacp.practices.lc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the
 * maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has
 * the same degree as nums.
 * <p>
 * Test Cases:
 * <p> 1,2,2,3,1
 * <p> 1,2,2,3,1,4,2
 */

public class DegreeOfAnArray {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(",");
        int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
        findShortestSubArray(nums);
        System.out.println(sb);
    }

    private static void findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            left.putIfAbsent(nums[index], index);
            count.put(nums[index], count.getOrDefault(nums[index], 0) + 1);
            right.put(nums[index], index);
        }

        int shortestSubArray = nums.length;
        int degree = Collections.max(count.values());
        for (int num : count.keySet()) {
            if (count.get(num) == degree) {
                shortestSubArray = Math.min(shortestSubArray, right.get(num) - left.get(num) + 1);
            }
        }

        sb.append(shortestSubArray);
    }
}
