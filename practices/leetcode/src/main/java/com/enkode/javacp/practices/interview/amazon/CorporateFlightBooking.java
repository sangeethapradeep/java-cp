package com.enkode.javacp.practices.interview.amazon;

import java.util.Arrays;

/**
 * Amazon
 * Problem 1109
 *
 * <pre>
 *     Test Cases:
 *          bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 *          bookings = [[1,2,10],[2,2,15]], n = 2
 *
 * </pre>
 */
public class CorporateFlightBooking {
  public static void main(String[] args) {
    int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
    int n = 5;
    System.out.println(Arrays.toString(corpFlightBookings(bookings, n)));
  }

  private static int[] corpFlightBookings(int[][] bookings, int n) {
    /*line sweep algorithm*/
    int[] seats = new int[n];

    for (int[] b : bookings) {
      seats[b[0] - 1] += b[2];
      if (b[1] < n) seats[b[1]] -= b[2];
    }

    for (int i = 1; i < n; i++) {
      seats[i] += seats[i - 1];
    }

    return seats;
  }
}
