package trie;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jialun Li on 2019-02-02
 */
public class ArrayTrieTest {
    @Test
    public void functionalTest() {
        ArrayTrie trie = new ArrayTrie();
        trie.insert("google");
        trie.insert("kill");
        trie.insert("duck");
        trie.insert("application");

        Assert.assertTrue(trie.search("google"));
        Assert.assertFalse(trie.search("goo"));
        Assert.assertFalse(trie.search("switch"));
        Assert.assertFalse(trie.search(""));

        Assert.assertTrue(trie.hasStartsWith("goo"));
        Assert.assertTrue(trie.hasStartsWith("goog"));
        Assert.assertTrue(trie.hasStartsWith("g"));
        Assert.assertFalse(trie.hasStartsWith("switch"));


        ArrayTrie emptyTrie = new ArrayTrie();
        emptyTrie.insert("");
        Assert.assertFalse(emptyTrie.search("google"));
        Assert.assertFalse(emptyTrie.hasStartsWith("goo"));
        Assert.assertFalse(emptyTrie.hasStartsWith(""));
    }
}
