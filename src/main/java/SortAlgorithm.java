import java.io.Serializable;
import java.util.Collection;

/**
 *
 */
public interface SortAlgorithm<T extends Comparable<T>> {
    Collection<T> sort(Collection<T> collection);
}
