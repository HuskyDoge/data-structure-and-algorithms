package tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * @author Jialun Li on 2019-02-27
 */
public class TreeTest {
    @Test
    public void HeightAwareBSTTest() {
        BST<Integer> heightAwareBST = new HeightAwareBST();
        testCase(heightAwareBST);
        testSpeed(heightAwareBST);
    }

    private void testCase(BST<Integer> bst) {
        Assert.assertFalse(bst.remove(1));

        /*
         *        null        null
         *         |    ->     |
         *         5
         */
        bst.insert(5);
        Assert.assertTrue(bst.contains(5));
        Assert.assertFalse(bst.contains(10));
        bst.remove(5);
        Assert.assertFalse(bst.contains(5));

        /*
         *        null        null
         *         |            |
         *         5    ->      5
         *        / \          /
         *       3   7        3
         *
         */
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.remove(7);
        Assert.assertTrue(bst.contains(5));
        Assert.assertTrue(bst.contains(3));
        Assert.assertTrue(!bst.contains(7));
        bst.clear();


        /*
         *        null        null
         *         |            |
         *         5    ->      3
         *        /
         *       3
         *
         */
        bst.insert(5);
        bst.insert(3);
        bst.remove(5);
        Assert.assertTrue(!bst.contains(5));
        Assert.assertTrue(bst.contains(3));
        bst.clear();

        /*       5            7
         *      / \     ->   /
         *     3  7         3
         */
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.remove(5);
        Assert.assertTrue(!bst.contains(5));
        Assert.assertTrue(bst.contains(3));
        Assert.assertTrue(bst.contains(7));
        bst.clear();



        /*      5               7
         *     / \             / \
         *    3  7       ->   3   9
         *       \
         *       9
         */
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(9);
        bst.remove(5);
        Assert.assertTrue(!bst.contains(5));
        Assert.assertTrue(bst.contains(3));
        Assert.assertTrue(bst.contains(7));
        bst.clear();


        /**
         *
         *              4                      4
         *             / \                    / \
         *            3   8                  3  10
         *               / \     ->            /  \
         *              7  15                 7   15
         *                 /
         *                10
         */
        bst.insert(4);
        bst.insert(3);
        bst.insert(8);
        bst.insert(7);
        bst.insert(15);
        bst.insert(10);
        bst.remove(8);
        bst.clear();


        /**
         *
         *              4                      7
         *             / \                    / \
         *            3   8                  3   8
         *               / \     ->               \
         *              7  15                      15
         *                 / \                    / \
         *                10 19                  10  19
         *                    \                      \
         *                    25                     25
         */
        bst.insert(4);
        bst.insert(3);
        bst.insert(8);
        bst.insert(7);
        bst.insert(15);
        bst.insert(10);
        bst.insert(19);
        bst.insert(25);
        bst.remove(4);
        bst.clear();


        /**
         *            4                         4
         *           / \                       / \
         *          3   8                     3  10
         *             / \          ->           / \
         *            7  15                     7   15
         *               / \                        / \
         *              10 19                      13  19
         *               \  \                           \
         *               13 25                          25
         */
        bst.insert(4);
        bst.insert(3);
        bst.insert(8);
        bst.insert(7);
        bst.insert(15);
        bst.insert(10);
        bst.insert(19);
        bst.insert(25);
        bst.insert(13);
        bst.remove(8);
        bst.clear();



    }

    private void testSpeed(BST<Integer> bst) {
        long t0 = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            bst.insert(random.nextInt(10000));
        }
        long t1 = System.currentTimeMillis();
        System.out.println("insert: " + (t1 - t0)  +  "ms");
        System.out.println("current size: " + bst.size());
        for (int i = 0; i < 10000000; i++) {
            bst.contains(random.nextInt(10000));
        }

        long t2 = System.currentTimeMillis();
        System.out.println("search: " + (t2 - t1)  +  "ms");

        for (int i = 0; i < 10000000; i++) {
            bst.remove(random.nextInt(10000));
        }

        long t3 = System.currentTimeMillis();
        System.out.println("search: " + (t3 - t2)  +  "ms");
        System.out.println("current size: " + bst.size());
    }
}
