package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Problem 1441.
 */
public class BuildAnArrayWithStackOperations {
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] string = br.readLine().split(",");
    int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
    int n = Integer.parseInt(br.readLine());
    sb.append(buildArray(nums, n));
    System.out.println(sb);
  }

  private static List<String> buildArray(int[] target, int n) {
    List<String> output = new ArrayList<>();
    int i = 1;
    int j = 0;
    while(j < target.length) {
      output.add("Push");
      if(target[j] != i++) output.add("Pop");
      else j++;
    }
    return output;
  }
}
