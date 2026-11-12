package DSA;

public class UnboundedArrayStack {

    private int[] array;
    private int size;
    private int capacity;

    public UnboundedArrayStack() {
        capacity = 2;
        array = new int[capacity];
        size = 0;
    }

    // Resize array
    private void resize(int newCapacity) {

        int[] newArray = new int[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
        capacity = newCapacity;
    }

    // Push operation
    public void push(int value) {

        if (size == capacity) {
            resize(capacity * 2);
        }

        array[size] = value;
        size++;

        System.out.println(value + " pushed");
    }

    // Pop operation
    public int pop() {

        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        int removed = array[size - 1];
        size--;

        if (size <= capacity / 4 && capacity > 2) {
            resize(Math.max(2, capacity / 2));
        }

        return removed;
    }

    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public static void main(String[] args) {

        UnboundedArrayStack stack =
            new UnboundedArrayStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Capacity: " +
            stack.getCapacity());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        System.out.println("Capacity after pop: " +
            stack.getCapacity());

        System.out.println("Top: " + stack.peek());
    }
}

