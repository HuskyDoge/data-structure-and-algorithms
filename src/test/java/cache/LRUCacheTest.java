package cache;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author Jialun Li on 2019-03-12
 */
public class LRUCacheTest {
    @Test
    public void test() {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        Assert.assertEquals(1, lruCache.get(1).intValue());
        lruCache.put(3, 3);
        Assert.assertNull(lruCache.get(2));
        lruCache.put(4,4);
        Assert.assertNull(lruCache.get(1));
        Assert.assertEquals(3, lruCache.get(3).intValue());
        Assert.assertEquals(4, lruCache.get(4).intValue());
    }

    @Test
    //["LRUCache","put","put","put","put","get","get"]
    //[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
    public void test2() {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(2);
        lruCache.put(2, 6);
        lruCache.get(1);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        lruCache.get(1);
        lruCache.get(2);
    }

    @Test
    public void test3() {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        lruCache.get(2);
        lruCache.put(1, 1);
        lruCache.put(4, 1);
        lruCache.get(2);
    }


    @Test
    //["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
    //[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
    public void test4() {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(10);
        String input = "[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]";
        String s = "";
        for (int i = 0; i < input.length();i++) {
            if (input.charAt(i) == '[') {
                s = "";
            } else if (input.charAt(i) == ']') {
                if (s.contains(",")) {
                    String[] split = s.split(",");
                    lruCache.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                } else {
                    Integer integer = lruCache.get(Integer.parseInt(s));
                }
            } else {
                s += input.charAt(i);
            }
        }
    }
}
