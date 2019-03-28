package queue;

import java.util.AbstractQueue;
import java.util.Iterator;

/**
 * @author Jialun Li on 2019-03-12
 */
public class PriorityQueueArrayImpl<E> extends AbstractQueue<E> {
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
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
