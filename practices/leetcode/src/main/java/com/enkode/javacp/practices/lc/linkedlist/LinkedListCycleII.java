package com.enkode.javacp.practices.lc.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Problem 142
 * <pre>
 *     Test Cases:
 *          head = 1,2      pos = 0
 *          head = 3,2,0,-4 pos = 1
 *          head = 1        pos = -1
 * </pre>
 */
public class LinkedListCycleII {

    static class ListNode {
        private final int val;
        private ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    private static ListNode push(ListNode head, int value) {
        ListNode node = new ListNode(value);
        node.next = head;
        return node;
    }

    private static ListNode createList(int[] nums, int pos) {
        ListNode head = null;
        ListNode tail = null;
        ListNode cycleStart = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            head = push(head, nums[i]);
            if (i == nums.length - 1) {
                tail = head;
            }
            if (i == pos) {
                cycleStart = head;
            }
        }
        if (pos != -1 && tail != null) {
            tail.next = cycleStart;
        }
        return head;
    }

    private static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode walker = head;
        ListNode runner = head;
        boolean isCycle = false;

        while(walker != null && runner != null) {
            walker = walker.next;
            if(runner.next == null) return null;
            runner = runner.next.next;

            if(walker == runner) {
                isCycle = true;
                walker = head;
                break;
            }
        }

        if(!isCycle) return null;
        while(walker != runner) {
            walker = walker.next;
            runner = runner.next;
        }
        return walker;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Stream.of(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int pos = Integer.parseInt(br.readLine());
        ListNode head = createList(nums, pos);
        ListNode cycle = detectCycle(head);
        if (cycle != null) {
            System.out.println(cycle.val);
        } else {
            System.out.println("No Cycle");
        }
    }
}
