public class FibonacciTrace {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        while (b < 20) {
            b = a + b;
            a = b - a;
        }

        System.out.println(a + ", " + b);
    }
}
