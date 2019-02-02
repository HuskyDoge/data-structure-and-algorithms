package trie;

// use array implementation
public class ArrayTrie {
    private static final int ALPHABET_SIZE = 26;
    private TrieNode root;

    private static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
        TrieNode() {
            isEndOfWord = false;
        }
    }

    /** Initialize your data structure here. */
    public ArrayTrie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode child = current.children[c - 97];
            if (child == null) {
                child = new TrieNode();
            }
            if (i == word.length() - 1) {
                child.isEndOfWord = true;
            }
            current.children[c - 97] = child;
            current = child;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.isEmpty()) return false;
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode child = current.children[c - 97];
            if (child != null) {
                if (i == word.length() - 1) {
                    return child.isEndOfWord;
                }
                current = child;
            } else {
                return false;
            }
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) return false;
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            TrieNode child = current.children[c - 97];
            if (child != null) {
                current = child;
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your ArrayTrie object will be instantiated and called as such:
 * ArrayTrie obj = new ArrayTrie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */