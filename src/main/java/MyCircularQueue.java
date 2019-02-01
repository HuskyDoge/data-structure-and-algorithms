public class MyCircularQueue {
    private int head;
    private int tail;
    private int[] list;
    private int k;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.list = new int[k];
        this.k = k;
        this.head = 0;
        this.tail = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        tail++;
        if (tail == list.length) {
            tail = 0;
        }
        list[tail] = value;
        k--;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head++;
        if (head == list.length) {
            head = 0;
        }
        k++;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) return -1;
        return list[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) return -1;
        return list[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return k == list.length;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return k == 0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */