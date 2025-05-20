/*5. Write a java program for getting different colors through ArrayList interface and delete nth element from the ArrayList object by using remove by index*/
import java.util.*;
public class Deletenthelement {
       public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("Orange");
        ls.add("Green");
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        System.out.println("Original list: " + ls);

        int n = 3; // Remove the 3rd element (index 2)
        if (n > 0 && n <= ls.size()) {
            String removed = ls.remove(n - 1); // Convert to 0-based index
            System.out.println("Removed element at position " + n + ": " + removed);
        } else {
            System.out.println("Invalid position. Cannot remove.");
        }

        System.out.println("Updated list: " + ls);
    }
}

