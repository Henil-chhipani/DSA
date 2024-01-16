package Stack;

import java.util.*;

/**
 * p1
 */
public class p1 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);

        System.out.println(stack);
        stack.pop();

        System.out.println(stack);
    }
}