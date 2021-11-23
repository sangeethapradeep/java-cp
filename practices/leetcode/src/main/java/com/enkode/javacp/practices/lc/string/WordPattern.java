package com.enkode.javacp.practices.lc.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Problem 290
 *
 * <pre>
 *     Test Cases:
 *          abba        dog cat cat dog
 *          abba        dog cat cat fish
 * </pre>
 */
public class WordPattern {
  public static void main(String[] args) {
    String s = "dog cat cat dog";
    String pattern = "abba";
    System.out.println(wordPattern(pattern, s));
  }

  private static boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    if (words.length != pattern.length()) return false;
    Map<String, Integer> map = new HashMap<>();
    for(int i = 0; i<words.length; i++ ) {
      if(!Objects.equals(map.put(words[i], i), map.put(String.valueOf(pattern.charAt(i)), i))) return false;
    }
    return true;
  }
}
