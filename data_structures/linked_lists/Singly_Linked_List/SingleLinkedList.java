package data_structures.linked_lists.Singly_Linked_List;
/**
 * A generic implementation of a singly linked list.
 * 
 * Features:
 * - Add elements to the beginning and end of the list
 * - Remove elements from the beginning and end
 * - Search for elements
 * - Print elements in order
 */


public class SingleLinkedList<E> {
    /**
     * Node class represents each element in the linked list.
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SingleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an element to the beginning of the list.
     * @param data the element to add
     */
    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param data the element to add
     */
    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
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
        if (head == null) {
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
        if (head == tail) {
            head = tail = null;
        } else {
            Node<E> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
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
     * Returns a string representation of the list.
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
}