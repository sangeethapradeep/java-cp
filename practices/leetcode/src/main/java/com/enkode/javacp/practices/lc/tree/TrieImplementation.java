package com.enkode.javacp.practices.lc.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 208
 *
 * <pre>
 *     ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 *     [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 *
 *     ["Trie","insert","search","search","search","startsWith","insert","search"]
 *     [[],["apricot"],["apricot"],["apple"],["app"],["apr"],["aproach"],["aproach"]]
 * </pre>
 */
public class TrieImplementation {
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    System.out.println(trie.search("apple"));
    System.out.println(trie.search("app"));
    System.out.println(trie.startsWith("app"));
    trie.insert("app");
    System.out.println(trie.search("app"));
  }

    private static class Trie {

        private final Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            if(word == null || word.trim().isEmpty()) return;

            for(char ch : word.toCharArray()) {
                if(!node.getChildren().containsKey(ch)) {
                    node.getChildren().put(ch, new Node());
                }
                node = node.getChildren().get(ch);
            }
            node.setTerminating();
        }

        public boolean search(String word) {
            Node node = root;

            for(char ch: word.toCharArray()) {
                if(!node.getChildren().containsKey(ch)) {
                    return false;
                }
                node = node.getChildren().get(ch);
            }

            return node.getTerminating();
        }

        public boolean startsWith(String prefix) {
            Node node = root;

            for(char ch: prefix.toCharArray()) {
                if(!node.getChildren().containsKey(ch)) {
                    return false;
                }
                node = node.getChildren().get(ch);
            }
            return true;
        }

        private static class Node {
            private final Map<Character, Node> children;
            private boolean isTerminating;

            public Node() {
                children = new HashMap<>();
                isTerminating = false;
            }

            public Map<Character, Node> getChildren() {
                return children;
            }

            public void setTerminating() {
                this.isTerminating = true;
            }

            public boolean getTerminating() {
                return this.isTerminating;
            }
        }
    }
}
