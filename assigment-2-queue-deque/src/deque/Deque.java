package deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {
    private Node<T> left;
    private Node<T> right;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void pushLeft(T item) {
        Node<T> node = new Node<>();
        node.item = item;
        node.next = left;

        if (left == null) {
            right = node;
        } else {
            left.prev = node;
        }

        left = node;
        size++;
    }

    public void pushRight(T item) {
        Node<T> node = new Node<>();
        node.item = item;
        node.prev = right;

        if (right == null) {
            left = node;
        } else {
            right.next = node;
        }

        right = node;
        size++;
    }

    public T popLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("deque is empty");
        }

        T item = left.item;
        left = left.next;
        size--;

        if (left == null) {
            right = null;
        } else {
            left.prev = null;
        }
        return item;
    }

    public T popRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("deque is empty");
        }

        T item = right.item;
        right = right.prev;
        size--;

        if (right == null) {
            left = null;
        } else {
            right.next = null;
        }
        return item;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = left;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    private static class Node<T> {
        T item;
        Node<T> prev;
        Node<T> next;
    }
}
