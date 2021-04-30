package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * <pre>
 * Given an integer array nums,
 *      return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i]. *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * Test Cases:
 *      1,2,3,4
 *     -1,1,0,-3,3
 *
 * </pre>
 */

public class ProductOfArrayExceptSelf {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(",");
        int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
        sb.append(Arrays.toString(productExceptSelf(nums)));
        System.out.println(sb);
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] productExceptSelf = new int[nums.length];
        int product = 1;
        int noOfZeros = 0;
        int zeroIndex = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 0) {
                if (++noOfZeros > 1) {
                    break;
                } else {
                    zeroIndex = index;
                }
            } else {
                product *= nums[index];
            }
        }

        if(noOfZeros > 1) return productExceptSelf;
        else if(noOfZeros == 1){
            productExceptSelf[zeroIndex] = product;
            return productExceptSelf;
        } else {
            for (int index = 0; index < nums.length; index++) {
                productExceptSelf[index] = product / nums[index];
            }
            return productExceptSelf;
        }

/*   //One with beautiful logic

        Arrays.fill(productExceptSelf, 1);
        int left = 1;
        int right = 1;
        for (int index = 0; index < nums.length; index++) {

            productExceptSelf[index] *= left;
            productExceptSelf[nums.length - index - 1] *= right;

            left *= nums[index];
            right *= nums[nums.length - index - 1];
        }
        return productExceptSelf;
*/
    }
}
