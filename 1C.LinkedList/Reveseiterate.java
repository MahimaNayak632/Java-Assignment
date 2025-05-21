//Write a Java program to iterate a linked list in reverse order (using objlist.descendingIterator())

import java.util.LinkedList;
import java.util.Iterator;

public class Reveseiterate{
    public static void main(String[] args) {
        // Create a LinkedList and add elements
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Orange");

        // Display original list
        System.out.println("Original LinkedList: " + colors);

        // Create a descending iterator
        Iterator<String> reverseIterator = colors.descendingIterator();

        // Iterate in reverse order
        System.out.println("LinkedList in reverse order:");
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }
    }
}
