package com.enkode.javacp.practices.lc.integers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <pre>
 * Problem 50.
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Test Cases:
 *      2.0000   10
 *      2.10000  3
 *      2.000    -2
 *      2.00000  -2147483648
 * </pre>
 */
public class Power {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double x = Double.parseDouble(br.readLine());
        int n = Integer.parseInt(br.readLine());
        sb.append(myPow(x, n));
        System.out.println(sb);
    }

    private static double myPow(double x, int n) {
        if(x == 1) return 1.00;
        if(x == 0) return 0.00;
        if(x == -1) return (long)n % 2 == 0 ? 1.00 : -1.00;
        if(n < 0) return pow(1/x, (long)n);
        return pow(x, (long)n);
    }

    private static double pow(double x, long n) {
        if(n == 1) return x;
        if(n == 0) return 1.00;
        double res = pow(x, n/2);
        return n%2 == 0? res*res : res*res*x;
    }

}
