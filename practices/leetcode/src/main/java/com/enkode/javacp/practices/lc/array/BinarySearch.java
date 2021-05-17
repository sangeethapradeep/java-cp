package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Problem 704.
 * <pre>
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index.
 * Otherwise, return -1. *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Test Cases:
 *       -1,0,3,5,9,12    9
 *       -1,0,3,5,9,12    2
 * </pre>
 */
public class BinarySearch {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(",");
        int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(br.readLine());
        sb.append(search(nums, target));
        System.out.println(sb);
    }

    private static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                break;
            }
        }
        return nums[mid] == target ? mid : -1;
    }

}
