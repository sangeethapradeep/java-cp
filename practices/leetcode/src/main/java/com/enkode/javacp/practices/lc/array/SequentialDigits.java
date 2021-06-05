package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 1291.
 * <pre>
 *   Test Cases:
 *        100     300
 *        1000    13000
 * </pre>
 */
public class SequentialDigits {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int low = Integer.parseInt(br.readLine());
    int high = Integer.parseInt(br.readLine());
    sb.append(sequentialDigits(low, high));
    System.out.println(sb);
  }

  private static List<Integer> sequentialDigits(int low, int high) {
    Integer[] combinations = {
      12, 23, 34, 45, 56, 67, 78, 89,
      123, 234, 345, 456, 567, 678, 789,
      1234, 2345, 3456, 4567, 5678, 6789,
      12345, 23456, 34567, 45678, 56789,
      123456, 234567, 345678, 456789,
      1234567, 2345678, 3456789,
      12345678, 23456789,
      123456789
    };
    int iLow = Arrays.binarySearch(combinations, low);
    int iHigh = Arrays.binarySearch(combinations, high);
    iLow = iLow < 0 ? -iLow - 1 : iLow;
    iHigh = iHigh < 0 ? -iHigh - 1 : iHigh + 1;
    return Arrays.asList(combinations).subList(iLow, iHigh);
  }
}

