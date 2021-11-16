package jpmorgan;

import java.util.Arrays;

/**
 * JP Morgan Problem 2
 *
 * <p>Given a string S of length N which is the English representation of any number of digits in
 * the range [0 – 9] in jumbled format. The task is to find the digits from this representation.
 *
 * <p>Note: Print digits in sorted order
 *
 * <pre>
 *     Test Cases:
 *          owoftnuoer
 *          zesxrionezoreo
 *          reuonnoinfe
 *          ennfnfoeestnhvxfenoisefrfrhreeotwurnoftioiuieuvssnngiorieoennunotehnifeinfewnniseenoegivxoueeeieneiitvgovv
 *
 * </pre>
 */
public class DigitsFromJumbledAlphabeticRepresentation {
  public static void main(String[] args) {
    String input = "ennfnfoeestnhvxfenoisefrfrhreeotwurnoftioiuieuvssnngiorieoennunotehnifeinfewnniseenoegivxoueeeieneiitvgovv";
    System.out.println(findTheDigits(input));
  }

  private static String findTheDigits(String input) {
      int[] count = new int[10];
      char[] determiningChars = {'z', 'o', 'w', 'h', 'u', 'f', 'x', 's', 'g', 'i'};
      Arrays.fill(count, 0);

      for(int i=0; i< input.length(); i++) {
          char c = input.charAt(i);
          for(int j=0; j<10; j++) {
              if(determiningChars[j] == c) {
                  count[j]++;
                  break;
              }
          }
      }

      count[1] = count[1] - (count[0] + count[2] + count[4]);
      count[3] = count[3] - count[8];
      count[5] = count[5] - count[4];
      count[7] = count[7] - count[6];
      count[9] = count[9] - (count[5] + count[6] + count[8]);

      StringBuilder ans = new StringBuilder();

      for(int i = 0; i < 10; i++) {
          ans.append(String.valueOf(i).repeat(Math.max(0, count[i])));
      }
      return ans.toString();
  }
}
