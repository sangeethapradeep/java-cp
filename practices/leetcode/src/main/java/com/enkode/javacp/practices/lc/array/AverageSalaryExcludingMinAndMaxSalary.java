package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Problem 1491.
 * <pre>
 *   Test Cases:
 *        4000,3000,1000,2000
 *        1000,2000,3000
 *        6000,5000,4000,3000,2000,1000
 *        8000,9000,2000,3000,6000,1000
 * </pre>
 */
public class AverageSalaryExcludingMinAndMaxSalary {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(",");
        int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
        sb.append(average(nums));
        System.out.println(sb);
    }

    private static double average(int[] salary) {
        Arrays.sort(salary);
        long sum = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
        }
        return sum / (double) (salary.length - 2);
    }
}
