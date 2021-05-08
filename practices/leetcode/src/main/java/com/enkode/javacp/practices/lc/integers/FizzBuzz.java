package com.enkode.javacp.practices.lc.integers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Problem 412
 * Given an integer n, return a string array answer (1-indexed) where: *
 *      answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 *      answer[i] == "Fizz" if i is divisible by 3.
 *      answer[i] == "Buzz" if i is divisible by 5.
 *      answer[i] == i if non of the above conditions are true.
 *
 * Test Cases:
 *      3
 *      5
 *      15
 * </pre>
 */

public class FizzBuzz {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        sb.append(fizzBuzz(num));
        System.out.println(sb);
    }

    private static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
