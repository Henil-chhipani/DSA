package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for (int i = 1; i <= n; i++) {
            String current = queue.poll();
            System.out.println(current);

            queue.offer(current + "0");
            queue.offer(current + "1");
        }
    }

    public static void main(String[] args) {
        int n = 10; // Change this value to generate binary numbers up to a different limit
        System.out.println("Binary numbers from 1 to " + n + ":");
        generateBinaryNumbers(n);
    }
}
