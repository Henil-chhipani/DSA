package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class p2 {
    public static void reverseFirstKElements(Queue<Integer> queue, int k) {
        if (k <= 0 || k > queue.size()) {
            System.out.println("Invalid value of k");
            return;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        for (int i = 0; i < queue.size() - k; i++) {
            queue.offer(queue.poll());
        }
    }

    public static void printQueue(Queue<Integer> queue) {
        for (int element : queue) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int k = 3;

        for (int i = 1; i <= 5; i++) {
            queue.offer(i);
        }

        System.out.println("Original Queue:");
        printQueue(queue);

        reverseFirstKElements(queue, k);

        System.out.println("Queue after reversing first " + k + " elements:");
        printQueue(queue);
    }
}
