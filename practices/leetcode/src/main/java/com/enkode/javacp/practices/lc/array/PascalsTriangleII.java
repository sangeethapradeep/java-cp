package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Problem 119.
 * <pre>
 *     Test Cases:
 *          3
 *          0
 * </pre>
 */
public class PascalsTriangleII {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numRows = Integer.parseInt(br.readLine());
        sb.append(generate(numRows));
        System.out.println(sb);
    }

    private static List<Integer> generate(int numRows) {
        return pascalRow(numRows + 1);
    }

    private static List<Integer> pascalRow(int row) {
        if (row == 1) {
            return Collections.singletonList(1);
        }
        if (row == 2) {
            return Arrays.asList(1, 1);
        }
        List<Integer> prev = pascalRow(row - 1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            if (i == 0 || i == row - 1) {
                list.add(1);
            } else {
                list.add(prev.get(i - 1) + prev.get(i));
            }
        }
        return list;
    }

}
