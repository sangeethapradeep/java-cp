package com.enkode.javacp.practices.interview.top200;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 763
 *
 * <pre>
 *     Test Case:
 *          s = "ababcbacadefegdehijhklij"
 *          s = "eccbbbbdec"
 * </pre>
 */
public class PartitionLabels {
  public static void main(String[] args) {
    String s = "priya";
    System.out.println("Partitioned Labels: " + partitionLabels(s));
  }

  private static List<Integer> partitionLabels(String s) {
    List<Integer> result = new ArrayList<>();
    int[] last = new int[26];
    for (int i = 0; i < s.length(); i++) {
      last[s.charAt(i) - 'a'] = i;
    }
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      end = Math.max(end, last[s.charAt(i) - 'a']);
      if (i == end) {
        result.add(end - start + 1);
        start = i + 1;
      }
    }
    return result;
  }
}
