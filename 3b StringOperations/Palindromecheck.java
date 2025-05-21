/*Q4. Write a Java Program for Checking if a string reads the same backward as forward (ignoring case 
and punctuation) using user defined function isPalindrome(): */

import java.util.Scanner;
public class Palindromecheck {

    // User-defined function to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        // Remove all non-alphanumeric characters and convert to lowercase
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // Reverse the cleaned string
        String reversed = new StringBuilder(cleaned).reverse().toString();
        // Compare cleaned and reversed strings
        return cleaned.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Check and display result
        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        scanner.close();
    }
}
