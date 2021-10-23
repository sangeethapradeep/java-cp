package com.enkode.javacp.practices.lc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 57
 */
public class InsertInterval {

  public static void main(String[] args) {
    int[][] intervals = new int[][]{{1,3},{6,9}};
    int[] newInterval = {2,5};
    int[][] result = insert(intervals, newInterval);
    System.out.println(Arrays.deepToString(result));
  }

  private static int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> results = new ArrayList<>();
    for (int[] interval : intervals) {
      if (newInterval[0] > interval[1]) {
        results.add(interval);
      } else if (newInterval[1] < interval[0]) {
        results.add(newInterval);
        newInterval = interval;
      } else {
        newInterval[0] = Math.min(interval[0], newInterval[0]);
        newInterval[1] = Math.max(interval[1], newInterval[1]);
      }
    }
    results.add(newInterval);
    return results.toArray(new int[results.size()][2]);
  }
}
