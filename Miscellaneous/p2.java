package Miscellaneous;

public class p2 {
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false; // Null strings are not palindromes
        }

        str = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""); // Ignore case and non-alphanumeric characters

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Characters at the current positions don't match
            }
            left++;
            right--;
        }

        return true; // The string is a palindrome
    }

    public static void main(String[] args) {
        String palindromeStr = "A man, a plan, a canal, Panama";
        boolean isPalindrome = isPalindrome(palindromeStr);

        System.out.println("String: " + palindromeStr);
        System.out.println("Is Palindrome? " + isPalindrome);
    }
}
