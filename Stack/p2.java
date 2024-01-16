package Stack;

import java.util.*;

class p2 {

    static boolean areBracketsBalanced(String expr) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }

            if (stack.isEmpty())
                return false;

            char check;

            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check != '(')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check != '{')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check != '[')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        String expr = "([{}]())";

        if (areBracketsBalanced(expr))
            System.out.println("Parentheses are Balanced");
        else
            System.out.println("Parentheses are Not Balanced");
    }
}
