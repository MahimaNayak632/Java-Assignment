/*3a. Develop a java program for performing various string operations with different string
handling functions directed as follows:
String Creation and Basic Operations, Length and Character Access, String Comparison, String
Searching, Substring Operations , String Modification, Whitespace Handling, String Concatenation,
String Splitting, StringBuilder Demo, String Formatting , Validate Email with contains( ) and
startsWith() and endsWith() */
public class StringOperations {
    public static void main(String[] args) {

        // 1. String Creation and Basic Operations
        String str1 = "Hello";
        String str2 = "World";
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        // 2. Length and Character Access
        System.out.println("Length of str1: " + str1.length());
        System.out.println("Character at index 1 in str1: " + str1.charAt(1));

        // 3. String Comparison
        String str3 = "hello";
        System.out.println("str1 equals str3: " + str1.equals(str3)); // false
        System.out.println("str1 equalsIgnoreCase str3: " + str1.equalsIgnoreCase(str3)); // true

        // 4. String Searching
        String str4 = "This is a Java string handling example.";
        System.out.println("Index of 'Java': " + str4.indexOf("Java"));
        System.out.println("Contains 'handling'? " + str4.contains("handling"));

        // 5. Substring Operations
        System.out.println("Substring (10 to 14): " + str4.substring(10, 14));

        // 6. String Modification
        String modified = str4.replace("Java", "Python");
        System.out.println("Modified string: " + modified);

        // 7. Whitespace Handling
        String withSpaces = "   Hello AIET   ";
        System.out.println("Before trim: '" + withSpaces + "'");
        System.out.println("After trim: '" + withSpaces.trim() + "'");

        // 8. String Concatenation
        String concat = str1 + " " + str2;
        System.out.println("Concatenated string: " + concat);

        // 9. String Splitting
        String csv = "apple,banana,grape,mango";
        String[] fruits = csv.split(",");
        System.out.println("Splitted fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 10. StringBuilder Demo
        StringBuilder sb = new StringBuilder("Welcome");
        sb.append(" to Java");
        sb.insert(0, "Hi! ");
        sb.replace(4, 11, "Hello");
        System.out.println("StringBuilder result: " + sb.toString());

        // 11. String Formatting
        String name = "Alice";
        int age = 22;
        String formatted = String.format("Name: %s, Age: %d", name, age);
        System.out.println("Formatted string: " + formatted);

        // 12. Email Validation using contains(), startsWith(), endsWith()
        String email = "student@aiet.edu.in";
        boolean isValid = email.contains("@") &&
                          email.startsWith("student") &&
                          email.endsWith(".edu.in");

        System.out.println("Email: " + email);
        System.out.println("Is valid email? " + isValid);
    }
}
