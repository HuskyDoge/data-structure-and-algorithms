package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

// use array implementation
public class ArrayTrie implements Trie {
    private static final int ALPHABET_SIZE = 26;
    private Node root;
    private int size;

    private class Node {
        Node[] children;
        boolean flag;
        Node() {
            this.flag = false;
            this.children = new Node[ALPHABET_SIZE];
        }
    }

    public ArrayTrie() {
        this.root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node child = current.children[c - 97];
            if (child == null) {
                child = new Node();
                current.children[c - 97] = child;
            }
            if (i == word.length() - 1) {
                if (!child.flag) {
                    child.flag = true;
                    this.size++;
                }
            }
            current = child;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = searchHelper(word);
        return node != null && node.flag;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean hasStartsWith(String prefix) {
        return searchHelper(prefix) != null;
    }

    private Node searchHelper(String target) {
        if (target == null || target.isEmpty()) {
            return null;
        }
        Node current = this.root;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (current.children[c - 97] == null) {
                return null;
            }
            current = current.children[c - 97];
        }
        return current;
    }

    @Override
    public List<String> getStartsWith(String prefix) {
        List<String> result = new ArrayList<>();
        Node current = searchHelper(prefix);
        if (current != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(current);
            StringBuilder sb = new StringBuilder(prefix);
            if (current.flag) {
                result.add(sb.toString());
            }
            Set<Node> visited = new HashSet<>();
            while (!stack.isEmpty()) {
                Node top = stack.peek();
                boolean hasChild = false;
                for (int i = 0; i < ALPHABET_SIZE; i++) {
                    Node child = top.children[i];
                    if (child != null && !visited.contains(child)) {
                        visited.add(child);
                        stack.push(child);
                        sb.append((char) (i + 97));
                        if (child.flag) {
                            result.add(sb.toString());
                        }
                        hasChild = true;
                        break;
                    }
                }
                if (!hasChild) {
                    stack.pop();
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }
}