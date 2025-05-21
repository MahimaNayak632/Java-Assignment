/*4. Write a java program for getting different colors through ArrayList interface and extract the
elements 1st and 2nd from the ArrayList object by using SubList()*/
import java.util.*;
public class Colorsublist{
    public static void main(String args[])
    {
        // Create an ArrayList of Strings to store color names
        List<String> ls = new ArrayList<>();

        // Add colors to the ArrayList
        ls.add("Orange");
        ls.add("Green");  
        ls.add("Pink"); 
        ls.add("Red");   
        ls.add("Blue");

        // Print the original list of colors
        System.out.println("Original list of colors:");
        System.out.println(ls);

        // Extract and print the 1st and 2nd elements using subList()
        System.out.println("Using subList to extract 1st and 2nd elements:");
        System.out.println(ls.subList(0, 2));
    }
}

    
