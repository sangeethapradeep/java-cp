package com.enkode.javacp.practices.lc.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Problem 86
 * <pre>
 *     Test Cases:
 *          1,4,3,2,5,2         3
 *          2,1                 2
 * </pre>
 */
public class PartitionList {

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

    private static ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode smallRunner = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode largeRunner = largeHead;

        while(head != null) {
            if(head.val < x) {
                smallRunner.next = head;
                smallRunner = smallRunner.next;
            } else {
                largeRunner.next = head;
                largeRunner = largeRunner.next;
            }
            head = head.next;
        }

        largeRunner.next = null;
        smallRunner.next = largeHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Stream.of(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(br.readLine());
        ListNode head = createList(nums);
        printList("Initial List", head);
        head = partition(head, x);
        printList("Final List", head);
        System.out.println(sb);
    }
}
