
public class CircularDoublyLinkedList {

    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;
    int size = 0;

    // Add first
    void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            Node tail = head.prev;

            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Add last
    void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            Node tail = head.prev;

            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
        size++;
    }

    // Remove first
    void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (size == 1) {
            head = null;
        } else {
            Node tail = head.prev;
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }

    // Remove last
    void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (size == 1) {
            head = null;
        } else {
            Node tail = head.prev;
            Node newTail = tail.prev;

            newTail.next = head;
            head.prev = newTail;
        }
        size--;
    }

    // Search
    boolean search(int value) {
        Node current = head;

        for (int i = 0; i < size; i++) {
            if (current.data == value)
                return true;

            current = current.next;
        }
        return false;
    }

    // Remove a value
    void remove(int value) {
        Node current = head;

        for (int i = 0; i < size; i++) {
            if (current.data == value) {
                if (current == head) {
                    removeFirst();
                } else if (current == head.prev) {
                    removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                return;
            }
            current = current.next;
        }

        System.out.println("Value not found");
    }

    // Display forward
    void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;

        for (int i = 0; i < size; i++) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Display backward
    void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head.prev;

        for (int i = 0; i < size; i++) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        CircularDoublyLinkedList list =
                new CircularDoublyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);

        System.out.print("Forward: ");
        list.displayForward();

        System.out.print("Backward: ");
        list.displayBackward();

        System.out.println("Search 20: " + list.search(20));

        list.remove(20);
        list.removeFirst();
        list.removeLast();

        System.out.print("After removals: ");
        list.displayForward();

        System.out.println("Size: " + list.size);
    }
}

