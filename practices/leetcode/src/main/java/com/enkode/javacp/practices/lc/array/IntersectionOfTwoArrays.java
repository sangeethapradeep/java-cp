package com.enkode.javacp.practices.lc.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem 349
 * <pre>
 *     Test Cases:
 *          nums1 = [1,2,2,1], nums2 = [2,2]
 *          nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * </pre>
 */
public class IntersectionOfTwoArrays {

  public static void main(String[] args) {
    int[] nums1 = {1,2,2,1};
    int[] nums2 = {2,2};

  }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int num:nums1) {
            set1.add(num);
        }

        int[] result = new int[set1.size()];
        int idx = 0;

        for(int num:nums2) {
            if(set1.contains(num)) {
                result[idx++] = num;
                set1.remove(num);
            }

        }

        return Arrays.copyOf(result, idx);
    }
}
