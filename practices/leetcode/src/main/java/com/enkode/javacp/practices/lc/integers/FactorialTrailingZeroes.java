package com.enkode.javacp.practices.lc.integers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <pre>
 * Leetcode 172.
 * Given an integer n, return the number of trailing zeroes in n!. *
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 *
 * Test Cases:
 *      3
 *      5
 *      0
 * </pre>
 */
public class FactorialTrailingZeroes {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        sb.append(trailingZeroes(num));
        System.out.println(sb);
    }

    private static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
