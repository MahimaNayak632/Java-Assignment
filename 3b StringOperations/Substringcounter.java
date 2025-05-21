/* Q2. Write a Java Program for Counting how many times a substring appears in a main string
 using user defined function countOccurrences()*/
import java.util.Scanner;

public class Substringcounter {
    public static int countOccurrences(String mainStr, String subStr) {
        int count = 0, index = 0;
        while ((index = mainStr.indexOf(subStr, index)) != -1) {
            count++;
            index += subStr.length();
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String main = scanner.nextLine();

        System.out.print("Enter the substring to search: ");
        String sub = scanner.nextLine();

        int occurrences = countOccurrences(main, sub);
        System.out.println("Occurrences of \"" + sub + "\": " + occurrences);

        scanner.close();
    }
}
