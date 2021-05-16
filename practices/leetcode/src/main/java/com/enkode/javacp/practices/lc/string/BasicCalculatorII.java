package com.enkode.javacp.practices.lc.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Problem 227.
 * <pre>
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero.
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical
 * expressions, such as eval().
 *
 * Test Cases:
 *      3+2*2
 *       3/2
 *       3+5 / 2
 * </pre>
 */
public class BasicCalculatorII {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        sb.append(calculate(string));
        System.out.println(sb);
    }

    private static int calculate(String s) {
        int result = 0;
        int cur = 0;
        char op = '+';
        int num = 0;
        s = s.concat(String.valueOf(op));

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                continue;
            }

            if (c == '+' || c == '-' || c == '/' || c == '*') {
                switch (op) {
                    case '+':
                        cur += num;
                        break;
                    case '-':
                        cur -= num;
                        break;
                    case '*':
                        cur *= num;
                        break;
                    case '/':
                        cur /= num;
                        break;
                    default:
                        break;

                }
                if (c == '+' || c == '-') {
                    result += cur;
                    cur = 0;
                }
                num = 0;
                op = c;
            }
        }
        return result;
    }
}
