package data_structures.arrays.StaticArray;

/**
 * StaticArray.java
 * Implementation of a fixed-size array with basic operations
 */
public class StaticArray<T> {
    private final T[] array;
    private final int capacity;
    private int size;

    /**
     * Constructor to create a StaticArray with given capacity
     * @param capacity The fixed size of the array
     */
    @SuppressWarnings("unchecked")
    public StaticArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * Get the element at specified index
     * @param index The position to retrieve
     * @return The element at the index
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    /**
     * Set the element at specified index
     * @param index The position to set
     * @param element The element to store
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public void set(int index, T element) {
        checkIndex(index);
        array[index] = element;
        if (element != null && index >= size) {
            size = index + 1;
        }
    }

    /**
     * Get the current number of elements (not null values)
     * @return The size of the array
     */
    public int size() {
        return size;
    }

    /**
     * Get the maximum capacity of the array
     * @return The capacity of the array
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Check if the array is empty
     * @return true if array contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Check if the array is full
     * @return true if array has reached capacity
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Fill the array with a default value
     * @param value The value to fill with
     */
    public void fill(T value) {
        for (int i = 0; i < capacity; i++) {
            array[i] = value;
        }
        size = value != null ? capacity : 0;
    }

    /**
     * Convert the array to string representation
     * @return String representation of the array
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Private helper method to validate indices
    private void checkIndex(int index) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Capacity: " + capacity);
        }
    }
}