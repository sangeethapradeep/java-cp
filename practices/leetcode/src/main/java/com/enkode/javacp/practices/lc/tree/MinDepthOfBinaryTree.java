package com.enkode.javacp.practices.lc.tree;

/**
 * Problem 111
 *
 * <pre>
 *     Test Cases:
 *          3,9,20,null,null,15,7
 *          2,null,3,null,4,null,5,null,6
 *          []
 *          0
 * </pre>
 */
public class MinDepthOfBinaryTree {
  public static void main(String[] args) {
    TreeNode subTree1 = new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null));
    TreeNode root = new TreeNode(3, new TreeNode(9, null, null), subTree1);
    System.out.println(minDepth(root));
  }

  private static int minDepth(TreeNode root) {
    return findByDfs(root);
  }

  private static int findByDfs(TreeNode root) {
    if (root == null) return 0;
    if (root.left != null && root.right != null)
      return Math.min(findByDfs(root.left), findByDfs(root.right)) + 1;
    else return Math.max(findByDfs(root.left), findByDfs(root.right)) + 1;
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
