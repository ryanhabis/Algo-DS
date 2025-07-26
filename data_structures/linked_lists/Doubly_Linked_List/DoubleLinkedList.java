package data_structures.linked_lists.Doubly_Linked_List;

/**
 * A generic implementation of a doubly linked list.
 * 
 * Features:
 * - Add elements to both ends of the list
 * - Remove elements from both ends
 * - Search for elements
 * - Print elements in both directions
 */
public class DoubleLinkedList<E> {
    /**
     * Node class represents each element in the doubly linked list.
     */
    private static class Node<E> {
        E data;        // Value stored in the node
        Node<E> next;  // Reference to the next node
        Node<E> prev;   // Reference to the previous node

        /**
         * Constructs a node with the given data.
         * @param data the value to store
         */
        Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<E> head; // Reference to the first node in the list
    private Node<E> tail; // Reference to the last node in the list
    private int size;     // Number of elements in the list

    /**
     * Adds a new element to the front of the list.
     * @param data the value to add
     */
    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Adds a new element to the end of the list.
     * @param data the value to add
     */
    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element
     * @throws IllegalStateException if the list is empty
     */
    public E removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        E data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    /**
     * Removes and returns the last element of the list.
     * @return the removed element
     * @throws IllegalStateException if the list is empty
     */
    public E removeLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        E data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return data;
    }

    /**
     * Checks if the list contains the specified element.
     * @param data the element to search for
     * @return true if the element is found, false otherwise
     */
    public boolean contains(E data) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Returns the number of elements in the list.
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of the list in forward order.
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Returns a string representation of the list in reverse order.
     * @return the string representation in reverse
     */
    public String toStringReverse() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = tail;
        while (current != null) {
            sb.append(current.data);
            if (current.prev != null) {
                sb.append(", ");
            }
            current = current.prev;
        }
        sb.append("]");
        return sb.toString();
    }
}