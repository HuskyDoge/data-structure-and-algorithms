package trie;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jialun Li on 2019-02-02
 */
public class TrieTest {
    @Test
    public void functionalTest() {
        Trie trie = new Trie();
        trie.insert("google");
        trie.insert("kill");
        trie.insert("duck");
        trie.insert("application");

        Assert.assertTrue(trie.search("google"));
        Assert.assertFalse(trie.search("goo"));
        Assert.assertFalse(trie.search("switch"));
        Assert.assertFalse(trie.search(""));

        Assert.assertTrue(trie.startsWith("goo"));
        Assert.assertTrue(trie.startsWith("goog"));
        Assert.assertTrue(trie.startsWith("g"));
        Assert.assertFalse(trie.startsWith("switch"));


        Trie emptyTrie = new Trie();
        emptyTrie.insert("");
        Assert.assertFalse(emptyTrie.search("google"));
        Assert.assertFalse(emptyTrie.startsWith("goo"));
        Assert.assertFalse(emptyTrie.startsWith(""));
    }
}
