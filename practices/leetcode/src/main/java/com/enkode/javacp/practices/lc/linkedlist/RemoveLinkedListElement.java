package com.enkode.javacp.practices.lc.linkedlist;

/**
 * Problem 203
 * <pre>
 *     Test Cases:
 *          1,2,6,3,4,5,6       6
 *          []                  1
 *          7,7,7,7             7
 * </pre>
 */
public class RemoveLinkedListElement {
  public static final StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null)))))));
    head = removeElements(head, 6);
    printList("Output: ", head);
    System.out.println(sb);
  }

  private static ListNode removeElements(ListNode head, int val) {
    if(head == null) return null;

    ListNode dummy = new ListNode();

    ListNode walker = dummy;
    walker.next = head;

    while(walker != null) {
      if(walker.next != null && walker.next.val == val)
        walker.next = walker.next.next;
      else walker = walker.next;
    }
    return dummy.next;
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
     ListNode() {}
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }}
}
