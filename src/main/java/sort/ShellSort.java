package sort;

import java.util.Collection;
import java.util.List;

/**
 * Knuth's Formula
 * h = h * 3 + 1 where h is interval with initial value 1
 *
 */
public class ShellSort<T extends Comparable<T>> extends InsertSort<T> {

    @Override
    public AbstractSortAlgorithm<T> getAlgorithm() {
        return new ShellSort<T>();
    }

    @Override
    public Collection<T> sort(Collection<T> collection) {
        List<T> list = init(collection);
        int gap = 1, i, j, len = list.size();
        T temp;
        while (gap < len / 3)
            gap = gap * 3 + 1; // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        for (; gap > 0; gap /= 3)
            for (i = gap; i < len; i++) {
                temp = list.get(i);
                for (j = i - gap; j >= 0 && list.get(j).compareTo(temp) > 0; j -= gap)
                    list.set(j + gap, list.get(j));
                list.set(j + gap, temp);
            }
        return list;
    }

    @Override
    public Collection<T> sortWithImprovedMethod(Collection<T> collection) {
        return sort(collection);
    }

    public static void main(String[] args) {
        ShellSort<Integer> shellSort = new ShellSort<>();
        shellSort.test(13, 100, false);
    }
}
