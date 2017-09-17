import java.util.Collection;
import java.util.List;

/**
 * 直接插入排序
 * 改进1: 因为前面的是有序的，所以可以用使用二分法插入数据。在数据量小的时候，比较两个数据大小的次数可能比之前还要多，但是一旦数据多了，就
 * 能使次数明显降低寻路时间
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

    // 二分法插入
    private void biSectionInsert(int endIndex, int currentIndex, List<T> list) {
        int startIndex = 0;
        T temp = list.get(currentIndex);
        int middleIndex = endIndex / 2;
        while (middleIndex != endIndex) {
            if (list.get(middleIndex).compareTo(temp) < 0) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1 < 0 ? 0 : middleIndex - 1;
            }
            middleIndex = (startIndex + endIndex) / 2;
        }
        // 确认需要插入的数据是在Array[middleIndex]的左边或者右边
        if (list.get(middleIndex).compareTo(temp) <= 0) {
            startIndex++;
        }
        shiftFromByOne(startIndex, currentIndex, list);
    }

    // 所有数据往右移一格
    protected void shiftFromByOne(int fromIndex, int endIndex, List<T> list) {
        T temp = list.get(fromIndex);
        list.set(fromIndex, list.get(endIndex));
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
        insertSort.test(100, 100, true);
        insertSort.test(10, 100, false);
    }
}
