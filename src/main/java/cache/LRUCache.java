package cache;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * LRUCache implementation with BiLinkedList and HashMap
 *
 * @author Jialun Li on 2019-03-12
 */
public class LRUCache<K, V> {
    private ListNode first;
    private ListNode last;
    private int capacity;
    private int size;
    private Map<K, ListNode> map;

    private class ListNode {
        K key;
        V val;
        ListNode next;
        ListNode prev;

        ListNode(K key, V val, ListNode next, ListNode prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        void setNext(ListNode next) {
            this.next = next;
            if (next != null) {
                next.prev = this;
            }
        }
    }

    // 删除任意一个Node
    private void remove(ListNode node) {
        if (node == null) {
            throw new IllegalArgumentException();
        }
        if (first == node) {
            first = first.next;
            if (node == last) {
                last = null;
            }
        } else if (last == node) {
            node.prev.setNext(null);
            last = node.prev;
        } else {
            node.prev.setNext(node.next);
        }
    }

    private void addFirst(ListNode node) {
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.setNext(first);
            first = node;
        }
    }

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public V get(K key) {
        ListNode value = map.get(key);
        if (value != null) {
            remove(value);
            addFirst(value);
            return value.val;
        }
        return null;
    }

    public void put(K key, V value) {
        size++;
        ListNode existNode = map.remove(key);
        if (existNode != null) {
            remove(existNode);
            size--;
        } else if (size > capacity) {
            map.remove(last.key);
            remove(last);
            size--;
        }
        ListNode newNode = new ListNode(key, value, null, null);
        addFirst(newNode);
        map.put(key, first);
    }

    public void remove(K key) {
        ListNode removed = map.remove(key);
        if (removed != null) {
            remove(removed);
        }
    }

    @Override
    public String toString() {
        ListNode current = first;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.key).append("|").append(current.val).append("-->");
            current = current.next;
        }
        return sb.toString();
    }
}
