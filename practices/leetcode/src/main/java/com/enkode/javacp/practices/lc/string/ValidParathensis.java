package com.enkode.javacp.practices.lc.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Problem 20:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * An input string is valid if:
 *      1. Open brackets must be closed by the same type of brackets.
 *      2. Open brackets must be closed in the correct order.
 *
 * Test Cases:
 *      ()
 *      ()[]{}
 *      (]
 *      ([)]
 *      {[]}
 * </pre>
 */
public class ValidParathensis {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        sb.append(isValid(string));
        System.out.println(sb);
    }

    private static boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();
        brackets.put('}', '{');
        brackets.put(']', '[');
        brackets.put(')', '(');
        for (int i = 0; i < s.length(); i++) {
            if (!brackets.containsKey(s.charAt(i))) {
                stack.addLast(s.charAt(i));
            } else if (stack.isEmpty() || !stack.removeLast().equals(brackets.get(s.charAt(i)))) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
