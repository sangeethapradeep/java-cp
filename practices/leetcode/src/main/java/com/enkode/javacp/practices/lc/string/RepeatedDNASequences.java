package com.enkode.javacp.practices.lc.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem 187.
 * <pre>
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 * For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings)
 * that occur more than once in a DNA molecule. You may return the answer in any order.
 *
 * Test Cases:
 *      AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT
 *      AAAAAAAAAAAAA
 * </pre>
 */
public class RepeatedDNASequences {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        sb.append(findRepeatedDnaSequences(string));
        System.out.println(sb);
    }

    private static List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();
        if (s.length() <= 10) {
            return Collections.emptyList();
        }
        for (int i = 0; i + 10 <= s.length(); i++) {
            if (!set.add(s.substring(i, i + 10))) {
                result.add(s.substring(i, i + 10));
            }
        }
        return new ArrayList<>(result);
    }
}
