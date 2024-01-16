package Miscellaneous;

public class p1 {
    public static String reverseSentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence; // Return unchanged if the sentence is null or empty
        }

        String[] words = sentence.split("\\s+"); // Split the sentence into words
        StringBuilder reversedSentence = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]).append(" ");
        }

        // Remove the trailing space before returning the reversed sentence
        return reversedSentence.toString().trim();
    }

    public static void main(String[] args) {
        String originalSentence = "Hello world";
        String reversedSentence = reverseSentence(originalSentence);

        System.out.println("Original Sentence: " + originalSentence);
        System.out.println("Reversed Sentence: " + reversedSentence);
    }
}
