package Queue;

import java.util.LinkedList;

public class MyDeque<T> {
    private LinkedList<T> deque;

    public MyDeque() {
        deque = new LinkedList<>();
    }

    // Add element at the front of the deque
    public void addFront(T item) {
        deque.addFirst(item);
    }

    // Add element at the end of the deque
    public void addRear(T item) {
        deque.addLast(item);
    }

    // Remove and return the element from the front of the deque
    public T removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return deque.removeFirst();
    }

    // Remove and return the element from the end of the deque
    public T removeRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return deque.removeLast();
    }

    // Get the size of the deque
    public int size() {
        return deque.size();
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    // Peek the element at the front of the deque without removing it
    public T peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return deque.getFirst();
    }

    // Peek the element at the end of the deque without removing it
    public T peekRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return deque.getLast();
    }

    // Display the elements of the deque
    public void display() {
        System.out.println("Deque elements: " + deque);
    }

    public static void main(String[] args) {
        MyDeque<Integer> myDeque = new MyDeque<>();

        myDeque.addFront(1);
        myDeque.addFront(2);
        myDeque.addRear(3);

        myDeque.display(); // Output: Deque elements: [2, 1, 3]

        System.out.println("Removed from front: " + myDeque.removeFront()); // Output: Removed from front: 2

        myDeque.display(); // Output: Deque elements: [1, 3]

        System.out.println("Removed from rear: " + myDeque.removeRear()); // Output: Removed from rear: 3

        myDeque.display(); // Output: Deque elements: [1]
    }
}
