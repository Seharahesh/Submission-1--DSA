
public class LinkedListStack {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node top = null;
    int size = 0;

    // Check empty
    boolean isEmpty() {
        return top == null;
    }

    // Get size
    int size() {
        return size;
    }

    // Push
    void push(int value) {
        Node newNode = new Node(value);

        newNode.next = top;
        top = newNode;

        size++;
    }

    // Pop
    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        int value = top.data;
        top = top.next;

        size--;
        return value;
    }

    // Peek
    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return top.data;
    }

    // Display
    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        Node current = top;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.print("Stack: ");
        stack.display();

        System.out.println("Peek: " + stack.peek());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        System.out.print("Stack now: ");
        stack.display();

        System.out.println("Size: " + stack.size());
    }
}

