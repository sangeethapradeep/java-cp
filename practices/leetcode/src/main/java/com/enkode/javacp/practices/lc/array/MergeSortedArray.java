package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Problem 88.
 * <pre>
 *     Test Cases:
 *          1,2,3,0,0,0         3       2,5,6       3
 *          1                   0       []           0
 * </pre>
 */
public class MergeSortedArray {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string1 = br.readLine().split(",");
        int[] nums1 = Stream.of(string1).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        String[] string2 = br.readLine().split(",");
        int[] nums2 = Stream.of(string2).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(br.readLine());
        merge(nums1, m, nums2, n);
        sb.append(Arrays.toString(nums1));
        System.out.println(sb);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m -1;
        int j = n -1;
        while(i>= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) nums1[k --] = nums1[i--];
            else nums1[k --] = nums2[j --];
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
