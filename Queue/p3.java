package Queue;

public class p3 {
    private int[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public p3(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % capacity;
        array[rear] = element;
        size++;

        System.out.println("Enqueued: " + element);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }

        int removedElement = array[front];
        front = (front + 1) % capacity;
        size--;

        System.out.println("Dequeued: " + removedElement);
        return removedElement;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }

        return array[front];
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        p3 circularQueue = new p3(5);

        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);

        System.out.println("Queue size: " + circularQueue.size());

        System.out.println("Front element: " + circularQueue.peek());

        circularQueue.dequeue();
        circularQueue.dequeue();

        circularQueue.enqueue(5);
        circularQueue.enqueue(6);

        System.out.println("Queue size: " + circularQueue.size());
        System.out.println("Queue size: " + circularQueue);
    }
}
