package deque;

public class DequeClient {
    public static void main(String[] args) {
        Deque<Integer> d = new Deque<>();
        System.out.println(d.isEmpty() + " " + d.size());
        d.pushRight(2);
        d.pushLeft(1);
        d.pushRight(3);
        d.pushLeft(0);
        System.out.println(d.popLeft());
        System.out.println(d.popRight());
        System.out.println(d.size() + " " + d.isEmpty());
        for (int x : d) System.out.print(x + " ");
        System.out.println();
        System.out.println(d.popLeft() + " " + d.popRight());
        System.out.println(d.isEmpty() + " " + d.size());
    }
}
