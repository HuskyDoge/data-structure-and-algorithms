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
        if (i != j) {
            T t = list.get(i);
            list.set(i, list.get(j));
            list.set(j, t);
        }
    }

    default void test(int size, int randomRange, boolean improved) {
        Random random = new Random();
        List<Integer> unsortedList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            unsortedList.add(random.nextInt(randomRange));
        }
        List<Integer> origin = new ArrayList<>(unsortedList);
        SortAlgorithm sortAlgorithm = getAlgorithm();
        Collection<Integer> sorted = null;
        if (improved) {
            sorted = sortAlgorithm.sortWithImprovedMethod(unsortedList);
        } else {
            sorted = sortAlgorithm.sort(unsortedList);
        }
        Integer previous = null;
        for (Integer integer : sorted) {
            if (previous == null) {
                previous = integer;
            }
            if (previous.compareTo(integer) > 0) {
                throw new IllegalStateException("algorithm failure");
            }
        }
        System.out.println("algorithm succeed");
//        sorted.forEach(System.out::println);
    }
}
