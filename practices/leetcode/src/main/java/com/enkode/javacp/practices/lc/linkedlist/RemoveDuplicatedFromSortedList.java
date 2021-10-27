package com.enkode.javacp.practices.lc.linkedlist;

/**
 * Problem 83
 *
 * <pre>
 *     Test Cases:
 *          1,1,2
 *          1,1,2,3,3
 *
 * </pre>
 */
public class RemoveDuplicatedFromSortedList {

  public static void main(String[] args) {
    ListNode node = new ListNode(1, new ListNode(1, new ListNode(2, null)));
    deleteDuplicates(node);
    printList(node);

  }

  private static void deleteDuplicates(ListNode head) {
    ListNode runner = head;

    while(runner!=null) {
      if(runner.next == null) break;
      if(runner.val == runner.next.val) {
        runner.next = runner.next.next;
      } else {
        runner = runner.next;
      }
    }
  }

  private static void printList(ListNode head) {
    while(head != null) {
      if(head.next != null) {
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


    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
