package data_structures.linked_lists.Singly_Linked_List;

/**
 * A simple implementation of a singly linked list.
 */
public class SingleLinkedList<E> {
    /**
     * Node class represents each element in the linked list.
     */
    private static class Node<E> {
        E data;      // Value stored in the node
        Node<E> next; // Reference to the next node

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head; // Reference to the first node in the list
    private int size;     // Track the number of elements

    /**
     * Adds a new element to the end of the linked list.
     * @param data the value to add
     */
    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    /**
     * Adds a new element to the beginning of the list.
     * @param data the value to add
     */
    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
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
        size--;
        return data;
    }

    /**
     * Checks if the list contains the specified element.
     * @param data the element to search for
     * @return true if the element is found, false otherwise
     */
    public boolean contains(E data) {
        Node<E> curr = head;
        while (curr != null) {
            if (curr.data.equals(data)) {
                return true;
            }
            curr = curr.next;
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
        Node<E> curr = head;
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null) {
                sb.append(", ");
            }
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}