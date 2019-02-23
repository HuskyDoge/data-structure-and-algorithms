package trie;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * @author Jialun Li on 2019-02-22
 */
public class TrieTest {
    @Test
    public void HashMapTrieTest() {
        Trie trie = new HashMapTrie();
        testCase(trie);
    }

    @Test
    public void ArrayTrieTest() {
        Trie trie = new ArrayTrie();
        testCase(trie);
    }

    private void testCase(Trie trie) {
        trie.insert("good");
        trie.insert("goo");
        trie.insert("god");
        trie.insert("golf");
        trie.insert("boy");
        trie.insert("boye");
        trie.insert("book");
        Assert.assertFalse(trie.isEmpty());
        Assert.assertEquals(7, trie.size());

        Assert.assertTrue(trie.search("good"));
        Assert.assertTrue(trie.search("goo"));
        Assert.assertTrue(trie.search("boy"));
        Assert.assertFalse(trie.search("bo"));
        Assert.assertFalse(trie.search("boyee"));
        Assert.assertFalse(trie.search(""));
        Assert.assertFalse(trie.search(null));


        Assert.assertTrue(trie.hasStartsWith("g"));
        Assert.assertTrue(trie.hasStartsWith("go"));
        Assert.assertTrue(trie.hasStartsWith("goo"));
        Assert.assertTrue(trie.hasStartsWith("good"));
        Assert.assertTrue(trie.hasStartsWith("b"));
        Assert.assertTrue(trie.hasStartsWith("bo"));
        Assert.assertTrue(trie.hasStartsWith("boy"));
        Assert.assertFalse(trie.hasStartsWith("boyee"));
        Assert.assertFalse(trie.hasStartsWith("by"));
        Assert.assertFalse(trie.hasStartsWith(""));
        Assert.assertFalse(trie.hasStartsWith(null));


        Assert.assertThat(trie.getStartsWith("g"), containsInAnyOrder("good", "goo", "god", "golf"));
        Assert.assertThat(trie.getStartsWith("go"), containsInAnyOrder("good", "goo", "god", "golf"));
        Assert.assertThat(trie.getStartsWith("god"), containsInAnyOrder("god"));
        Assert.assertThat(trie.getStartsWith("golf"), containsInAnyOrder("golf"));
        Assert.assertThat(trie.getStartsWith("bo"), containsInAnyOrder("boy","boye","book"));
        Assert.assertThat(trie.getStartsWith(null), containsInAnyOrder());


        System.out.println(trie.toString());
    }
}
