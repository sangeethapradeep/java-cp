package com.enkode.javacp.practices.lc.random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a string s of lowercase letters, these letters form consecutive groups of the same character.
 * For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy". A
 * group is identified by an interval [start, end], where start and end denote the start and end
 * indices (inclusive) of the group. In the above example, "xxxx" has the interval [3,6]. A group is
 * considered large if it has 3 or more characters. Return the intervals of every large group sorted
 * in increasing order by start index.
 * <p>
 * Test Cases:
 * <p> abbxxxxzzy
 * <p> abcdddeeeeaabbbcd
 * <p> aba
 */

public class PositionsOfLargeGroup {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        largeGroupPositions(string);
        System.out.println(sb);
    }

    private static void largeGroupPositions(String s) {
        List<List<Integer>> largeGroupPositions = new ArrayList<List<Integer>>();
        int endIndexOfGroup;
        for (int index = 0; index < s.length(); index = endIndexOfGroup) {
            endIndexOfGroup = findGroupEnd(s, index);
            if ((endIndexOfGroup - index) >= 3) {
                List<Integer> positions = new ArrayList<Integer>(
                        Arrays.asList(index, endIndexOfGroup - 1));
                largeGroupPositions.add(positions);
            }
        }
        sb.append(largeGroupPositions);
    }

    private static int findGroupEnd(String s, int startIndex) {
        int endIndex = startIndex;
        for (; endIndex < s.length() && s.charAt(endIndex) == s.charAt(startIndex); endIndex++);
        return endIndex;
    }
}
