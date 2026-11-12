package DSA;
import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPopFriendly {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push operation - O(n)
    public void push(int value) {

        q2.add(value);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop operation - O(1)
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return q1.remove();
    }

    public int peek() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {

        QueueStackPopFriendly stack =
            new QueueStackPopFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Popped: " + stack.pop());
        System.out.println("Top: " + stack.peek());
    }
}
