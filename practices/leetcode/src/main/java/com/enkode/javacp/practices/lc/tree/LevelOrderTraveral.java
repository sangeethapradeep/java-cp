package com.enkode.javacp.practices.lc.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem 102
 *
 * <pre>
 *     Test Cases:
 *     1,null,2,3
 *     []
 *     1
 *     1,2
 *     1,null,2
 *     1,2,3,4,null,null,5
 * </pre>
 */
public class LevelOrderTraveral {
  public static void main(String[] args) {
    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4, null, null), null),
            new TreeNode(3, null, new TreeNode(5, null, null)));
    System.out.println(levelOrder(tree));
  }

  /*Using Recursion*/
  private static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    traversal(root, result, 0);
    return result;
  }

  /* queue implementation */
  /*private static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) return result;

    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelNum = queue.size();
      List<Integer> subList = new LinkedList<>();
      for (int i = 0; i < levelNum; i++) {
        if (queue.peek().left != null) queue.offer(queue.peek().left);
        if (queue.peek().right != null) queue.offer(queue.peek().right);
        subList.add(queue.poll().val);
      }
      result.add(subList);
    }
    return result;
  }*/

  private static void traversal(TreeNode root, List<List<Integer>> result, int height) {
    if (root == null) return;
    if (height >= result.size()) result.add(new ArrayList<>());
    result.get(height).add(root.val);
    traversal(root.left, result, height + 1);
    traversal(root.right, result, height + 1);
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
