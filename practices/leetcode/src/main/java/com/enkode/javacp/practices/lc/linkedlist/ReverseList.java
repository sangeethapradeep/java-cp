package com.enkode.javacp.practices.lc.linkedlist;

/**
 * Problem 206
 *
 * <pre>
 *     Test Cases:
 *        1,2,3,4,5
 *        1,2
 *        []
 * </pre>
 */
public class ReverseList {
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    ListNode head =
        new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1, null)))));
    printList("Reversed List", reverseList(head));
    System.out.println(sb);
  }

  private static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode start = reverseList(head.next);
    head.next.next = head;
    head.next = null;

    return start;
  }

  private static void printList(String heading, ListNode head) {
    sb.append(heading).append("\n");
    if (head != null) {
      sb.append(head.val);
      head = head.next;
    }
    while (head != null) {
      sb.append("->").append(head.val);
      head = head.next;
    }
    sb.append("\n");
  }

  private static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
