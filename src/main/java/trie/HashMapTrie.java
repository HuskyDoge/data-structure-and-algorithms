package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

/**
 * @author Jialun Li on 2019-02-22
 */
public class HashMapTrie implements Trie {
    private Node root;
    private int size;

    public HashMapTrie() {
        this.root = new Node();
    }

    @Override
    public void insert(String s) {
        Node current = this.root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            current.children.putIfAbsent(c, new Node()); // put a new Node if child
            current = current.children.get(c);
            if (i == s.length() - 1) { // last char of the string
                if (!current.flag) {// set the data flag here
                    current.flag = true;
                    this.size++;
                }
            }
        }
    }

    @Override
    public boolean search(String target) {
        Node current = searchHelper(target);
        return current != null && current.flag;
    }

    @Override
    public boolean hasStartsWith(String prefix) {
        return searchHelper(prefix) != null;
    }

    @Override
    public List<String> getStartsWith(String prefix) {
        List<String> result = new ArrayList<>();
        Node current = searchHelper(prefix);
        if (current != null) {
            // DFS traverse the trie and get data
            Set<Node> visited = new HashSet<>();
            Stack<Node> stack = new Stack<>();
            stack.push(current);
            if (current.flag) {
                result.add(prefix);
            }
            StringBuilder sb = new StringBuilder(prefix);
            while (!stack.isEmpty()) {
                Node top = stack.peek();
                Optional<Map.Entry<Character, Node>> optional = top.children.entrySet().stream().filter(entry -> !visited.contains(entry.getValue())).findAny();
                if (optional.isPresent()) {
                    Node childNode = optional.get().getValue();
                    visited.add(childNode);
                    stack.push(childNode);
                    sb.append(optional.get().getKey());
                    if (childNode.flag) {
                        result.add(sb.toString());
                    }
                } else {
                    stack.pop();
                    sb.deleteCharAt(sb.length() - 1); // delete the char just popped
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

    private Node searchHelper(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return null;
        }
        Node current = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (current.children.get(c) == null) {
                return null;
            }
            current = current.children.get(c);
        }
        return current;
    }

    @Override
    public String toString() {
        List<String> result = new ArrayList<>();
        Node current = this.root;
        Stack<Node> stack = new Stack<>();
        stack.push(current);
        Set<Node> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Node top = stack.peek();
            Optional<Map.Entry<Character, Node>> optional = top.children.entrySet().stream().filter(entry -> !visited.contains(entry.getValue())).findAny();
            if (optional.isPresent()) {
                Node childNode = optional.get().getValue();
                visited.add(childNode);
                stack.push(childNode);
                sb.append(optional.get().getKey());
                if (childNode.flag) {
                    result.add(sb.toString());
                }
            } else {
                stack.pop();
                if (sb.length() - 1 >= 0) {
                    sb.deleteCharAt(sb.length() - 1); // delete the char just popped
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        result.forEach(s -> stringBuilder.append(s).append("\n"));
        return stringBuilder.toString();
    }

    private class Node {
        Map<Character, Node> children;
        boolean flag; // flag to indicate there is data here

        Node() {
            this.children = new HashMap<>();
            this.flag = false;
        }
    }
}
