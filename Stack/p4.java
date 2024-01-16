package Stack;

import java.util.Stack;

public class p4 {
    public static int evaluatePostfix(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();

        for (char c : postfixExpression.toCharArray()) {
            if (Character.isDigit(c)) {
                // If the character is a digit, push it onto the stack
                stack.push(Character.getNumericValue(c));
            } else {
                // If the character is an operator, pop two operands and perform the operation
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    // Add more operators as needed

                    default:
                        throw new IllegalArgumentException("Invalid postfix expression");
                }
            }
        }

        // The final result should be on the top of the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "23*5+";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
        System.out.println("Result: " + result);
    }
}
