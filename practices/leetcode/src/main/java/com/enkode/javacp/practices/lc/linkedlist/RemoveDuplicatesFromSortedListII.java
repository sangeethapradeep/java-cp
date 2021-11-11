package com.enkode.javacp.practices.lc.linkedlist;

/**
 * Problem 82
 *
 * <pre>
 *     Test Cases:
 *          1,2,3,3,4,4,5
 *          1,1,1,2,3
 * </pre>
 */
public class RemoveDuplicatesFromSortedListII {

  public static void main(String[] args) {
    ListNode head =
        new ListNode(
            1,
            new ListNode(
                2,
                new ListNode(
                    3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, null)))))));
    head = deleteDuplicates(head);
    printList(head);
  }

  private static ListNode deleteDuplicates(ListNode head) {
    ListNode result = new ListNode();
    ListNode runner = result;

    while (head != null) {
      if (head.next == null || head.val != head.next.val) {
        runner.next = head;
        runner = runner.next;
      } else {
        while (head.next != null && head.val == head.next.val) head = head.next;
      }
      head = head.next;
    }
    runner.next = null;
    return result.next;
  }

  private static void printList(ListNode head) {
    while (head != null) {
      if (head.next != null) {
        System.out.print(head.val + "->");
      } else {
        System.out.print(head.val + "\n");
      }
      head = head.next;
    }
  }

  private static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
