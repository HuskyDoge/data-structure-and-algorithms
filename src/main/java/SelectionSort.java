import java.util.Collection;
import java.util.List;

/**
 *
 */
public class SelectionSort<T extends Comparable<T>> implements AbstractSortAlgorithm<T> {
    @Override
    public AbstractSortAlgorithm<T> getAlgorithm() {
        return new SelectionSort<>();
    }

    @Override
    public Collection<T> sort(Collection<T> collection) {
        List<T> list = init(collection);
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex, list);
        }
        return list;
    }

    public static void main(String[] args) {
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        selectionSort.test(10, 100, false);
        selectionSort.test(100, 1000, false);
        selectionSort.test(10000, 10000, false);
        selectionSort.test(100000, 100000, false);
    }
}
