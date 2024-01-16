package Stack;

import java.util.Stack;

public class p3 {
    public static String infixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infixExpression.toCharArray()) {
            if (isOperand(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop remaining operators from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static boolean isOperand(char c) {
        return Character.isLetterOrDigit(c);
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        String infixExpression = "a+b*c-(d/e+f*g*h)";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}
