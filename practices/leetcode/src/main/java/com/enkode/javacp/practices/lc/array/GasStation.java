package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Problem 134.
 * <pre>
 *   Test Cases:
 *      1,2,3,4,5             3,4,5,1,2
 *      2,3,4                 3,4,3
 *      4,5,2,6,5,3           3,2,7,3,2,9
 * </pre>
 */
public class GasStation {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] string = br.readLine().split(",");
    int[] gas = Stream.of(string).mapToInt(Integer::parseInt).toArray();
    string = br.readLine().split(",");
    int[] cost = Stream.of(string).mapToInt(Integer::parseInt).toArray();
    sb.append(canCompleteCircuit(gas, cost));
    System.out.println(sb);
  }

  private static int canCompleteCircuit(int[] gas, int[] cost) {
    int pos = -1;
    int tank = 0;
    int total = 0;
    for (int i = 0; i < gas.length; i++) {
      int diff = gas[i] - cost[i];
      tank += diff;
      total += diff;
      if (tank < 0) {
        tank = 0;
        pos = i;
      }
    }

    return total >= 0 ? pos + 1 : -1;
  }
}
