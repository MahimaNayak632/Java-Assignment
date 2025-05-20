/*1. Write a Java program to iterate through all elements in a linked list starting at the
specified position ( 2nd) using iterator ( hint : Iterator iteratorobj = listobj.listIterator(1)) */
import java.util.*;

public class Iteratefromsecond {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Yellow");

        // Start iteration from index 1 (2nd position)
        ListIterator<String> itr = list.listIterator(1);

        System.out.println("Iterating from the 2nd element:");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

