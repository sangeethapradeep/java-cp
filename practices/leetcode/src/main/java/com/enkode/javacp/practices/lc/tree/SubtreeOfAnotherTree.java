package com.enkode.javacp.practices.lc.tree;

/**
 * Problem 572
 *
 * <pre>
 *     Test Cases:
 *          root = [3,4,5,1,2], subRoot = [4,1,2]
 *          root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * </pre>
 */
public class SubtreeOfAnotherTree {
  public static void main(String[] args) {
    TreeNode subRoot = new TreeNode(4, new TreeNode(1, null, null), new TreeNode(2, null, null));
    TreeNode root = new TreeNode(3, subRoot, new TreeNode(5, null, null));
    System.out.println("is Subtree?: " + isSubtree(root, subRoot));
  }

  private static boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if(subRoot == null) return true;
    if(root == null) return false;
    if(isSameTree(root, subRoot)) return true;
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  private static boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) return true;
    if(p == null || q == null || p.val != q.val) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
