package com.enkode.javacp.practices.lc.tree;

/**
 * Problem 112
 *
 * <pre>
 *     Test Case:
 *          5,4,8,11,null,13,4,7,2,null,null,null,1        22
 *          1,2,3                                       5
 * </pre>
 */
public class PathSum {

  public static void main(String[] args) {
    TreeNode subTree1 = new TreeNode(11, new TreeNode(7, null, null), new TreeNode(2, null, null));
    TreeNode subTree2 = new TreeNode(4, null, new TreeNode(1, null, null));
    TreeNode subTree3 = new TreeNode(8, new TreeNode(13, null, null), subTree2);
    TreeNode subTree4 = new TreeNode(4, subTree1, null);
    TreeNode root = new TreeNode(5, subTree4, subTree3);
    int targetSum = 22;
    System.out.println(hasPathSum(root, targetSum));
  }

  private static boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;

    if (root.right == null && root.left == null && targetSum - root.val == 0) return true;

    return hasPathSum(root.right, targetSum - root.val)
        | hasPathSum(root.left, targetSum - root.val);
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
