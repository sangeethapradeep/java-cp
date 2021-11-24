package com.enkode.javacp.practices.lc.linkedlist;

import java.util.LinkedHashMap;
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
public class LRUCacheImpl2 {

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

  private static class LRUCache extends LinkedHashMap<Integer, Integer> {

    private final int maxSize;

    public LRUCache(int capacity) {
      super(capacity, 0.75F, true);
      this.maxSize = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
      return size() > maxSize;
    }

    public int get(int key) {
      return super.getOrDefault(key, -1);
    }
  }
}
