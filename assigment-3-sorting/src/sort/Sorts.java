package sort;

/** Elementary sorts. Each method sorts in place and returns the number of key comparisons. */
public final class Sorts {
    private Sorts() {}

    /** Selection: comparisons a[j] < a[min] in the inner loop. Always n(n-1)/2. */
    public static long selectionSort(int[] a) {
        long comps = 0;
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                comps++;
                if (a[j] < a[min]) min = j;
            }
            swap(a, i, min);
        }
        return comps;
    }

    /** Insertion: comparisons a[j] < a[j-1] in the inner loop. About n^2/4 on random data. */
    public static long insertionSort(int[] a) {
        long comps = 0;
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                comps++;
                if (a[j] >= a[j - 1]) break;
                swap(a, j, j - 1);
            }
        }
        return comps;
    }

    /** Bubble: comparisons a[j] > a[j+1] in the inner loop. Always n(n-1)/2. */
    public static long bubbleSort(int[] a) {
        long comps = 0;
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                comps++;
                if (a[j] > a[j + 1]) swap(a, j, j + 1);
            }
        }
        return comps;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
