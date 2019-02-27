package tree;

/**
 * @author Jialun Li on 2019-02-26
 * Binary Search Tree implementation
 *
 */
public interface BST<T> {
    // insert a T into the BST
    void insert(T t);

    boolean remove(T t);

    boolean contains(T t);

    void traverse();

    int size();

    void clear();
}
