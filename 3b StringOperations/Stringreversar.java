/* Q3. Write a Java Program for  Reversing the characters in a string using user defined function 
reverseString()*/
public class Stringreversar {
   
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "Hello World";
        System.out.println("Reversed: " + reverseString(input));
    }
}

    

