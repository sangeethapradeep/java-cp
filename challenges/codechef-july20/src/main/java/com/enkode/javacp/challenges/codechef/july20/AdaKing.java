package com.enkode.javacp.challenges.codechef.july20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class AdaKing {
   private static StringBuilder sb = new StringBuilder();

   public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int t = Integer.parseInt(br.readLine());

       while (t-- > 0) {
           int k = Integer.parseInt(br.readLine());
           String[][] board;
           board = configureBoard(k);
           print(board);
       }
       System.out.println(sb);
   }

   private static void print(String[][] board) {
       for (int i = 0; i < 8; i++) {
           for (int j = 0; j < 8; j++) {
               sb.append(board[i][j]);
           }
           sb.append("\n");
       }
       sb.append("\n");
   }

   private static String[][] configureBoard(int count) {
       String[][] board = new String[8][8];
       Arrays.stream(board).forEach(row -> Arrays.fill(row, "X"));
       int x = 0;
       int y = 0;
       board[x][y] = "O";
       while (--count > 0) {
           x++;
           if(x == 8) {
               x=0;
               y++;
           }
           board[x][y] = ".";
       }
       return board;
   }

}
