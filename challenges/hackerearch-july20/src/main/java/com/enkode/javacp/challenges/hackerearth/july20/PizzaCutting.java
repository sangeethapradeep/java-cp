package com.enkode.javacp.challenges.hackerearth.july20;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PizzaCutting {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            long n = Integer.parseInt(br.readLine());

            long slices = (long) (0.5 * ((n * n) + n + 2));

            sb.append(slices).append("\n");

        }

        System.out.println(sb);
    }
}
