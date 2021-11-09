package com.enkode.javacp.practices.lc.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 22
 *
 * <pre>
 *     Test Cases:
 *          3
 *          1
 * </pre>
 */
public class GenerateParathensis {

  public static void main(String[] args) {
    int n = 3;
    System.out.println(generateParenthesis(n));
  }

  private static List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    generateByDfs(result, "", n, n);
    return result;
  }

  private static void generateByDfs(List<String> result, String subList, int open, int close) {
    if (open > close) return;
    if (open > 0) generateByDfs(result, subList + "(", open - 1, close);
    if (close > 0) generateByDfs(result, subList + ")", open, close - 1);
    if (open == 0 && close == 0) {
      result.add(subList);
    }
  }
}
