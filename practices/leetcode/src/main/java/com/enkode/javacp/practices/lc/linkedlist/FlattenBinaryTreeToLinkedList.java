package com.enkode.javacp.practices.lc.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Problem 114.
 * <pre>
 *   Test Cases:
 *        1,2,5,3,4,null,6
 *        []
 *        0
 * </pre>
 */
public class FlattenBinaryTreeToLinkedList {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(",");
    TreeNode tree = build(input, new TreeNode(), 0);
//    sb.append(fizzBuzz(num));
    System.out.println(sb);
  }

  private static TreeNode build(String[] nums, TreeNode root, int i) {
    if (i < nums.length) {
      Integer num = nums[i] == null ? null : Integer.parseInt(nums[i]);
      TreeNode node = new TreeNode(num);
      root = node;
      node.left = build(nums, root.left, 2 * i + 1);
      node.right = build(nums, root.right, 2 * i + 2);
    }
    return root;
  }

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}
