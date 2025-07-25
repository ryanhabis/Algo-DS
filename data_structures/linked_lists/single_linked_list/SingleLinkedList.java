package data_structures.linked_lists.single_linked_list;

/**
 * A simple implementation of a singly linked list for integers.
 * 
 * Features:
 * - Add elements to the end of the list
 * - Print all elements in order
 */
public class SingleLinkedList {
    /**
     * Node class represents each element in the linked list.
     */
    private static class Node {
        int data;    // Value stored in the node
        Node next;   // Reference to the next node

        /**
         * Constructs a node with the given data.
         * @param data the integer value to store
         */
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Reference to the first node in the list

    /**
     * Adds a new element to the end of the linked list.
     * @param data the integer value to add
     */
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // If the list is empty, set head to the new node
            head = newNode;
            return;
        }
        // Traverse to the last node
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        // Link the new node at the end
        curr.next = newNode;
    }

    /**
     * Prints all elements in the linked list in order.
     */
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    /**
     * Main method for testing the SingleLinkedList.
     * Demonstrates adding and printing elements.
     */
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.printList(); // Output: 10 20 30
    }
}