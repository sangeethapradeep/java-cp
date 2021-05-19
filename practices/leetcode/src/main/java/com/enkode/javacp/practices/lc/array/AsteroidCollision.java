package com.enkode.javacp.practices.lc.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Stream;

/**
 * Problem 735.
 * <pre>
 *   Test Cases:
 *        5,10,-5
 *        8,-8
 *        10,2,-5
 *        -2,-1,1,2
 * </pre>
 */
public class AsteroidCollision {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(",");
        int[] nums = Stream.of(string).mapToInt(Integer::parseInt).toArray();
        sb.append(Arrays.toString(asteroidCollision(nums)));
        System.out.println(sb);
    }

    private static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > 0 && (stack.peek() < Math.abs(asteroid))) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid);
            } else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                stack.pop();
            }
        }

        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[result.length - i++ - 1] = stack.pop();
        }
        return result;
    }
}
