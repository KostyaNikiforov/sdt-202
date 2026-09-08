package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;

    @SuppressWarnings("unchecked")
    public Queue() {
        items = (T[]) new Object[2];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }

        items[last] = item;
        last = (last + 1) % items.length;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }

        T item = items[first];
        items[first] = null;
        first = (first + 1) % items.length;
        size--;

        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }

        return item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            copy[i] = items[(first + i) % items.length];
        }

        items = copy;
        first = 0;
        last = size;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int i;

            public boolean hasNext() {
                return i < size;
            }

            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return items[(first + i++) % items.length];
            }
        };
    }
}
