package com.enkode.javacp.challenges.codechef.july20;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ChefAndCardGame {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            long pointsOfA = 0;
            long pointsOfB = 0;

            int n = Integer.parseInt(br.readLine());

            while (n-- > 0) {
                String[] cards = br.readLine().split(" ");
                long powerOfA = powerOf(Integer.parseInt(cards[0]));
                long powerOfB = powerOf(Integer.parseInt(cards[1]));
                if (powerOfA > powerOfB) {
                    pointsOfA++;
                } else if (powerOfB > powerOfA) {
                    pointsOfB++;
                } else {
                    pointsOfA++;
                    pointsOfB++;
                }
            }

            if (pointsOfA > pointsOfB) {
                sb.append("0 " + pointsOfA);
            } else if (pointsOfB > pointsOfA) {
                sb.append("1 " + pointsOfB);
            } else {
                sb.append("2 " + pointsOfA);
            }
            sb.append("\n");

        }

        System.out.println(sb);



    }

    static long powerOf(int value) {
        long sum = 0L;
        while (value > 0) {
            sum = sum + value % 10;
            value = value / 10;
        }
        return sum;
    }
}
