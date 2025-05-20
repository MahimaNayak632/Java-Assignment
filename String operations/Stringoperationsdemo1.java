/*2 a. Develop a java program for performing various string operations with different string
handling functions directed as follows
String Creation and Basic Operations, Length and Character Access, String Comparison, String
Searching, Substring Operations , String Modification, Whitespace Handling, String
Concatenation, String Splitting, StringBuilder Demo, String Formatting , Validate Email with
contains( ) and startsWith() and endsWith() */
import java.util.*;

public class Stringoperationsdemo1 {
    public static void main(String[] args) {
        // String Creation and Basic Operations
        String str1 = "Hello";
        String str2 = "World";
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        // Length and Character Access
        System.out.println("Length of str1: " + str1.length());
        System.out.println("Character at index 1 in str1: " + str1.charAt(1));

        // String Comparison
        String str3 = "hello";
        System.out.println("str1 equals str3 (case-sensitive): " + str1.equals(str3));
        System.out.println("str1 equals str3 (ignore case): " + str1.equalsIgnoreCase(str3));

        // String Searching
        String str4 = "This is a Java programming demo.";
        System.out.println("Index of 'Java' in str4: " + str4.indexOf("Java"));
        System.out.println("Contains 'demo': " + str4.contains("demo"));

        // Substring Operations
        System.out.println("Substring of str4 (10 to 14): " + str4.substring(10, 14));

        // String Modification
        String modified = str4.replace("Java", "Python");
        System.out.println("Modified string: " + modified);

        // Whitespace Handling
        String withSpaces = "   trimmed string   ";
        System.out.println("Original with spaces: '" + withSpaces + "'");
        System.out.println("After trim: '" + withSpaces.trim() + "'");

        // String Concatenation
        String concat = str1 + " " + str2;
        System.out.println("Concatenated string: " + concat);

        // String Splitting
        String csv = "apple,banana,grape,mango";
        String[] fruits = csv.split(",");
        System.out.println("Fruits from CSV:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // StringBuilder Demo
        StringBuilder sb = new StringBuilder("Welcome");
        sb.append(" to Java");
        sb.insert(0, "Hi! ");
        sb.replace(4, 11, "Hello");
        System.out.println("StringBuilder result: " + sb.toString());

        // String Formatting
        String name = "Alice";
        int age = 25;
        System.out.println(String.format("Name: %s, Age: %d", name, age));

        // Validate Email with contains(), startsWith(), endsWith()
        String email = "alice@example.com";
        System.out.println("Email to validate: " + email);

        boolean validEmail = email.contains("@") &&
                             email.contains(".") &&
                             email.endsWith(".com") &&
                             !email.startsWith("@");

        if (validEmail) {
            System.out.println("Valid email format");
        } else {
            System.out.println("Invalid email format");
        }
    }
}
