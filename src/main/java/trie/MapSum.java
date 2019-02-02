package trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Implement a MapSum class with insert, and sum methods.
 *
 * For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
 *
 * For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
 *
 * Example 1:
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 *
 */
class MapSum {
    private TrieNode root;

    // Trie using HasMap as implementation
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int intVal = 0;
    }

    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new TrieNode();
    }

    public void insert(String key, int val) {
        if (key == null) return;
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            TrieNode child = current.children.get(c);
            if (child == null) {
                child = new TrieNode();
                current.children.put(c, child);
            }
            current = child;
            if (i == key.length() - 1) { // end of the word
                current.intVal = val;
            }
        }
    }

    public int sum(String prefix) {
        if (prefix == null) return 0;
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            TrieNode child = current.children.get(c);
            if (child == null) {
                return 0;
            }
            current = child;
        }
        return sumHelper(current);
    }

    // BFS solution to traverse the trie
    private int sumHelper(TrieNode root) {
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (queue.size() > 0) {
            TrieNode first = queue.poll();
            sum += first.intVal;
            first.children.values().forEach(queue::offer);
        }
        return sum;
    }

    // recursive solution to traverse the trie
    //private int sumHelper(TrieNode root) {
//        int sum = root.intVal;
//        if (root.children.size() == 0) {
//            return sum;
//        } else {
//            for (char c : root.children.keySet()) {
//                sum += sumHelper(root.children.get(c));
//            }
//            return sum;
//        }
    //}
}
