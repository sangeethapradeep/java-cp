package com.enkode.javacp.practices.lc.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Problem 2
 * <pre>
 *     Test Cases:
 *          2,4,3               5,6,4
 *          0                   0
 *          9,9,9,9,9,9,9       9,9,9,9
 * </pre>
 */
public class AddTwoNumbers {

    public static final StringBuilder sb = new StringBuilder();

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

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1runner = l1;
        ListNode l2runner = l2;

        ListNode dummy = new ListNode(0);
        ListNode sumRunner = dummy;

        int carry = 0;

        while (l1runner != null || l2runner != null) {

            int x = l1runner != null ? l1runner.val : 0;
            int y = l2runner != null ? l2runner.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;

            sumRunner.next = new ListNode(sum % 10);
            sumRunner = sumRunner.next;

            if (l1runner != null) l1runner = l1runner.next;
            if (l2runner != null) l2runner = l2runner.next;
        }

        if (carry > 0) {
            sumRunner.next = new ListNode(1);
            sumRunner = sumRunner.next;
        }
        sumRunner.next = null;
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
        ListNode sum = addTwoNumbers(l1, l2);
        printList("Sum:", sum);
        System.out.println(sb);
    }
}
