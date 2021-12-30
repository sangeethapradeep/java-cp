package com.enkode.javacp.practices.lc.array;

/**
 * Problem 374
 *
 * <pre>
 *     Test Case:
 *          n = 10, pick = 6
 *          n = 1, pick = 1
 * </pre>
 */
class GuessGame {
  private static final int pick = 6;

  public static int guess(int num) {
    return Integer.compare(pick, num);
  }

  public static boolean isGuessCorrect(int num) {
    return pick == num;
  }
}

public class GuessNumberHigherOrLower extends GuessGame {
  public static void main(String[] args) {
    int n = 10;
    int answer = guessNumber(n);
    System.out.println("I picked " + answer);
    System.out.println("Is my guess correct? " + isGuessCorrect(answer));
  }

  public static int guessNumber(int n) {
    int l = 1;
    int h = n;
    int result = -1;
    int mid = 0;

    while (result != 0) {
      mid = (h - l) / 2 + l;
      result = guess(mid);
      if (result == 1) l = mid + 1;
      else if (result == -1) h = mid - 1;
    }
    return mid;
  }
}
