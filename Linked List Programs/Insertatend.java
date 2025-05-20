/*3. Write a Java program to insert the specified element at the end of a linked list.( using
l_listobj.offerLast("Pink")) */
import java.util.*;

public class Insertatend {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");

        // Add element at the end
        list.offerLast("Pink");

        System.out.println("List after inserting at the end:");
        System.out.println(list);
    }
}
