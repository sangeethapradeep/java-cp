package com.enkode.javacp.practices.lc.tree;

/**
 * Problem 235
 *
 * <pre>
 *     Test Cases:
 *          root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 *          root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 *          root = [2,1], p = 2, q = 1
 * </pre>
 */
public class LowestCommonAncester {
  public static void main(String[] args) {
    TreeNode subTree1 = new TreeNode(4, new TreeNode(3, null, null), new TreeNode(5, null, null));
    TreeNode subTree2 = new TreeNode(2, new TreeNode(0, null, null), subTree1);
    TreeNode subTree3 = new TreeNode(8, new TreeNode(7, null, null), new TreeNode(9, null, null));
    TreeNode root = new TreeNode(6, subTree2, subTree3);
    int p = 2;
    int q = 4;
    System.out.println(
        lowestCommonAncestor(root, new TreeNode(p, null, null), new TreeNode(q, null, null)).val);
  }

  private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if ((root.val >= p.val && root.val <= q.val) || (root.val >= q.val && root.val <= p.val))
      return root;
    else if (p.val <= root.val) return lowestCommonAncestor(root.left, p, q);
    else return lowestCommonAncestor(root.right, p, q);
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x, TreeNode leftNode, TreeNode rightNode) {
      val = x;
      left = leftNode;
      right = rightNode;
    }
  }
}
