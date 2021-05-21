package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem 118.
 * <pre>
 *     Test Cases:
 *          5
 *          1
 * </pre>
 */
public class PascalsTriangle {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numRows = Integer.parseInt(br.readLine());
        sb.append(generate(numRows));
        System.out.println(sb);
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> pascal = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    pascal.add(1);
                } else {
                    pascal.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(pascal);
        }
        return result;
    }
}
