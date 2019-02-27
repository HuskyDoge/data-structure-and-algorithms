package tree;

/**
 * @author Jialun Li on 2019-02-25
 */
public class BinarySearchTree {
    private class Node {
        Integer key;
        Node left, right;
        Node(int key) {
            this.key = key;
        }
    }
    private Node root;
    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int key) {
        this.root = insertNode(root, key);
    }

    private Node insertNode(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertNode(root.left, key);
        } else if (key > root.key) {
            root.right = insertNode(root.right, key);
        }
        return root;
    }

    public void inOrder() {
        inOrderHelper(root);
    }

    private void inOrderHelper(Node root) {
        if (root != null) {
            inOrderHelper(root.left);
            System.out.println(root.key);
            inOrderHelper(root.right);
        }
    }

    public Node search(int key) {
        return searchHelper(root, key);
    }

    private Node searchHelper(Node root, int key) {
        if (root == null || root.key == null) {
            return root;
        }
        if (key < root.key) {
            return searchHelper(root.left, key);
        } else {
            return searchHelper(root.right, key);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.inOrder();
    }

}
