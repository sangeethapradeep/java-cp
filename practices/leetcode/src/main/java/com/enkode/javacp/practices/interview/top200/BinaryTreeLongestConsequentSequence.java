package com.enkode.javacp.practices.interview.top200;

/**
 * Problem 298
 *
 * <pre>
 *     Test Cases:
 *          1,0,3,0,0,2,4,0,0,0,0,0,0,5
 * </pre>
 */
public class BinaryTreeLongestConsequentSequence {

  public static void main(String[] args) {
    TreeNode subTree =
        new TreeNode(
            3, new TreeNode(2, null, null), new TreeNode(4, null, new TreeNode(5, null, null)));
    TreeNode root = new TreeNode(1, null, subTree);
    System.out.println("Length of longest consecutive: " + longestConsecutive(root));
  }

  private static int longestConsecutive(TreeNode root) {
    int[] max = new int[1];
    util(root, 0, root.val, max);
    return max[0];
  }

  private static void util(TreeNode root, int count, int target, int[] max) {
    if (root == null) return;
    else if (root.val == target) count++;
    else count = 1;

    max[0] = Math.max(max[0], count);
    util(root.left, count, root.val + 1, max);
    util(root.right, count, root.val + 1, max);
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
