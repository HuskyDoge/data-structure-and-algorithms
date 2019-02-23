package trie;

import java.util.List;

/**
 * @author Jialun Li on 2019-02-22
 */
public interface Trie {
    void insert(String s);
    boolean search(String target);
    boolean hasStartsWith(String prefix);
    List<String> getStartsWith(String prefix);
    boolean isEmpty();
    int size();
}
