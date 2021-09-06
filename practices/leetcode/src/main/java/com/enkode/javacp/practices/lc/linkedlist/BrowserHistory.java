package com.enkode.javacp.practices.lc.linkedlist;

/**
 * Problem 1472
 * <pre>
 *     Test Cases:
 *          +  "BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"
 *              ["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]
 * </pre>
 */
public class BrowserHistory {
    static class HistoryNode {
        String url;
        HistoryNode prev;
        HistoryNode next;
        HistoryNode(String url, HistoryNode prev) {
            this.url = url;
            this.prev = prev;
            this.next = null;
        }
    }

    HistoryNode currentPage;

    public BrowserHistory(String homepage) {
        this.currentPage = new HistoryNode(homepage, null);
    }

    public void visit(String url) {
        this.currentPage.next = new HistoryNode(url, this.currentPage);
        this.currentPage = this.currentPage.next;
    }

    public String back(int steps) {
        while(currentPage.prev != null && steps-- > 0) {
            currentPage = currentPage.prev;
        }
        return currentPage.url;
    }

    public String forward(int steps) {
        while(currentPage.next != null && steps-- > 0) {
            currentPage = currentPage.next;
        }
        return currentPage.url;
    }

    public static void main(String[] args) {
        BrowserHistory obj = new BrowserHistory("google.com");
        obj.visit("facebook.com");
        obj.visit("leetcode.com");
        obj.visit("linkedin.com");
        System.out.println("Back at " + obj.back(2));
        System.out.println("Forward at " + obj.forward(2));
    }
}
