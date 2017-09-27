import java.util.Collection;
import java.util.List;

/**
 * @author Jialun Li on 27/09/2017
 */
public class QuickSort<T extends Comparable<T>> implements AbstractSortAlgorithm<T> {
    @Override
    public AbstractSortAlgorithm<T> getAlgorithm() {
        return new QuickSort<>();
    }

    @Override
    public Collection<T> sort(Collection<T> collection) {
        List<T> list = init(collection);
        quick_sort_recursive(0, list.size() - 1, list);
        return list;
    }


    private void quick_sort_recursive(int start, int end, List<T> list) {
        if (start >= end) {
            return;
        }
        T mid = list.get(end);
        int left = start;
        int right = end - 1;
        while (left < right) {
            while (list.get(left).compareTo(mid) <= 0 && left < right)
                left++;
            while (list.get(right).compareTo(mid) >= 0 && left < right)
                right--;
            swap(left, right, list);
        }
        if (list.get(left).compareTo(list.get(end)) >= 0) {
            swap(left, end, list);
        } else {
            left++;
        }
        quick_sort_recursive(start, left - 1, list);
        quick_sort_recursive(left + 1, end, list);
    }

    public static void main(String[] args) {
        QuickSort<Integer> sort = new QuickSort<>();
        sort.test(10000000, 1000000, false);
    }
}
