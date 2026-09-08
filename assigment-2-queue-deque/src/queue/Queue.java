package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {
    private T[] a;
    private int n;
    private int first;
    private int last;

    @SuppressWarnings("unchecked")
    public Queue() {
        a = (T[]) new Object[2];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(T item) {
        if (n == a.length) {
            resize(a.length * 2);
        }

        a[last] = item;
        last = (last + 1) % a.length;
        n++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }

        T item = a[first];
        a[first] = null;
        first = (first + 1) % a.length;
        n--;

        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }

        return item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];

        for (int i = 0; i < n; i++) {
            copy[i] = a[(first + i) % a.length];
        }

        a = copy;
        first = 0;
        last = n;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int i;

            public boolean hasNext() {
                return i < n;
            }

            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return a[(first + i++) % a.length];
            }
        };
    }
}
