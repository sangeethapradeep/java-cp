package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Problem 350.
 * <pre>
 *   Test Cases:
 *        1,2,2,1     2,2
 *        4,9,5       9,4,9,8,4
 * </pre>
 */
public class IntersectionOfTwoArraysII {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] string = br.readLine().split(",");
    int[] nums1 = Stream.of(string).mapToInt(Integer::parseInt).toArray();
    string = br.readLine().split(",");
    int[] nums2 = Stream.of(string).mapToInt(Integer::parseInt).toArray();
    sb.append(Arrays.toString(intersect(nums1, nums2)));
    System.out.println(sb);
  }

  private static int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    List<Integer> result = new ArrayList<>();
    int i = 0;
    int j = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j]) {
        result.add(nums1[i]);
        i++;
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
      }
    }
    return result.stream().mapToInt(k -> k).toArray();
  }
}
