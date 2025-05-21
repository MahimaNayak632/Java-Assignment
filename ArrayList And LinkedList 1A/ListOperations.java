/*1.a  Develop a Java program for adding elements   [Apple, Banana, Orange] into an ArrayList
 and a LinkedList to perform the  following operations with different functions directed  as
 follows
 1. Adding elements,   2. Adding element at specific index, 3. Adding multiple elements, 4. 
Accessing elements,5. Updating elements, 6. Removing elements,  7. Searching elements,  8. List 
size, 9. Iterating over list, 10. Using Iterator,  11. Sorting, 12. Sublist, 13. Clearing the list */

import java.util.*;

public class ListOperations {

    // Method 1: Add elements to list
    public static void addElements(List<String> list) {
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
    }

    // Method 2: Add element at specific index
    public static void addElementAtIndex(List<String> list, int index, String element) {
        list.add(index, element);
    }

    // Method 3: Add multiple elements
    public static void addMultipleElements(List<String> list, Collection<String> elements) {
        list.addAll(elements);
    }

    // Method 4: Access element at index
    public static String accessElement(List<String> list, int index) {
        return list.get(index);
    }

    // Method 5: Update element at index
    public static void updateElement(List<String> list, int index, String newElement) {
        list.set(index, newElement);
    }

    // Method 6: Remove element by index or by value
    public static void removeElement(List<String> list, int index) {
        list.remove(index);
    }

    public static void removeElement(List<String> list, String element) {
        list.remove(element);
    }

    // Method 7: Search element in list
    public static boolean searchElement(List<String> list, String element) {
        return list.contains(element);
    }

    // Method 8: Get list size
    public static int getListSize(List<String> list) {
        return list.size();
    }

    // Method 9: Iterate over list using for-each loop
    public static void iterateList(List<String> list) {
        for (String element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Method 10: Iterate using Iterator
    public static void iterateUsingIterator(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    // Method 11: Sort list
    public static void sortList(List<String> list) {
        Collections.sort(list);
    }

    // Method 12: Get sublist
    public static List<String> getSubList(List<String> list, int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    // Method 13: Clear list
    public static void clearList(List<String> list) {
        list.clear();
    }

    public static void main(String[] args) {
        // Using ArrayList
        System.out.println("ArrayList Operations:");
        List<String> arrayList = new ArrayList<>();
        addElements(arrayList);
        System.out.println("After adding elements: " + arrayList);

        addElementAtIndex(arrayList, 1, "Mango");
        System.out.println("After adding 'Mango' at index 1: " + arrayList);

        addMultipleElements(arrayList, Arrays.asList("Grapes", "Pineapple"));
        System.out.println("After adding multiple elements: " + arrayList);

        System.out.println("Access element at index 2: " + accessElement(arrayList, 2));

        updateElement(arrayList, 2, "Watermelon");
        System.out.println("After updating index 2 to 'Watermelon': " + arrayList);

        removeElement(arrayList, 3);
        System.out.println("After removing element at index 3: " + arrayList);

        removeElement(arrayList, "Apple");
        System.out.println("After removing element 'Apple': " + arrayList);

        System.out.println("Is 'Banana' present? " + searchElement(arrayList, "Banana"));

        System.out.println("List size: " + getListSize(arrayList));

        System.out.print("Iterate using for-each: ");
        iterateList(arrayList);

        System.out.print("Iterate using iterator: ");
        iterateUsingIterator(arrayList);

        sortList(arrayList);
        System.out.println("After sorting: " + arrayList);

        System.out.println("Sublist (1 to 3): " + getSubList(arrayList, 1, 3));

        clearList(arrayList);
        System.out.println("After clearing list: " + arrayList);

        System.out.println("\nLinkedList Operations:");
        List<String> linkedList = new LinkedList<>();
        addElements(linkedList);
        System.out.println("After adding elements: " + linkedList);

        addElementAtIndex(linkedList, 1, "Mango");
        System.out.println("After adding 'Mango' at index 1: " + linkedList);

        addMultipleElements(linkedList, Arrays.asList("Grapes", "Pineapple"));
        System.out.println("After adding multiple elements: " + linkedList);

        System.out.println("Access element at index 2: " + accessElement(linkedList, 2));

        updateElement(linkedList, 2, "Watermelon");
        System.out.println("After updating index 2 to 'Watermelon': " + linkedList);

        removeElement(linkedList, 3);
        System.out.println("After removing element at index 3: " + linkedList);

        removeElement(linkedList, "Apple");
        System.out.println("After removing element 'Apple': " + linkedList);

        System.out.println("Is 'Banana' present? " + searchElement(linkedList, "Banana"));

        System.out.println("List size: " + getListSize(linkedList));

        System.out.print("Iterate using for-each: ");
        iterateList(linkedList);

        System.out.print("Iterate using iterator: ");
        iterateUsingIterator(linkedList);

        sortList(linkedList);
        System.out.println("After sorting: " + linkedList);

        System.out.println("Sublist (1 to 3): " + getSubList(linkedList, 1, 3));

        clearList(linkedList);
        System.out.println("After clearing list: " + linkedList);
    }
}
