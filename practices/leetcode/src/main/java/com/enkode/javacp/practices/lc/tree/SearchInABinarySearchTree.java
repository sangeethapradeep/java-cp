package com.enkode.javacp.practices.lc.tree;

/**
 * Problem 700
 *
 * <pre>
 *     Test Cases:
 *          root = [4,2,7,1,3], val = 2
 *          root = [4,2,7,1,3], val = 5
 * </pre>
 */
public class SearchInABinarySearchTree {
  public static void main(String[] args) {
    TreeNode root =
        new TreeNode(
            4,
            new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)),
            new TreeNode(7, null, null));
    int searchVal = 2;
    System.out.println(searchBST(root, searchVal).val == searchVal);
  }

  private static TreeNode searchBST(TreeNode root, int val) {
    if (root == null) return null;

    if (root.val < val) return searchBST(root.right, val);
    if (root.val > val) return searchBST(root.left, val);

    return root;
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
