package com.enkode.javacp.practices.lc.tree;

/**
 * Problem 108
 *
 * <pre>
 *     Test Cases:
 *          [-10,-3,0,5,9]
 *          [1,3]
 *          [0]
 * </pre>
 */
public class ConvertSortedArrayToBinarySearchTree {
  public static void main(String[] args) {
    int[] nums = {-10, -3, 0, 5, 9};
    preOrderTraversal(sortedArrayToBST(nums));
  }

  private static TreeNode sortedArrayToBST(int[] nums) {
    return treeize(nums, 0, nums.length - 1);
  }

  private static TreeNode treeize(int[] nums, int start, int end) {
    if (start > end) return null;

    int mid = (end - start) / 2 + start;

    return new TreeNode(nums[mid], treeize(nums, start, mid - 1), treeize(nums, mid + 1, end));
  }

  private static void preOrderTraversal(TreeNode root) {
    if (root == null) return;
    System.out.println(root.val);
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
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
