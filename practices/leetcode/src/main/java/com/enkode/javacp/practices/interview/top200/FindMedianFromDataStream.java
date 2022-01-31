package com.enkode.javacp.practices.interview.top200;

import java.util.PriorityQueue;

/**
 * Problem 295
 *
 * <pre>
 *     Test Cases:
 *          ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 *          [[], [1], [2], [], [3], []]
 *
 *
 * </pre>
 */
public class FindMedianFromDataStream {

  public static void main(String[] args) {
    MedianFinder obj = new MedianFinder();
    obj.addNum(1);
    obj.addNum(2);
    System.out.println(obj.findMedian());
    obj.addNum(3);
    System.out.println(obj.findMedian());
  }

  private static class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
      minHeap = new PriorityQueue<>((a, b) -> a - b);
      maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
      if (maxHeap.isEmpty() || maxHeap.peek() >= num) maxHeap.offer(num);
      else minHeap.offer(num);

      if (minHeap.size() > maxHeap.size() + 1) maxHeap.offer(minHeap.poll());
      else if (maxHeap.size() > minHeap.size() + 1) minHeap.offer(maxHeap.poll());
    }

    public double findMedian() {
      if (minHeap.size() == maxHeap.size()) return (minHeap.peek() + maxHeap.peek()) / 2.0;
      else if (minHeap.size() > maxHeap.size()) return minHeap.peek();
      else return maxHeap.peek();
    }
  }
}
