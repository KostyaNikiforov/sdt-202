package queue;

public class QueueClient {
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        System.out.println(q.isEmpty() + " " + q.size());
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        System.out.println(q.dequeue());
        q.enqueue("d");
        q.enqueue("e");
        System.out.println(q.size() + " " + q.isEmpty());
        for (String s : q) System.out.print(s + " ");
        System.out.println();
        while (!q.isEmpty()) System.out.print(q.dequeue() + " ");
        System.out.println();
        System.out.println(q.isEmpty() + " " + q.size());
    }
}
