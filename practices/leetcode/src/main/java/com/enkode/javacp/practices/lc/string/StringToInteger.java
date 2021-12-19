package com.enkode.javacp.practices.lc.string;

import java.math.BigInteger;

/**
 * Problem 8
 *
 * <pre>
 *     Test Cases:
 *          "42"
 *          "       -42"
 *          "4193 with words"
 *          "-2147483647"
 *          "2147483648"
 *          "200000000000000000000000000000000"
 * </pre>
 */
public class StringToInteger {
  public static void main(String[] args) {
    String s = "200000000000000000000000000000000";
    System.out.println(myAtoi(s));
  }

  private static int myAtoi(String s) {
    int i = 0;
    int n = s.length();
    boolean positive = true;

    while (i < n && s.charAt(i) == ' ') i++;
    if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
      if (s.charAt(i) == '-') {
        positive = false;
      }
      i++;
    }
    int j = i;
    while (i < n && Character.isDigit(s.charAt(i))) {
      i++;
    }
    BigInteger num = i == j ? BigInteger.ZERO : new BigInteger(s.substring(j, i));

    BigInteger maxValue = new BigInteger("" + Integer.MAX_VALUE);
    BigInteger minValue = new BigInteger("" + Integer.MIN_VALUE);

    if (positive) {
      num = num.compareTo(maxValue) > 0 ? maxValue : num;
    } else {
      BigInteger minusNum = (BigInteger.ZERO).subtract(num);
      num = minusNum.compareTo(minValue) < 0 ? minValue : minusNum;
    }

    return num.intValue();
  }
}
