package com.enkode.javacp.practices.lc.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Problem 347
 *
 * <pre>
 *     nums = [1,1,1,2,2,3], k = 2
 *     nums = [1], k = 1
 * </pre>
 */
public class TopKFrequentElements {
  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 2, 2, 3};
    int k = 2;
    System.out.println("Top K Frequent Elements: " + Arrays.toString(topKFrequent(nums, k)));
  }

  private static int[] topKFrequent(int[] nums, int k) {
    final Map<Integer, Integer> freqmap =
        Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(a -> 1)));

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(freqmap::get));

    freqmap
        .keySet()
        .forEach(
            n -> {
              minHeap.add(n);
              if (minHeap.size() > k) minHeap.poll();
            });

    List<Integer> result = new ArrayList<>(minHeap);
    return result.stream().mapToInt(i -> i).toArray();
  }
}
