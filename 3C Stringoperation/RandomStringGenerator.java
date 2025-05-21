/*Q9. Write a Java Program for  Creating  a random string of a specified length using user defined 
function generateRandomString( */
import java.util.Random;
import java.util.Scanner;

public class RandomStringGenerator {

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(rand.nextInt(characters.length())));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter desired length of random string: ");
        int length = scanner.nextInt();

        System.out.println("Random String: " + generateRandomString(length));
        scanner.close();
    }
}

