import java.util.Collection;
import java.util.List;

/**
 * 直接插入排序
 * 改进1: 因为前面的是有序的，所以可以用使用二分法插入数据。在数据量小的时候，比较两个数据大小的次数可能比之前还要多，但是一旦数据多了，就
 * 能使次数明显降低
 */
public class InsertSort<T extends Comparable<T>> implements AbstractSortAlgorithm<T> {
    @Override
    public Collection<T> sort(Collection<T> collection) {
        List<T> list = init(collection);
        for (int i = 1; i < list.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j + 1).compareTo(list.get(j)) < 0) {
                    swap(j, j + 1, list);
                } else {
                    break;
                }
            }
        }
        return list;
    }

    @Override
    public Collection<T> sortWithImprovedMethod(Collection<T> collection) {
        List<T> list = init(collection);
        for (int i = 1; i < list.size(); i++) {
            biSectionInsert(i - 1, i, list);
        }
        return list;
    }

    // TODO
    private void biSectionInsert(int endIndex, int currentIndex, List<T> list) {
        int middleIndex = endIndex / 2;
//        while ()
        if (middleIndex - 1 != -1 && list.get(middleIndex - 1).compareTo(list.get(currentIndex)) < 0) {
        }
    }

    private void shiftFrom(int fromIndex, int endIndex, List<T> list) {
        T temp = list.get(fromIndex);
        for (int i = fromIndex; i < endIndex; i++) {
            T temp2 = list.get(i + 1);
            list.set(i + 1, temp);
            temp = temp2;
        }
    }

    @Override
    public AbstractSortAlgorithm<T> getAlgorithm() {
        return new InsertSort<>();
    }

    public static void main(String[] args) {
        InsertSort<Integer> insertSort = new InsertSort<>();
        insertSort.test(10, 100);
    }
}
