package com.enkode.javacp.practices.lc.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 146
 *
 * <pre>
 *     ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 *     [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 *
 *
 *
 * </pre>
 */
public class LRUCacheImpl1 {

  public static void main(String[] args) {
    LRUCache obj = new LRUCache(2);
    obj.put(1, 1);
    obj.put(2, 2);
    System.out.println(obj.get(1));
    obj.put(3, 3);
    System.out.println(obj.get(2));
    obj.put(4, 4);
    System.out.println(obj.get(1));
    System.out.println(obj.get(3));
    System.out.println(obj.get(4));
  }

  private static class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private static class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      map = new HashMap<>();
      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.next = tail;
      head.pre = null;
      tail.pre = head;
      tail.next = null;
    }

    private void removeNode(Node node) {
      node.pre.next = node.next;
      node.next.pre = node.pre;
    }

    private void insertToHead(Node node) {
      node.pre = head;
      node.next = head.next;
      node.next.pre = node;
      head.next = node;
    }

    public int get(int key) {
      int result = -1;
      if (map.containsKey(key)) {
        Node node = map.get(key);
        removeNode(node);
        insertToHead(node);
        result = node.value;
      }
      return result;
    }

    public void put(int key, int value) {
      if (map.containsKey(key)) {
        Node node = map.get(key);
        node.value = value;
        removeNode(node);
        insertToHead(node);
      } else {
        Node node = new Node(key, value);
        if (map.size() < capacity) {
          map.put(key, node);
          insertToHead(node);
        } else {
          map.remove(tail.pre.key);
          map.put(key, node);
          removeNode(tail.pre);
          insertToHead(node);
        }
      }
    }
  }
}
