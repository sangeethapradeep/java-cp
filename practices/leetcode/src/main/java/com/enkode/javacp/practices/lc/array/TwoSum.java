package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * <pre>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice. *
 * You can return the answer in any order.
 *
 * Test Cases:
 *      2,7,11,15  9
 *      3,2,4      6
 *      3,3        6
 * </pre>
 */
public class TwoSum {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(",");
        int target = Integer.parseInt(br.readLine());
        int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
        sb.append(Arrays.toString(twoSum(nums, target)));
        System.out.println(sb);
    }

    private static int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int index = 0; index < nums.length; index ++) {
           int value = target - nums[index];
           if(map.containsKey(value)) {
               return new int[]{index, map.get(value)};
           } else {
               map.put(nums[index], index);
           }
       }
       return null;
    }
}
