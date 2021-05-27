package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Problem: 560.
 * <pre>
 *   0,2,-4,-4,4    -2
 *   1,2,3           3
 *   1,1,1           2
 * </pre>
 */
public class SubArraySumEqualsK {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] string = br.readLine().split(",");
    int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
    int k = Integer.parseInt(br.readLine());
    sb.append(subarraySum(nums, k));
    System.out.println(sb);
  }

  private static int subarraySum(int[] nums, int k) {
    int count = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int num : nums) {
      sum += num;
      if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
}
