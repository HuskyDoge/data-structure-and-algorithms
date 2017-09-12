import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 *
 */
public interface AbstractSortAlgorithm<T extends Comparable<T>> extends SortAlgorithm<T> {
    AbstractSortAlgorithm<T> getAlgorithm();

    default List<T> init(Collection<T> collection) {
        if (collection instanceof List) {
            return (List<T>) collection;
        }
        return new ArrayList<>();
    }

    default void swap(int i, int j, List<T> list) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }

    default void test(int size, int randomRange) {
        Random random = new Random();
        List<Integer> unsortedList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            unsortedList.add(random.nextInt(randomRange));
        }
        List<Integer> origin = new ArrayList<>(unsortedList);
        SortAlgorithm sortAlgorithm = getAlgorithm();
        Collection<Integer> sorted = sortAlgorithm.sort(unsortedList);
        Integer previous = null;
        for (Integer integer : sorted) {
            if (previous == null) {
                previous = integer;
            }
            if (previous.compareTo(integer) > 0) {
                System.err.println("algorithm failure");
                break;
            }
        }
        sorted.forEach(System.out::println);
    }
}
