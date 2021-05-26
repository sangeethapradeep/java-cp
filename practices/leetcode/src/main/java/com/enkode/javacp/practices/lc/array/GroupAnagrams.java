package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem 49.
 * <pre>
 *   Test Cases:
 *        eat,tea,tan,ate,nat,bat
 *        <empty></empty>
 *        a
 * </pre>
 */
public class GroupAnagrams {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] strings = br.readLine().split(",");
    sb.append(groupAnagrams(strings));
    System.out.println(sb);
  }

  private static List<List<String>> groupAnagrams(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strings) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      List<String> value = map.getOrDefault(String.valueOf(chars), new ArrayList<>());
      value.add(str);
      map.put(String.valueOf(chars), value);
    }
    return new ArrayList<>(map.values());
  }
}
