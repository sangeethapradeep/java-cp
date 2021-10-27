package com.enkode.javacp.practices.lc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 94
 *
 * <pre>
 *     Test Cases:
 *     1,null,2,3
 *     []
 *     1
 *     1,2
 *     1,null,2
 * </pre>
 */
public class InOrderTraveral {
  public static void main(String[] args) {
    TreeNode tree = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
    System.out.println(inorderTraversal(tree));
  }

  private static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    traversal(root, result);
    return result;
  }

  private static void traversal(TreeNode root, List<Integer> result) {
    if(root == null) return;
    traversal(root.left, result);
    result.add(root.val);
    traversal(root.right, result);
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
