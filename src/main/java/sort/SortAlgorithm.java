package sort;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 */
public interface SortAlgorithm<T extends Comparable<T>> {
    Collection<T> sort(Collection<T> collection);

    default Collection<T> sortWithImprovedMethod(Collection<T> collection) {
        return null;
    }
}
