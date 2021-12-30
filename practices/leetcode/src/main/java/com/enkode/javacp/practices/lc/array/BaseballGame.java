package com.enkode.javacp.practices.lc.array;

import java.util.Arrays;

/**
 * Problem 682
 *
 * <pre>
 *     Test Cases:
 *          ["5","2","C","D","+"]
 *          ["5","-2","4","C","D","9","+","+"]
 *          ["1"]
 * </pre>
 */
public class BaseballGame {
  public static void main(String[] args) {
    String[] ops = {"5", "2", "C", "D", "+"};
    System.out.println("Score: " + calPoints(ops));
  }

  private static int calPoints(String[] ops) {
    int[] scores = new int[1000];
    int idx = 0;

    for (String op : ops) {
      switch (op) {
        case "+":
          scores[idx] = scores[idx - 1] + scores[idx - 2];
          break;
        case "D":
          scores[idx] = scores[idx - 1] * 2;
          break;
        case "C":
          idx--;
          break;
        default:
          scores[idx] = Integer.parseInt(op);
      }
      if (!op.equals("C")) idx++;
    }

    return Arrays.stream(scores, 0, idx).sum();
  }
}
