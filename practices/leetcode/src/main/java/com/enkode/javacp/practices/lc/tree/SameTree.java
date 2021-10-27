package com.enkode.javacp.practices.lc.tree;

/**
 * Problem 100
 *
 * <pre>
 *      Test Cases:
 *      1,2,3            1,2,3
 *      1,2              1,null,2
 *      1,2,1            1,1,2
 * </pre>
 */
public class SameTree {

  public static void main(String[] args) {
    TreeNode tree1 = new TreeNode(1, new TreeNode(2), null);
    TreeNode tree2 = new TreeNode(1, null, new TreeNode(2));
    System.out.println(isSameTree(tree1, tree2));
  }

  private static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null || p.val != q.val) return false;
    return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
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
