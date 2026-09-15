package sort;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

/**
 * Same random arrays for all three sorts.
 * A: wall-clock time. B: key-comparison count (dominant n^2 term).
 */
public class Experiment {
    private static final int[] SIZES = { 1000, 2000, 4000, 8000, 16000 };
    private static final long SEED = 2026;

    public static void main(String[] args) throws Exception {
        double[][] times = new double[3][SIZES.length];
        double[][] comps = new double[3][SIZES.length];

        System.out.println("A. Execution time (ms)");
        System.out.printf(Locale.US, "%8s %12s %12s %12s%n", "n", "Selection", "Insertion", "Bubble");
        for (int i = 0; i < SIZES.length; i++) {
            int[] master = randomArray(SIZES[i], SEED + i);
            times[0][i] = time(master, Sorts::selectionSort);
            times[1][i] = time(master, Sorts::insertionSort);
            times[2][i] = time(master, Sorts::bubbleSort);
            System.out.printf(Locale.US, "%8d %12.2f %12.2f %12.2f%n", SIZES[i], times[0][i], times[1][i], times[2][i]);
        }

        System.out.println();
        System.out.println("B. Key comparisons (dominant operation)");
        System.out.printf(Locale.US, "%8s %14s %14s %14s%n", "n", "Selection", "Insertion", "Bubble");
        for (int i = 0; i < SIZES.length; i++) {
            int[] master = randomArray(SIZES[i], SEED + i);
            comps[0][i] = Sorts.selectionSort(master.clone());
            comps[1][i] = Sorts.insertionSort(master.clone());
            comps[2][i] = Sorts.bubbleSort(master.clone());
            System.out.printf(Locale.US, "%8d %14.0f %14.0f %14.0f%n", SIZES[i], comps[0][i], comps[1][i], comps[2][i]);
        }

        System.out.println();
        System.out.println("Time ratio T(2n)/T(n)  (≈ 4 means quadratic)");
        System.out.printf(Locale.US, "%8s %12s %12s %12s%n", "2n", "Selection", "Insertion", "Bubble");
        for (int i = 1; i < SIZES.length; i++) {
            System.out.printf(Locale.US, "%8d %12.2f %12.2f %12.2f%n",
                    SIZES[i],
                    times[0][i] / times[0][i - 1],
                    times[1][i] / times[1][i - 1],
                    times[2][i] / times[2][i - 1]);
        }

        System.out.println();
        System.out.println("Comparisons / n^2  (constant => Theta(n^2))");
        System.out.printf(Locale.US, "%8s %12s %12s %12s%n", "n", "Selection", "Insertion", "Bubble");
        for (int i = 0; i < SIZES.length; i++) {
            double n2 = (double) SIZES[i] * SIZES[i];
            System.out.printf(Locale.US, "%8d %12.3f %12.3f %12.3f%n", SIZES[i], comps[0][i] / n2, comps[1][i] / n2, comps[2][i] / n2);
        }

        System.out.println("Order of growth: all three are quadratic, Theta(n^2).");
        System.out.println("Most efficient: Insertion sort (fewest comparisons / lowest time on random arrays).");
        System.out.println("Least efficient: Bubble sort (same ~n^2/2 comparisons as Selection, but many swaps).");
    }

    private static int[] randomArray(int n, long seed) {
        Random rng = new Random(seed);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = rng.nextInt();
        return a;
    }

    private static double time(int[] master, Sorter sorter) {
        int[] a = Arrays.copyOf(master, master.length);
        long t0 = System.nanoTime();
        sorter.sort(a);
        return (System.nanoTime() - t0) / 1_000_000.0;
    }

    @FunctionalInterface
    private interface Sorter {
        long sort(int[] a);
    }
}
