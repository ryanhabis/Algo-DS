package data_structures.arrays.DynamicArrays;

/**
 * A dynamic array implementation with automatic resizing.
 * 
 * Features:
 * - Generic type support
 * - Automatic resizing (grow/shrink)
 * - Time complexity analysis
 * - Full exception handling
 */
public class DynamicArray<T> {
    // Initial capacity of the array
    private static final int INITIAL_CAPACITY = 10;
    // Factor by which the array grows
    private static final double GROWTH_FACTOR = 1.5;
    // Threshold to shrink the array
    private static final double SHRINK_THRESHOLD = 0.25;
    
    private T[] array;    // Internal array to store elements
    private int size;     // Number of elements in the array
    private int capacity; // Current capacity of the array

    /**
     * Constructs an empty dynamic array with default capacity.
     * Time Complexity: O(1)
     */
    @SuppressWarnings("unchecked")
    public DynamicArray() {
        this.capacity = INITIAL_CAPACITY;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * Constructs an empty dynamic array with specified capacity.
     * Time Complexity: O(1)
     * 
     * @param initialCapacity the initial capacity of the array
     * @throws IllegalArgumentException if initialCapacity is negative
     */
    @SuppressWarnings("unchecked")
    public DynamicArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.capacity = initialCapacity;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * Returns the number of elements in the array.
     * Time Complexity: O(1)
     */
    public int size() {
        return size;
    }

    /**
     * Returns the current capacity of the array.
     * Time Complexity: O(1)
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Checks if the array is empty.
     * Time Complexity: O(1)
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the element at the specified index.
     * Time Complexity: O(1)
     * 
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    public T get(int index) {
        checkBounds(index);
        return array[index];
    }

    /**
     * Sets the element at the specified index.
     * Time Complexity: O(1)
     * 
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    public void set(int index, T element) {
        checkBounds(index);
        array[index] = element;
    }

    /**
     * Appends the element to the end of the array.
     * Amortized Time Complexity: O(1)
     */
    public void add(T element) {
        ensureCapacity();
        array[size] = element;
        size++;
    }

    /**
     * Inserts the element at the specified index.
     * Time Complexity: O(n)
     * 
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        ensureCapacity();
        
        // Shift elements to the right to make space
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        
        array[index] = element;
        size++;
    }

    /**
     * Removes the element at the specified index.
     * Time Complexity: O(n)
     * 
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    public T remove(int index) {
        checkBounds(index);
        
        T removed = array[index];
        
        // Shift elements to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        
        array[size - 1] = null; // Clear reference for garbage collection
        size--;
        
        considerShrinking();
        return removed;
    }

    /**
     * Removes the first occurrence of the specified element.
     * Time Complexity: O(n)
     * 
     * @return true if element was found and removed, false otherwise
     */
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            // Handles null and non-null elements
            if (array[i] == element || 
               (array[i] != null && array[i].equals(element))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the element.
     * Time Complexity: O(n)
     */
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element || 
               (array[i] != null && array[i].equals(element))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if the array contains the specified element.
     * Time Complexity: O(n)
     */
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    /**
     * Removes all elements from the array and resets capacity.
     * Time Complexity: O(n)
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        // Null out references for garbage collection
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        capacity = INITIAL_CAPACITY;
        array = (T[]) new Object[capacity];
    }

    /**
     * Returns a string representation of the array.
     * Time Complexity: O(n)
     */
    @Override
    public String toString() {
        if (size == 0) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[size - 1]).append("]");
        return sb.toString();
    }

    // ================ PRIVATE HELPER METHODS ================ //
    
    /**
     * Checks if the index is within bounds for access/update.
     * Throws IndexOutOfBoundsException if invalid.
     */
    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * Ensures there is enough capacity to add a new element.
     * Resizes the array if needed.
     */
    private void ensureCapacity() {
        if (size == capacity) {
            resize((int) (capacity * GROWTH_FACTOR) + 1);
        }
    }

    /**
     * Shrinks the array if usage drops below the threshold.
     */
    private void considerShrinking() {
        if (capacity > INITIAL_CAPACITY && size < capacity * SHRINK_THRESHOLD) {
            resize(Math.max(INITIAL_CAPACITY, (int) (capacity / GROWTH_FACTOR)));
        }
    }

    /**
     * Resizes the internal array to the new capacity.
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
        capacity = newCapacity;
    }
}