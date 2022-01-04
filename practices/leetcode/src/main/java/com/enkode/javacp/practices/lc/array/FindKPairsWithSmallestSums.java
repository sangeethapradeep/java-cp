package com.enkode.javacp.practices.lc.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem 373
 *
 * <pre>
 *     Test Cases:
 *          nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 *          nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 *          nums1 = [1,2], nums2 = [3], k = 3
 * </pre>
 */
public class FindKPairsWithSmallestSums {
  public static void main(String[] args) {
    int[] nums1 = {1, 7, 11};
    int[] nums2 = {2, 4, 6};
    int k = 3;

    System.out.println(kSmallestPairs(nums1, nums2, k));
  }

  private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new ArrayList<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
    for (int i = 0; i < nums1.length && i < k; i++) {
      pq.offer(new int[] {nums1[i], nums2[0], 0});
    }

    while (k > 0 && !pq.isEmpty()) {
      int[] curr = pq.poll();
      result.add(List.of(curr[0], curr[1]));
      if (curr[2] + 1 < nums2.length)
        pq.offer(new int[] {curr[0], nums2[curr[2] + 1], curr[2] + 1});
      k--;
    }

    return result;
  }
}
