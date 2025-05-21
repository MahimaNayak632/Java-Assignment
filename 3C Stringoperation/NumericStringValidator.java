/*Q8. Write a Java Program for  Verifying if a string contains only numeric characters using user defined 
function  isNumeric() */
import java.util.Scanner;

public class NumericStringValidator {

    public static boolean isNumeric(String str) {
        return str.matches("\\d+"); // Matches digits only
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isNumeric(input)) {
            System.out.println("The string is numeric.");
        } else {
            System.out.println("The string is not numeric.");
        }
        scanner.close();
    }
}
