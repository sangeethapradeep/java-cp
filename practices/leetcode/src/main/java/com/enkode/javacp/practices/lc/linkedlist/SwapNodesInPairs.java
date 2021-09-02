package com.enkode.javacp.practices.lc.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Problem 24.
 * <pre>
 *     Test Cases:
 *          1,2,3,4
 *          []
 *          1
 * </pre>
 */
public class SwapNodesInPairs {
    private static final StringBuilder sb = new StringBuilder();

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

    private static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode walker = dummy;

        while(walker.next != null && walker.next.next != null) {
            ListNode first = walker.next;
            ListNode second = walker.next.next;

            walker.next = second;
            first.next = second.next;
            second.next = first;

            walker = walker.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Stream.of(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        ListNode head = createList(nums);
        printList("Initial List", head);
        head = swapPairs(head);
        printList("Final List", head);
        System.out.println(sb);
    }

}
