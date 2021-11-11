package com.enkode.javacp.practices.lc.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 *
 * <pre>
 * Problem 3:
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Test Cases:
 *      abcabcbb
 *      bbbbb
 *      pwwkew
 *      <empty></empty>
 * </pre>
 */
public class LongestSubstringWithoutRepeatingCharacters {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String string = br.readLine();
    sb.append(lengthOfLongestSubstring(string));
    System.out.println(sb);
  }

  //    private static int lengthOfLongestSubstring(String s) {
  //        int max = 0;
  //        Map<Character, Integer> map = new HashMap<>();
  //        int start = 0;
  //        int end = 0;
  //        for (int i = 0; i < s.length(); i++) {
  //            if (map.containsKey(s.charAt(i)) && start < map.get(s.charAt(i))) {
  //                start = map.get(s.charAt(i));
  //            } else {
  //                end = i;
  //            }
  //            map.put(s.charAt(i), i + 1);
  //            max = Math.max(end - start + 1, max);
  //        }
  //        return max;
  //    }
  private static int lengthOfLongestSubstring(String s) {
    StringBuilder sb = new StringBuilder();
    int longestSubString = 0;
    for (char ch : s.toCharArray()) {
      int index = sb.indexOf(String.valueOf(ch));
      if (index != -1) {
        longestSubString = Math.max(sb.length(), longestSubString);
        sb.delete(0, index + 1);
      }
      sb.append(ch);
    }
    if (sb.length() != 0)
      longestSubString = Math.max(sb.length(), longestSubString);
    return longestSubString;
  }
}
