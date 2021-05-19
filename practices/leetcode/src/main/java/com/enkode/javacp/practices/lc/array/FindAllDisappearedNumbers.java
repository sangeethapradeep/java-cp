package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Problem 448.
 * <pre>
 *     Test Cases:
 *          4,3,2,7,8,2,3,1
 *          1,1
 * </pre>
 */
public class FindAllDisappearedNumbers {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(",");
        int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
        sb.append(findDisappearedNumbers(nums));
        System.out.println(sb);
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i< nums.length; i++) {
            int n = Math.abs(nums[i]);
            if(nums[n-1] > 0) {
                nums[n-1] = -1*nums[n-1];
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i+1);
            }
        }

        return result;
    }
}
