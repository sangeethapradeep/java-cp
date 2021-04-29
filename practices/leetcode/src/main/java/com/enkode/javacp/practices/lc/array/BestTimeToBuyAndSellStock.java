package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * <pre>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day. *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Test Cases:
 *      7,1,5,3,6,4
 *      7,6,4,3,1
 * </pre>
 */

public class BestTimeToBuyAndSellStock {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(",");
        int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
        sb.append(maxProfit(nums));
        System.out.println(sb);
    }

    private static int maxProfit(int[] prices) {
        int cheapestStock = prices[0];
        int maxProfit = 0;
        for (int index = 1; index < prices.length; index++) {
            if(prices[index] < cheapestStock) {
                cheapestStock = prices[index];
            } else if((prices[index] - cheapestStock > maxProfit)) {
                maxProfit = prices[index] - cheapestStock;
            }
        }
        return maxProfit;
    }
}
