import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

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

    private void swap(int i, int j, List<T> list) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> unsortedList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            unsortedList.add(random.nextInt(50000));
        }
        List<Integer> origin = new ArrayList<>(unsortedList);
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        Collection<Integer> sorted = bubbleSort.sort(unsortedList);
        Integer previous = null;
        for (Integer integer : sorted) {
            if (previous == null) {
                previous = integer;
            }
            if (previous.compareTo(integer) > 0) {
                System.out.println("algorithm failure");
                break;
            }
        }
        sorted.forEach(System.out::println);
    }
}
