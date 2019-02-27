package tree;

import java.util.Stack;

/**
 * @author Jialun Li on 2019-02-26
 * HeightAware binary search tree
 */
public class HeightAwareBST implements BST<Integer> {
    private class Node {
        int height;
        Node left, right, parent;
        int key;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }

        Node(int key, Node parent) {
            this.key = key;
            this.height = 1;
            this.parent = parent;
        }

        void setLeft(Node left) {
            this.left = left;
            if (left != null) {
                left.parent = this;
            }
        }

        void setRight(Node right) {
            this.right = right;
            if (right != null) {
                right.parent = this;
            }
        }
    }

    private Node root;
    private int size;

    public HeightAwareBST() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void insert(Integer key) {
        Node node = searchHelper(root, key);
        if (node != null) return;
        if (key != null) {
            if (root == null) {
                this.root = new Node(key);
                size++;
            } else {
                Node current = root;
                Stack<Node> stack = new Stack<>();
                stack.push(current);
                while (!stack.isEmpty()) {
                    Node parent = stack.pop();
                    if (parent.key > key) { // go left
                        if (parent.left == null) {
                            parent.left = new Node(key, parent);
                            updateHeight(parent);
                            size++;
                        } else {
                            stack.push(parent.left);
                        }
                    } else if (parent.key < key) { // go right
                        if (parent.right == null) {
                            parent.right = new Node(key, parent);
                            updateHeight(parent);
                            size++;
                        } else {
                            stack.push(parent.right);
                        }
                    }
                }
                this.root = current;
            }
        }
    }

    // update the Height of the node and all of it's parents
    private void updateHeight(Node node) {
        while (node != null) {
            int leftHeight = node.left == null ? 0 : node.left.height;
            int rightHeight = node.right == null ? 0 : node.right.height;
            node.height = Math.max(leftHeight, rightHeight) + 1;
            node = node.parent;
        }
    }

    @Override
    public boolean contains(Integer key) {
        return searchHelper(root, key) != null;
    }

    private Node searchHelper(Node current, Integer key) {
        if (key == null) return null;
        while (current != null && current.key != key) {
            if (current.key > key) { // go left
                current = current.left;
            } else { // go right
                current = current.right;
            }
        }
        return current;
    }

    @Override
    public boolean remove(Integer key) {
        Node removeNode = searchHelper(this.root, key);
        if (removeNode == null) return false;
        if (removeNode.left == null && removeNode.right == null) { // has no child
            removeLeaf(removeNode);
        } else if (removeNode.left != null && removeNode.right == null) { // has left child only
            removeWithOneLeaf(removeNode, removeNode.left);
        } else if (removeNode.left == null) { // has right child only
            removeWithOneLeaf(removeNode, removeNode.right);
        } else { // has two child
            removeWithTwoLeaf(removeNode);
        }
        size--;
        return true;
    }

    private void removeWithTwoLeaf(Node removeNode) {
        Node successor = findSuccessor(removeNode);
        Node successorParent = successor.parent;
        Node successorRight = successor.right;
        if (removeNode.parent == null) {
            this.root = successor;
            successor.parent = null;
            successor.setLeft(removeNode.left);
            successor.setRight(removeNode == successorParent ? successor.right : removeNode.right);
        } else {
            if (removeNode.key < removeNode.parent.key) {
                removeNode.parent.setLeft(successor);
            } else {
                removeNode.parent.setRight(successor);
            }
            successor.setLeft(removeNode.left);
            successor.setRight(removeNode == successorParent ? successor.right : removeNode.right);
        }
        if (successorParent != removeNode) {
            successorParent.setLeft(successorRight);
        }
        detachNode(removeNode);
        updateHeight(successorParent);
    }

    private void detachNode(Node node) {
        node.parent = null;
        node.setLeft(null);
        node.setRight(null);
    }

    private void removeLeaf(Node current) {
        if (current.parent == null) {
            this.root = null;
        } else {
            if (current.key < current.parent.key) {
                current.parent.left = null;
            } else {
                current.parent.right = null;
            }
            updateHeight(current.parent);
        }
    }

    private void removeWithOneLeaf(Node current, Node successor) {
        if (current.parent == null) {
            this.root = successor;
        } else {
            if (current.key < current.parent.key) {
                current.parent.left = successor;
            } else {
                current.parent.right = successor;
            }
        }
        successor.parent = current.parent;
        updateHeight(current.parent);
    }

    // find the successor of the node
    private Node findSuccessor(Node target) {
        Node successor = null;
        Node current = target;
        while (current != null) {
            if (current.key > target.key) {
                successor = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return successor;
    }

    @Override
    public void traverse() {
        traverseHelper(root);
    }

    private void traverseHelper(Node current) {
        if (current.left != null) {
            traverseHelper(current.left);
        }
        System.out.println("key: " + current.key + " height: " + current.height);
        if (current.right != null) {
            traverseHelper(current.right);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
    }
}
