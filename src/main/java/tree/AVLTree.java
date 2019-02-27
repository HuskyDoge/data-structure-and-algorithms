package tree;

/**
 * @author Jialun Li on 2019-02-25
 * Operation            Average     Worst Case
 * Space                O(n)        O(n)
 * contains/traverse      O(log n)    O(log n)
 * Insert               O(log n)    O(log n)
 * Remove               O(log n)    O(log n)
 */
public class AVLTree {
    private class Node {
        Integer key;
        int height;
        Node left, right, parent;
        Node (int key) {
            this.key = key;
            this.height = 0;
        }
    }

    private Node root;

    public AVLTree() {
        this.root = null;
    }

    /**
     * traverse the tree and find the position to put the node
     * balance the tree by using rotation method
     * update the height of all sub-tree affected by the rotations.
     */
    public void insert(int key) {
        this.root = insertHelper(root, key);
    }

    private Node insertHelper(Node current, int key) {
        if (current == null) {
            return new Node(key);
        }
        if (key < current.key) { // contains left
            current.left = insertHelper(current.left, key);
        } else if (key > current.key) { // contains right
            current.right = insertHelper(current.right, key);
        }
        return current;
    }

    private void leftRotate(Node current) {
        Node rootNode = current.right;
        Node leftNodeOfRight = rootNode.left;
        rootNode.left = current;
        current.left = leftNodeOfRight;
        // todo update current
        // todo update new root
    }

    private void rightRotate(Node current) {
        Node rootNode = current.left;
        Node rightNodeOfLeft = rootNode.right;
        rootNode.right = current;
        current.left = rightNodeOfLeft;
        // todo update current
        // todo update new root
    }

    private void leftRightRotate(Node current) {
        // left rotation
        Node leftNode = current.left;
        Node leftRightNode = leftNode.right;
        current.left = leftRightNode;
        leftRightNode.left = leftNode;

        // right rotation
        rightRotate(current);
        // todo
    }

    private void rightLeftRotate(Node current) {
        // right rotation
        Node rightNode = current.right;
        Node rightLeftNode = rightNode.left;
        current.right = rightLeftNode;
        rightLeftNode.right = rightNode;

        leftRightRotate(current);
    }

    /**
     *
     * @return
     */
    private int calculateHeight() {
            return 0;
    }


    private boolean isLeftRotate(Node current) {
        return false;
    }

    private boolean isRightRotate(Node current) {
        return false;
    }

    private boolean isLeftRightRotate(Node current) {
        return false;
    }

    private boolean isRightLeftRotate(Node current) {
        return false;
    }



    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(6);
        avlTree.insert(4);
        avlTree.insert(3);


        System.out.println();
    }

}
