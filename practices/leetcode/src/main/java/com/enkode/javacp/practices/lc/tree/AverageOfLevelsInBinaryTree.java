package com.enkode.javacp.practices.lc.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem 637
 *
 * <pre>
 *     Test Case:
 *          [3,9,20,null,null,15,7]
 *          [3,9,20,15,7]
 * </pre>
 */
public class AverageOfLevelsInBinaryTree {

  public static void main(String[] args) {
    TreeNode tree =
        new TreeNode(
            3,
            new TreeNode(9, null, null),
            new TreeNode(20, new TreeNode(15, null, null), new TreeNode(17, null, null)));
    System.out.println("Level Average: " + averageOfLevels(tree));
  }

  private static List<Double> averageOfLevels(TreeNode root) {
    List<Double> avg = new ArrayList<>();
    if (root == null) return avg;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      double sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode x = queue.poll();
        if (x.left != null) queue.offer(x.left);
        if (x.right != null) queue.offer(x.right);
        sum += x.val;
      }
      avg.add(sum / size);
    }

    return avg;
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

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
