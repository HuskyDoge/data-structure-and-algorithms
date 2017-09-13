import java.util.Collection;
import java.util.List;

/**
 * 冒泡排序
 * 改进1：在某次遍历中如果没有数据交换，说明整个数组已经有序。因此通过设置标志位来记录此次遍历有无数据交换就可以判断是否要继续循环。
 * 改进2：记录某次遍历时最后发生数据交换的位置，这个位置之后的数据显然已经有序了。因此通过记录最后发生数据交换的位置就可以确定下次循环的范围了。
 */
public class BubbleSort<T extends Comparable<T>> implements AbstractSortAlgorithm<T> {
    public Collection<T> sort(Collection<T> collection) {
        List<T> list = init(collection);
        int size = list.size() - 1;
        for (int i = 0; i < size;) {
            Integer swapIndex = null; // 用来记录最后一次swap的index
            for (int j = 0; j < size; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    swap(j, j + 1, list);
                    swapIndex = j;
                }
            }
            if (swapIndex != null) {
                size = swapIndex; // 不需要再比较后面的数字了
            } else {
                return list;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        bubbleSort.test(10, 100, false);
    }

    @Override
    public AbstractSortAlgorithm<T> getAlgorithm() {
        return new BubbleSort<>();
    }
}
