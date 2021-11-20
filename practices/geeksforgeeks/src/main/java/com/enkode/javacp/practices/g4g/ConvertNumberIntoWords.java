package com.enkode.javacp.practices.g4g;

/**
 * Write code to convert a given number into words. For example, if “1234” is given as input, output
 * should be “one thousand two hundred thirty four”.
 */
public class ConvertNumberIntoWords {

  public static final String[] LESS_THAN_20 = {
    "",
    "One",
    "Two",
    "Three",
    "Four",
    "Five",
    "Six",
    "Seven",
    "Eight",
    "Nine",
    "Ten",
    "Eleven",
    "Twelve",
    "Thirteen",
    "Fourteen",
    "Fifteen",
    "Sixteen",
    "Seventeen",
    "Eighteen",
    "Nineteen"
  };

  public static final String[] TENS = {
    "", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
  };
  public static final String[] THOUSANDS = {"", " Thousand ", " Million ", " Billion "};

  public static void main(String[] args) {
    int num = 10;
    System.out.println(convertToWords(num));
  }

  private static String convertToWords(int num) {
    StringBuilder sb = new StringBuilder(" ");

    if (num == 0) return "Zero";

    int rate = 0;
    while (num > 0) {
      int group = num % 1000;
      String t;
      if (group > 99) t = threeDigit(group);
      else t = twoDigit(num);
      if (!t.equals("")) t = t + THOUSANDS[rate++];
      sb.insert(0, t);
      num = num / 1000;
    }

    return sb.toString();
  }

  private static String threeDigit(int num) {
    int twoD = num % 100;
    int thirdDigit = num / 100;

    if (twoD > 0) return LESS_THAN_20[thirdDigit] + " Hundred " + twoDigit(twoD);
    return LESS_THAN_20[thirdDigit] + " Hundred";
  }

  private static String twoDigit(int num) {
    int unit = num % 10;
    int ten = num / 10;

    if (num < 20) return LESS_THAN_20[num];
    if (unit == 0) return TENS[ten];
    return TENS[ten] + " " + LESS_THAN_20[unit];
  }
}
