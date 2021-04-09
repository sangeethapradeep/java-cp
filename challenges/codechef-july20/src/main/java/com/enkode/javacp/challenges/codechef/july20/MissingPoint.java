package com.enkode.javacp.challenges.codechef.july20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class MissingPoint {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int vertices = 4 * n;
            HashMap<Integer, Integer> xCoordinates = new HashMap<>();
            HashMap<Integer, Integer> yCoordinates = new HashMap<>();


            while ((vertices-- - 1) > 0) {
                String[] coordinates = br.readLine().split(" ");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);

                if (xCoordinates.containsKey(x)) {
                    xCoordinates.put(x, xCoordinates.get(x) + 1);
                } else {
                    xCoordinates.put(x, 1);
                }

                if (yCoordinates.containsKey(y)) {
                    yCoordinates.put(y, yCoordinates.get(y) + 1);
                } else {
                    yCoordinates.put(y, 1);
                }

            }
            int x = 0, y = 0;
            for (Map.Entry<Integer, Integer> entry : xCoordinates.entrySet()) {
                if (entry.getValue() % 2 == 1) { x = entry.getKey(); }
            }

            for (Map.Entry<Integer, Integer> entry : yCoordinates.entrySet()) {
                if (entry.getValue() % 2 == 1) { y = entry.getKey(); }
            }

            sb.append(x).append(" ").append(y).append("\n");
        }

        System.out.println(sb);
    }
}
