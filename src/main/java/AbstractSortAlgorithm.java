import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public interface AbstractSortAlgorithm<T extends Comparable<T>> extends SortAlgorithm<T> {
    default List<T> init(Collection<T> collection) {
        if (collection instanceof List) {
            return (List<T>) collection;
        }
        return new ArrayList<>();
    }

}
