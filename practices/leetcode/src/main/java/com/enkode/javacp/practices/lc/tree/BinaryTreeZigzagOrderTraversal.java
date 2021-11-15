package com.enkode.javacp.practices.lc.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem 103
 *
 * <pre>
 *     Test Cases:
 *          3,9,20,null,null,15,7
 *          1
 *          []
 * </pre>
 */
public class BinaryTreeZigzagOrderTraversal {
  public static void main(String[] args) {
    TreeNode subTree1 = new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null));
    TreeNode root = new TreeNode(3, new TreeNode(9, null, null), subTree1);
    System.out.println(zigzagLevelOrder(root));
  }

  private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    zigzagTraversal(root, result);
    return result;
  }

  private static void zigzagTraversal(TreeNode root, List<List<Integer>> result) {
    Queue<TreeNode> queue = new LinkedList<>();

    if (root == null) return;
    queue.offer(root);
    int level = 1;
    while (!queue.isEmpty()) {
      int levelNodes = queue.size();
      List<Integer> subList = new ArrayList<>();
      for (int i = 0; i < levelNodes; i++) {
        TreeNode currNode = queue.peek();
        if (currNode.left != null) queue.add(currNode.left);
        if (currNode.right != null) queue.add(currNode.right);
        if (level % 2 == 0) subList.add(0, queue.poll().val);
        else subList.add(queue.poll().val);
      }
      result.add(subList);
      level++;
    }
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
