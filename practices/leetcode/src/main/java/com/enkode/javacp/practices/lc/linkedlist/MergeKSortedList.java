package com.enkode.javacp.practices.lc.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem 23
 *
 * <pre>
 *     Test Cases:
 *          [[1,4,5],[1,3,4],[2,6]]
 *          []
 *          [[]]
 * </pre>
 */
public class MergeKSortedList {

  private static final StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    ListNode a = new ListNode(1, new ListNode(4, new ListNode(5, null)));
    ListNode b = new ListNode(1, new ListNode(3, new ListNode(4, null)));
    ListNode c = new ListNode(2, new ListNode(6, null));
    ListNode[] lists = {a, b, c};
    printList("Output: ", mergeKLists(lists));
    System.out.println(sb);
  }

  private static ListNode mergeKLists(ListNode[] lists) {
    ListNode result = new ListNode(-1);
    ListNode head = result;

    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

    for (ListNode list : lists) {
      if (list != null) minHeap.add(list);
    }

    while (!minHeap.isEmpty()) {
      head.next = minHeap.poll();
      head = head.next;

      if (head.next != null) minHeap.add(head.next);
    }

    return result.next;
  }

  private static void printList(String heading, ListNode head) {
    sb.append(heading).append("\n");
    if (head != null) {
      sb.append(head.val);
      head = head.next;
    }
    while (head != null) {
      sb.append(",").append(head.val);
      head = head.next;
    }
    sb.append("\n");
  }

  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
