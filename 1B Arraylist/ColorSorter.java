//3. Write a java program for getting different colors through ArrayList interface and sort them using Collections.sort( ArrayListObj)

    import java.util.ArrayList;
import java.util.Collections;

public class ColorSorter {
    public static void main(String[] args) {
        // Create an ArrayList of colors
        ArrayList<String> colors = new ArrayList<>();

        // Add different color names to the list
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Orange");
        colors.add("Purple");

        // Display the original list
        System.out.println("Original list of colors:");
        for (String color : colors) {
            System.out.println(color);
        }

        // Sort the ArrayList
        Collections.sort(colors);

        // Display the sorted list
        System.out.println("\nSorted list of colors:");
        for (String color : colors) {
            System.out.println(color);
        }
    }
}

    
    

