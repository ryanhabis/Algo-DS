package data_structures.linked_lists.Doubly_Linked_List;

/**
 * A simple implementation of a doubly linked list for integers.
 * 
 * Features:
 * - Add elements to the end of the list
 * - Print all elements in order
 */
public class DoubleLinkedList {
    /**
     * Node class represents each element in the doubly linked list.
     */
    private static class Node {
        int data;      // Value stored in the node
        Node next;     // Reference to the next node
        Node prev;     // Reference to the previous node

        /**
         * Constructs a node with the given data.
         * @param data the integer value to store
         */
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head; // Reference to the first node in the list
    private Node tail; // Reference to the last node in the list

    /**
     * Adds a new element to the end of the doubly linked list.
     * @param data the integer value to add
     */
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // If the list is empty, set head and tail to the new node
            head = newNode;
            tail = newNode;
            return;
        }
        // Link the new node at the end
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    /**
     * Prints all elements in the doubly linked list in order.
     */
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}