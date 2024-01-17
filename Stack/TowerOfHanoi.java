package Stack;

import java.util.Stack;

class TowerOfHanoi {
    static final int NUM_PEGS = 3;

    public static void towerOfHanoi(int numRings) {
        Stack<Integer>[] pegs = new Stack[NUM_PEGS];
        for (int i = 0; i < NUM_PEGS; i++) {
            pegs[i] = new Stack<>();
        }

        // Initialize the source peg with rings
        for (int i = numRings; i >= 1; i--) {
            pegs[0].push(i);
        }

        printPegs(pegs);

        // Perform Tower of Hanoi using stacks
        towerOfHanoiIterative(numRings, pegs, 0, 1, 2);

        System.out.println("Tower of Hanoi completed!");
    }

    private static void towerOfHanoiIterative(int numRings, Stack<Integer>[] pegs, int source, int target,
            int auxiliary) {
        int numMoves = (int) Math.pow(2, numRings) - 1;

        // Determine the direction of the legal move
        int direction = (numRings % 2 == 0) ? 1 : -1;

        for (int move = 1; move <= numMoves; move++) {
            // Determine the source and target peg indices based on the move number
            int sourcePeg = (move & move - 1) % NUM_PEGS;
            int targetPeg = ((move | move - 1) + 1) % NUM_PEGS;

            // Make a legal move
            if (move % 2 == 1) {
                moveRing(pegs, sourcePeg, targetPeg);
            } else {
                moveRing(pegs, targetPeg, sourcePeg);
                moveRing(pegs, sourcePeg, targetPeg);
                moveRing(pegs, sourcePeg, targetPeg);
            }

            printPegs(pegs);
        }
    }

    private static void moveRing(Stack<Integer>[] pegs, int sourcePeg, int targetPeg) {
        if (!pegs[sourcePeg].isEmpty()
                && (pegs[targetPeg].isEmpty() || pegs[sourcePeg].peek() < pegs[targetPeg].peek())) {
            int ring = pegs[sourcePeg].pop();
            pegs[targetPeg].push(ring);
        }
    }

    private static void printPegs(Stack<Integer>[] pegs) {
        System.out.println("Current state of the pegs:");

        for (int i = 0; i < NUM_PEGS; i++) {
            System.out.print("Peg " + (i + 1) + ": ");
            if (!pegs[i].isEmpty()) {
                for (int ring : pegs[i]) {
                    System.out.print(ring + " ");
                }
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int numRings = 3;
        towerOfHanoi(numRings);
    }
}
