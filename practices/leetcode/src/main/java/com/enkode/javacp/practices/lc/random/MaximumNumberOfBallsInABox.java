package com.enkode.javacp.practices.lc.random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * You are working in a ball factory where you have n balls numbered from lowLimit up to highLimit
 * inclusive (i.e., n == highLimit - lowLimit + 1), and an infinite number of boxes numbered from 1
 * to infinity. * Your job at this factory is to put each ball in the box with a number equal to the
 * sum of digits of the ball's number. For example, the ball number 321 will be put in the box
 * number 3 + 2 + 1 = 6 and the ball number 10 will be put in the box number 1 + 0 = 1. Given two
 * integers lowLimit and highLimit, return the number of balls in the box with the most balls.
 * <p>
 * Test Case:
 * <p> 1  10
 * <p> 5  15
 * <p> 19 28
 */

public class MaximumNumberOfBallsInABox {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lowLimit = Integer.parseInt(br.readLine());
        int highLimit = Integer.parseInt(br.readLine());
        countBalls(lowLimit, highLimit);
        System.out.println(sb);
    }

    private static void countBalls(int lowLimit, int highLimit) {
        int max = 0;
        Map<Integer, Integer> boxes = new HashMap<Integer, Integer>();
        for (int index = lowLimit; index <= highLimit; index++) {
            int sumOfDigits = sumOfDigits(index);
            if (boxes.containsKey(sumOfDigits)) {
                boxes.put(sumOfDigits, boxes.get(sumOfDigits) + 1);
            } else {
                boxes.put(sumOfDigits, 1);
            }
            if (max == 0) { max = 1; } else {
                max = max < boxes.get(sumOfDigits)
                        ? boxes.get(sumOfDigits)
                        : max;
            }
        }

        sb.append(max);
    }

    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }


}
