package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * <pre>
 *     Given an integer array nums,
 *          return true if any value appears at least twice in the array,
 *          and return false if every element is distinct.
 *
 *     Test Cases:
 *          1,2,3,1
 *          1,2,3,4
 *          1,1,1,3,3,4,3,2,4,2
 * </pre>
 */

public class ContainsDuplicate {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(",");
        int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
        sb.append(containsDuplicate(nums));
        System.out.println(sb);
    }

    private static boolean containsDuplicate(int[] nums) {
        /*Hashset Solution
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)) return true;
        }
        return false;*/
        Arrays.sort(nums);
        for (int index = 0; index < nums.length - 1; index++) {
            if (nums[index] == nums[index + 1]) return true;
        }
        return false;
    }
}
