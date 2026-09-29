package shell;

public class ShellClient {
    public static void main(String[] args) {
        String[] letters = "S H E L L S O R T R O C K S".split(" ");
        sortAndPrint(letters);

        String[] words = {"shell", "sort", "array", "increment", "knuth"};
        sortAndPrint(words);

        Integer[] nums = {9, 0, 3, 4, 5, 8, 7, 2, 1, 6};
        sortAndPrint(nums);
    }

    private static void sortAndPrint(Comparable[] a) {
        System.out.print("before: ");
        show(a);
        Shell.sort(a);
        System.out.print("after:  ");
        show(a);
        System.out.println(isSorted(a) ? "sorted" : "NOT sorted");
        System.out.println();
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) < 0) return false;
        }
        return true;
    }
}
