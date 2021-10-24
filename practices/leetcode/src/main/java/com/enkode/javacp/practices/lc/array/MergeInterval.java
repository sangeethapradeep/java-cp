package com.enkode.javacp.practices.lc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Problem 56
 *
 * <pre>
 *     Test Cases:
 *     [[1,3],[2,6],[8,10],[15,18]]
 *     [[1,4],[4,5]]
 *     [[1,4],[0,0]]
 * </pre>
 */
public class MergeInterval {
  public static void main(String[] args) {
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    System.out.println(Arrays.deepToString(merge(intervals)));
  }

  private static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    List<int[]> result = new ArrayList<>();
    int[] left = intervals[0];
    for (int[] interval : intervals) {
      if (interval[0] <= left[1]) {
        left[0] = Math.min(interval[0], left[0]);
        left[1] = Math.max(interval[1], left[1]);
      } else {
        result.add(left);
        left = interval;
      }
    }
    result.add(left);
    return result.toArray(new int[result.size()][2]);

    /* Sort start & end method */
    /*
      int n = intervals.length;
      int[] starts = new int[n];
      int[] ends = new int[n];
      for (int i = 0; i < n; i++) {
        starts[i] = intervals[i][0];
        ends[i] = intervals[i][1];
      }
      Arrays.sort(starts);
      Arrays.sort(ends);
      // loop through
      List<int[]> res = new ArrayList<>();
      for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
        if (i == n - 1 || starts[i + 1] > ends[i]) {
          res.add(new int[]{starts[j], ends[i]});
          j = i + 1;
        }
      }
      return res.toArray(new int[res.size()][2]);
    }*/
  }
}
