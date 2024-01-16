package Stack;

public class p5 {
    public static String reverseString(String input) {
        char[] characters = input.toCharArray();
        int length = characters.length;

        // Create a character array to store the reversed string
        char[] reversed = new char[length];
        int index = 0;

        // Use an array-based stack to reverse the string
        char[] stack = new char[length];
        int top = -1;

        // Push each character onto the stack
        for (int i = 0; i < length; i++) {
            stack[++top] = characters[i];
        }

        // Pop characters from the stack to construct the reversed string
        while (top >= 0) {
            reversed[index++] = stack[top--];
        }

        return new String(reversed);
    }

    public static void main(String[] args) {
        String originalString = "Hello, World!";
        String reversedString = reverseString(originalString);

        System.out.println("Original String: " + originalString);
        System.out.println("Reversed String: " + reversedString);
    }
}
