package com.enkode.javacp.practices.lc.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Problem 21
 *
 * <pre>
 *     Test Cases:
 *     1,2,4            1,3,4
 *     []               []
 *     []               [0]
 * </pre>
 */
public class MergeTwoSortedList {

  public static final StringBuilder sb = new StringBuilder();

  private static ListNode push(ListNode head, int value) {
    return new ListNode(value, head);
  }

  private static ListNode createList(int[] nums) {
    ListNode head = null;
    for (int i = nums.length - 1; i >= 0; i--) {
      head = push(head, nums[i]);
    }
    return head;
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

  private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

    ListNode dummy = new ListNode(0, null);
    ListNode result = dummy;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        result.next = l1;
        l1 = l1.next;

      } else {
        result.next = l2;
        l2 = l2.next;
      }
      result = result.next;
    }

    while (l1 != null) {
      result.next = l1;
      l1 = l1.next;
      result = result.next;
    }

    while (l2 != null) {
      result.next = l2;
      l2 = l2.next;
      result = result.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] nums1 = Stream.of(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
    int[] nums2 = Stream.of(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
    ListNode l1 = createList(nums1);
    printList("List 1", l1);
    ListNode l2 = createList(nums2);
    printList("List 1", l2);
    ListNode sum = mergeTwoLists(l1, l2);
    printList("Sum:", sum);
    System.out.println(sb);
  }

  static class ListNode {
    private final int val;
    private ListNode next;

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
