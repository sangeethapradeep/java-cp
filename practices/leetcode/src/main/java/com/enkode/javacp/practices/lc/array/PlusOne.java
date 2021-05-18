package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Problem 66.
 * <pre>
 *   Given a non-empty array of decimal digits representing a non-negative integer,
 *   increment one to the integer. *
 *   The digits are stored such that the most significant digit is at the head of the list,
 *   and each element in the array contains a single digit.
 *   You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 *   Test Cases:
 *      1,2,3
 *      4,3,2,1
 *      0
 * </pre>
 */
public class PlusOne {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(",");
        int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
        sb.append(Arrays.toString(plusOne(nums)));
        System.out.println(sb);
    }

    private static int[] plusOne(int[] digits) {
        return increment(digits, digits.length - 1);
    }

    private static int[] increment(int[] num, int index) {
        if (index == 0 && num[index] == 9) {
            num[index] = 0;
            int[] result = new int[num.length + 1];
            result[0] = 1;
            System.arraycopy(num, 0, result, 1, num.length);
            return result;
        }
        if (num[index] == 9) {
            num[index] = 0;
            return increment(num, index - 1);
        }
        num[index]++;
        return num;
    }

}
