package com.enkode.javacp.practices.lc.integers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <pre>
 * Problem 9
 * Given an integer x, return true if x is palindrome integer. *
 * An integer is a palindrome when it reads the same backward as forward.
 * For example, 121 is palindrome while 123 is not.
 *
 * Test Cases:
 *      121
 *      -121
 *      10
 *      -101
 * </pre>
 */
public class PalindromeNumber {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        sb.append(isPalindrome(num));
        System.out.println(sb);
    }

    private static boolean isPalindrome(int x) {
        if ((x % 10 == 0 && x != 0) || x < 0) {
            return false;
        }
        int reverse = 0;
        while (reverse < x) {
            reverse = reverse * 10 + (x % 10);
            x = x / 10;
        }
        return reverse == x || reverse / 10 == x;
    }

}
