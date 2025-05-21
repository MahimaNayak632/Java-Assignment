/*Q5. Write a Java Program for Eliminating all whitespace characters from a string using user defined 
function removeWhitespace() */

import java.util.*;
public class WhitespaceClean {
    // User-defined function to remove all whitespace characters
    public static String removeWhitespace(String str) {
        return str.replaceAll("\\s+", ""); // Removes spaces, tabs, newlines, etc.
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a string
        System.out.print("Enter a string with spaces: ");
        String input = scanner.nextLine();

        // Remove whitespaces using user-defined function
        String result = removeWhitespace(input);

        // Display the result
        System.out.println("String without whitespace: " + result);

        scanner.close();
    }
}

    

