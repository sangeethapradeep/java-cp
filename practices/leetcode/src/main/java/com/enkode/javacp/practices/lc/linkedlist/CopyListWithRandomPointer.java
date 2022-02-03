package com.enkode.javacp.practices.lc.linkedlist;

/**
 * Problem 138
 *
 * <pre>
 *     [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * </pre>
 */
public class CopyListWithRandomPointer {
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    Node node1 = new Node(7);
    Node node2 = new Node(13);
    Node node3 = new Node(11);
    Node node4 = new Node(10);
    Node node5 = new Node(1);
    node1.next = node2;
    node1.random = null;
    node2.next = node3;
    node2.random = node1;
    node3.next = node4;
    node3.random = node5;
    node4.next = node5;
    node4.random = node3;
    node5.next = null;
    node5.random = node1;

    Node deepCopy = copyRandomList(node1);
    printList("Copy", deepCopy);
    System.out.println(sb);
  }

  private static void printList(String heading, Node head) {
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

  private static Node copyRandomList(Node head) {
    if (head == null) return null;
    Node runner = head;

    while (runner != null) {
      Node copy = new Node(runner.val);
      copy.next = runner.next;
      runner.next = copy;
      runner = runner.next.next;
    }

    runner = head;

    while (runner != null) {
      Node copy = runner.next;
      if (runner.random != null) {
        copy.random = runner.random.next;
      } else {
        copy.random = null;
      }
      runner = runner.next.next;
    }

    runner = head;

    Node deepCloneHead = runner.next;
    Node deepClone = deepCloneHead;

    while (runner != null) {
      runner.next = runner.next.next;
      if (deepClone.next != null) {
        deepClone.next = deepClone.next.next;
      }
      runner = runner.next;
      deepClone = deepClone.next;
    }

    return deepCloneHead;
  }

  private static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
