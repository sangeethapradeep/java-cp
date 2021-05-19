package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Problem 122.
 * <pre>
 *     Test Cases:
 *        7,1,5,3,6,4
 *        1,2,3,4,5
 *        7,6,4,3,1
 * </pre>
 */
public class BestTimeToBuyAndSellStockII {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(",");
        int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
        sb.append(maxProfit(nums));
        System.out.println(sb);
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int index = 1; index < prices.length; index++) {
            if (prices[index] > prices[index - 1]) {
                maxProfit += prices[index] - prices[index - 1];
            }
        }
        return maxProfit;
    }
}
