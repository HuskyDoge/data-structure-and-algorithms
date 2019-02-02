package trie;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jialun Li on 2019-02-02
 */
public class MapSumTest {
    @Test
    public void functionalTest() {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        Assert.assertEquals(3, mapSum.sum("app"));
        mapSum.insert("app", 2);
        Assert.assertEquals(5, mapSum.sum("app"));
        mapSum.insert("appld", 1);
        Assert.assertEquals(6, mapSum.sum("app"));
    }
}
