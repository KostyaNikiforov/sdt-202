package shell;

public class Shell {
    private static final int[] INCREMENTS = {
            1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161
    };

    public static void sort(Comparable[] array) {
        int n = array.length;
        int start = 0;
        while (start + 1 < INCREMENTS.length && INCREMENTS[start] < n / 3) {
            start++;
        }

        for (int k = start; k >= 0; k--) {
            int h = INCREMENTS[k];
            for (int i = h; i < n; i++) {
                for (
                    int j = i;
                    j >= h && less(array[j], array[j - h]);
                    j -= h
                ) {
                    exch(array, j, j - h);
                }
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
