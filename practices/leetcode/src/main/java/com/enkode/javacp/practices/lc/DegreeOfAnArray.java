package com.enkode.javacp.practices.lc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        Map<Integer, SubArray> frequency = new HashMap<>();
        SubArray shortestSubArray = null;
        for (Integer num : nums) {
            if (frequency.containsKey(num)) {
                continue;
            }
            SubArray subArray = findFrequency(nums, num);
            frequency.put(num, subArray);
            if (shortestSubArray == null || subArray.frequency > shortestSubArray.frequency || (
                    subArray.frequency == shortestSubArray.frequency
                            && subArray.distance < shortestSubArray.distance)) {
                shortestSubArray = subArray;
            }
        }
        sb.append(shortestSubArray.distance);
    }

    private static SubArray findFrequency(int[] nums, int num) {
        SubArray subArray = new SubArray();
        int min = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != num) { continue; }
            if (subArray.frequency == 0) {
                min = i;
            }
            max = i;
            subArray.frequency++;
        }
        subArray.distance = max - min + 1;
        return subArray;
    }


    private static class SubArray {
        int frequency = 0;
        int distance = 0;

        SubArray() {}
    }
}
