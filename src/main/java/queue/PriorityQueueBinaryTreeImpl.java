package queue;

import java.util.AbstractQueue;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author Jialun Li on 2019-03-11
 */
public class PriorityQueueBinaryTreeImpl<E> extends AbstractQueue<E> {
    private int size;
    private final Comparator<? super E> comparator;

    public PriorityQueueBinaryTreeImpl() {
        this.comparator = null;
    }

    public PriorityQueueBinaryTreeImpl(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
