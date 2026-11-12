package DSA;

import java.util.Stack;

public class StackQueueEnqueueFriendly {

    private Stack<Integer> inputStack = new Stack<>();
    private Stack<Integer> outputStack = new Stack<>();

    // Enqueue operation - O(1)
    public void enqueue(int value) {

        inputStack.push(value);

        System.out.println(value + " enqueued");
    }

    // Move elements when needed
    private void transfer() {

        if (outputStack.isEmpty()) {

            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }

    // Dequeue operation
    public int dequeue() {

        transfer();

        if (outputStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return outputStack.pop();
    }

    public int peek() {

        transfer();

        if (outputStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return outputStack.peek();
    }

    public boolean isEmpty() {
        return inputStack.isEmpty()
            && outputStack.isEmpty();
    }

    public static void main(String[] args) {

        StackQueueEnqueueFriendly queue =
            new StackQueueEnqueueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front: " + queue.peek());
    }
}

