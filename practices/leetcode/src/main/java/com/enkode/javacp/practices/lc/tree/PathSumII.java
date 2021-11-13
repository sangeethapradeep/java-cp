package com.enkode.javacp.practices.lc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 113
 *
 * <pre>
 *     Test Case:
 *          5,4,8,11,null,13,4,7,2,null,null,5,1        22
 *          1,2,3                                       5
 * </pre>
 */
public class PathSumII {

  public static void main(String[] args) {
    TreeNode subTree1 = new TreeNode(11, new TreeNode(7, null, null), new TreeNode(2, null, null));
    TreeNode subTree2 = new TreeNode(4, new TreeNode(5, null, null), new TreeNode(1, null, null));
    TreeNode subTree3 = new TreeNode(8, new TreeNode(13, null, null), subTree2);
    TreeNode subTree4 = new TreeNode(4, subTree1, null);
    TreeNode root = new TreeNode(5, subTree4, subTree3);
    System.out.println(pathSum(root));
  }

  private static List<List<Integer>> pathSum(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    findByDfs(root, 22, new ArrayList<>(), result);
    return result;
  }

  private static void findByDfs(
      TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> result) {
    if (root == null) return;

    path.add(root.val);

    if (root.left == null && root.right == null && targetSum == root.val) {
      result.add(new ArrayList<>(path));
    } else {
      findByDfs(root.left, targetSum - root.val, path, result);
      findByDfs(root.right, targetSum - root.val, path, result);
    }
    path.remove(path.size() - 1);
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
