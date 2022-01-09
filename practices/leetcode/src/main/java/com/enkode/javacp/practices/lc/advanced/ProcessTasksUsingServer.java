package com.enkode.javacp.practices.lc.advanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem 1882
 *
 * <pre>
 *     Test Cases:
 *          servers = [3,3,2], tasks = [1,2,3,2,1,2]
 *          servers = [5,1,4,3,2], tasks = [2,1,2,4,5,2,1]
 * </pre>
 */
public class ProcessTasksUsingServer {
  public static void main(String[] args) {
    int[] servers = {5, 1, 4, 3, 2};
    int[] tasks = {2, 1, 2, 4, 5, 2, 1};

    System.out.println("Servers assigned = " + Arrays.toString(assignTasks(servers, tasks)));
  }

  private static int[] assignTasks(int[] servers, int[] tasks) {
    PriorityQueue<Integer> serverq =
        new PriorityQueue<>((i, j) -> (servers[i] == servers[j]) ? i - j : servers[i] - servers[j]);
    for (int i = 0; i < servers.length; i++) {
      serverq.add(i);
    }

    PriorityQueue<int[]> activetasks = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

    int time = 0;
    int[] result = new int[tasks.length];

    for (int i = 0; i < tasks.length; i++) {
      time = Math.max(time, i);

      while (!activetasks.isEmpty() && activetasks.peek()[1] <= i) {
        serverq.offer(activetasks.poll()[0]);
      }

      if (serverq.isEmpty()) {
        int[] toptask = activetasks.peek();
        while (!activetasks.isEmpty() && activetasks.peek()[1] == toptask[1]) {
          int[] task = activetasks.poll();
          serverq.offer(task[0]);
        }
        time = toptask[1];
      }
      int server = serverq.poll();
      result[i] = server;
      activetasks.offer(new int[] {server, time + tasks[i]});
    }

    return result;
  }
}
