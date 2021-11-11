package com.enkode.javacp.practices.lc.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Problem 19
 * <pre>
 *     Test Cases:
 *          1,2,3,4,5       2
 *          1               1
 *          1,2             1
 * </pre>
 */
public class RemoveNthNodeFromEndOfList {
    private static final StringBuilder sb = new StringBuilder();

    static class ListNode {
        private  int val;
        private ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static ListNode push(ListNode head, int value) {
        return new ListNode(value, head);
    }

    private static ListNode addItems(int[] nums) {
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

    private static ListNode removeNthNodeFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();

        ListNode runner = head;

        ListNode walker = dummy;
        walker.next = head;

        for(int i=1; i<n; i++) {
            runner = runner.next;
        }

        while(runner.next != null) {
            runner = runner.next;
            walker = walker.next;
        }

        walker.next = walker.next.next;
        return dummy.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Stream.of(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(br.readLine());
        ListNode head = addItems(nums);
        printList("Initial List", head);
        head = removeNthNodeFromEnd(head, n);
        printList("Final List", head);
        System.out.println(sb);
    }
}
