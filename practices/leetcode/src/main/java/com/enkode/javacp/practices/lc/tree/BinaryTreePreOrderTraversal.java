package com.enkode.javacp.practices.lc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 144
 *
 * <pre>
 *     Test Cases:
 *          root = [1,null,2,3]
 *          root = []
 *          root = [1]
 * </pre>
 */
public class BinaryTreePreOrderTraversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
    System.out.println(preorderTraversal(root));
  }

  private static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    traversal(root, result);
    return result;
  }

  private static void traversal(TreeNode root, List<Integer> result) {
    if (root == null) return;
    result.add(root.val);
    traversal(root.left, result);
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
