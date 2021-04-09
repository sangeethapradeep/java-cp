package com.enkode.javacp.challenges.codechef.july20;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Name of the class has to be "Main" only if the class is public. */
class ChefAndStrings {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int noOfTests = Integer.parseInt(br.readLine());

        for (int round = 0; round < noOfTests; round++) {
            int length = Integer.parseInt(br.readLine());
            long totalSkippedStrings = 0;


            String[] codes = (br.readLine()).split(" ");
            for (int index = 1; index < length; index++) {
                totalSkippedStrings += (Math.abs(
                        Integer.parseInt(codes[index]) - Integer.parseInt(codes[index - 1])) - 1);
            }

            sb.append(totalSkippedStrings);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
