package data_structures.linked_lists.single_linked_list;

/**
 * Demonstrates usage of the SingleLinkedList class.
 * 
 * Features:
 * - Adds elements to the linked list
 * - Prints all elements in order
 */
public class Main {
    /**
     * Main method to test SingleLinkedList functionality.
     * Adds three integers and prints the list.
     */
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.add(10);   // Add first element
        list.add(20);   // Add second element
        list.add(30);   // Add third element
        System.out.print("Linked List contents: ");
        list.printList(); // Output: 10 20 30
    }
}