package com.enkode.javacp.practices.lc.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 677
 *
 * <pre>
 *     Test Cases:
 *          ["MapSum", "insert", "sum", "insert", "sum"]
 *          [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 *
 *          ["MapSum","insert","sum","insert","insert","sum"]
 *          [[],["apple",3],["ap"],["app",2],["apple",2],["ap"]]
 * </pre>
 */
public class MapSum {

  private static final Node root = new Node();

  public static void main(String[] args) {
    insert("apple", 3);
    System.out.println("Sum: " + sum("ap"));
    insert("app", 2);
    insert("apple", 2);
    System.out.println("Sum: " + sum("ap"));
  }

  public static void insert(String key, int val) {
    Node node = root;
    if (key == null || key.trim().isEmpty()) return;

    for (char ch : key.toCharArray()) {
      if (!node.getChildren().containsKey(ch)) {
        node.getChildren().put(ch, new Node());
      }
      node = node.getChildren().get(ch);
    }
    node.val = val;
  }

  private static int sum(String prefix) {
    Node node = root;

    for (char ch : prefix.toCharArray()) {
      if (!node.getChildren().containsKey(ch)) return 0;
      node = node.getChildren().get(ch);
    }

    return node.val + sumHelper(node);
  }

  private static int sumHelper(Node root) {
    int sum = 0;
    for (Node node : root.getChildren().values()) {
      sum += node.val + sumHelper(node);
    }
    return sum;
  }

  private static class Node {
    public int val;
    Map<Character, Node> children;

    public Node() {
      children = new HashMap<>();
      val = 0;
    }

    public Map<Character, Node> getChildren() {
      return children;
    }
  }
}
