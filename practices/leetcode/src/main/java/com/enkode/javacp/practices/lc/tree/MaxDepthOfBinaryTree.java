package com.enkode.javacp.practices.lc.tree;

/**
 * Problem 104
 *
 * <pre>
 *     Test Cases:
 *          3,9,20,null,null,15,7
 *          1,null,2
 *          []
 *          0
 * </pre>
 */
public class MaxDepthOfBinaryTree {
  public static void main(String[] args) {
    TreeNode subTree1 = new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null));
    TreeNode root = new TreeNode(3, new TreeNode(9, null, null), subTree1);
    System.out.println(maxDepth(root));
  }

  private static int maxDepth(TreeNode root) {
    return findDepth(root);
  }

  private static int findDepth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(findDepth(root.left), findDepth(root.right)) + 1;
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
