package com.enkode.javacp.practices.lc.array;

/**
 * Problem 744
 *
 * <pre>
 *     Test Cases:
 *          letters = ["c","f","j"], target = "a"
 *          letters = ["c","f","j"], target = "c"
 *          letters = ["c","f","j"], target = "d"
 * </pre>
 */
public class FindSmallestLetterGreaterThanTarget {
  public static void main(String[] args) {
    char[] letters = {'a', 'b'};
    char target = 'z';
    System.out.println(
        "Smallest Letter Greater than Target: " + nextGreatestLetter(letters, target));
  }

  private static char nextGreatestLetter(char[] letters, char target) {
    int n = letters.length;
    int left = 0, right = n - 1;
    while (left <= right) {
      int mid = (right - left) / 2 + left;
      if (letters[mid] - 'a' <= target - 'a') left = mid + 1;
      else right = mid - 1;
    }

    return letters[left % n];
  }
}
