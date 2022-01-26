package com.enkode.javacp.practices.interview.amazon;

import java.util.*;

/**
 * Amazon
 * Problem 863
 *
 * <pre>
 *     Test Cases:
 *          root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 *          root = [1], target = 1, k = 3
 *
 * </pre>
 */
public class AllNodesDistanceKInBinaryTree {

  public static void main(String[] args) {
    TreeNode rightTree = new TreeNode(1, new TreeNode(0, null, null), new TreeNode(8, null, null));
    TreeNode leftTree1 = new TreeNode(2, new TreeNode(7, null, null), new TreeNode(4, null, null));
    TreeNode leftTree = new TreeNode(5, new TreeNode(6, null, null), leftTree1);
    TreeNode root = new TreeNode(1, null, null);
    System.out.println(distanceK(root, root, 3));
  }

  private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

    List<Integer> result = new ArrayList<>();

    if(k == 0) return List.of(target.val);
    List<List<Integer>> adjList = new ArrayList<>(501);
    for(int i = 0; i < 501; i++) {
      adjList.add(i, new LinkedList<>());
    }

    buildMap(root, adjList);

    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    queue.offer(target.val);
    visited.add(target.val);

    int level = 0;

    while(!queue.isEmpty()) {
      int size = queue.size();

      for(int i=0; i<size; i++){
        int node = queue.poll();
        if(level ==k) result.add(node);
        else {
          for(int neighbor: adjList.get(node) ) {
            if(!visited.contains(neighbor)){
              queue.offer(neighbor);
              visited.add(neighbor);
            }
          }
        }

      }
      if (level == k) break;
      else level++;

    }


    return result;
  }

  private static void buildMap(TreeNode root, List<List<Integer>> adjList) {
    if(root == null) return;


    if(root.left != null) {
      adjList.get(root.val).add(root.left.val);
      adjList.get(root.left.val).add(root.val);
      buildMap(root.left, adjList);
    }

    if(root.right != null) {
      adjList.get(root.val).add(root.right.val);
      adjList.get(root.right.val).add(root.val);
      buildMap(root.right, adjList);
    }
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x, TreeNode left, TreeNode right) {
      val = x;
      this.left = left;
      this.right = right;
    }
  }
}
