package com.enkode.javacp.practices.lc.string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Problem 767
 *
 * <pre>
 *     Test Cases:
 *          aab
 *          aaab
 * </pre>
 */
public class ReorganizeString {
  public static void main(String[] args) {
    String s = "deep";
    System.out.println("Reorganizing: " + reorganizeString(s));
  }

  private static String reorganizeString(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : s.toCharArray()) {
      map.compute(ch, (key, value) -> value == null ? 1 : value + 1);
    }

    PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
    pq.addAll(map.keySet());

    StringBuilder str = new StringBuilder();
    while (pq.size() > 1) {
      char current = pq.remove();
      char next = pq.remove();
      str.append(current).append(next);
      map.put(current, map.get(current) - 1);
      map.put(next, map.get(next) - 1);
      if (map.get(current) > 0) pq.add(current);
      if (map.get(next) > 0) pq.add(next);
    }

    if (!pq.isEmpty()) {
      char last = pq.remove();
      if (map.get(last) > 1) return "";
      str.append(last);
    }

    return str.toString();
  }
}
