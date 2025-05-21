/*2. Write a java program for getting different colors through ArrayList interface and remove the
2nd element and color "Blue" from the ArrayList */
import java.util.*;

public class ColorRemoval {
    public static void main(String[] args) {
        // Create an ArrayList to store color names
        List<String> colors = new ArrayList<>();
        colors.add("Orange");
        colors.add("Green");
        colors.add("Pink");
        colors.add("Red");
        colors.add("Blue");

        // Display the original list of colors
        System.out.println("Original list: " + colors);

        // Remove the 2nd element (index starts from 0, so index 2 is the third element)
        colors.remove(2);
        System.out.println("After removing 2nd element (Pink): " + colors);

        // Remove the color "Blue" from the list
        colors.remove("Blue");
        System.out.println("After removing 'Blue': " + colors);
    }
}
