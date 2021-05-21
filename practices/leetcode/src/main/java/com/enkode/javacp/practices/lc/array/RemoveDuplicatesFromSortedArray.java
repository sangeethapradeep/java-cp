package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Problem 26.
 * <pre>
 *     Test Cases:
 *          1,1,2
 *          0,0,1,1,1,2,2,3,3,4
 * </pre>
 */
public class RemoveDuplicatesFromSortedArray {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(",");
        int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
        sb.append(removeDuplicates(nums));
        System.out.println(sb);
    }

    private static int removeDuplicates(int[] nums) {
        int num = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[num] != nums[i]) {
                nums[++num] = nums[i];
            }
        }
        return num + 1;
    }
}
