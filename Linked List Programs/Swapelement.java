/*5. Write a Java program that swaps two elements ( first and third elements ) in a linked list ( using
Collections.swap(l_list, 0, 2)) */
import java.util.*;
public class Swapelement {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Yellow");

        // Swap elements at index 0 and 2
        Collections.swap(list, 0, 2);

        System.out.println("List after swapping 1st and 3rd elements:");
        System.out.println(list);
    }
}

    

