package data_structures.linked_lists.Doubly_Linked_List;

/**
 * Demonstrates usage of the DoublyLinkedList class.
 */
public class Main {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.print("Doubly Linked List contents: ");
        list.printList(); // Output: 10 20 30

    }
}