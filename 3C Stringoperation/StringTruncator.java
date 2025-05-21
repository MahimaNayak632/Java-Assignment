/* Q7. Write a Java Program for  Shortening a string to a specified length and adds an ellipsis using user 
defined function truncate() */
import java.util.Scanner;

public class StringTruncator {

    public static String truncate(String str, int maxLength) {
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength) + "...";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Enter max length: ");
        int length = scanner.nextInt();

        System.out.println("Truncated: " + truncate(input, length));
        scanner.close();
    }
}
