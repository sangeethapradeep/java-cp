package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Problem 1431.
 * <pre>
 *   Test Cases:
 *      2,3,5,1,3       3
 *      4,2,1,1,2       1
 *      12,1,12         10
 * </pre>
 */
public class KidsWithGreatestNumberOfCandies {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] string = br.readLine().split(",");
    int[] candies = Stream.of(string).mapToInt(Integer::parseInt).toArray();
    int extraCandies = Integer.parseInt(br.readLine());
    sb.append(kidsWithCandies(candies, extraCandies));
    System.out.println(sb);
  }

  private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int max = candies[0];
    List<Boolean> result = new ArrayList<>();
    for (int i : candies) {
      max = Math.max(max, i);
    }
    for (int i : candies) {
      result.add(i + extraCandies >= max);
    }
    return result;
  }
}
