package data_structures.hash_tables.LinearProbingHashTable;

/**
 * A hash table implementation using linear probing for collision resolution.
 * 
 * <p>When a collision occurs, this implementation searches sequentially (linearly)
 * for the next available slot in the array. The table automatically resizes when
 * the load factor exceeds a specified threshold (0.7 by default).</p>
 * 
 * @param <K> the type of keys maintained by this hash table
 * @param <V> the type of mapped values
 */
public class LinearProbingHashTable<K, V> {
    /** Default initial capacity of the hash table */
    private static final int DEFAULT_CAPACITY = 16;
    
    /** Threshold for resizing the hash table (size/capacity) */
    private static final double LOAD_FACTOR_THRESHOLD = 0.7;
    
    /** Special marker for deleted entries (tombstones) */
    private static final Entry<?, ?> DELETED = new Entry<>(null, null);

    /** The array of entries representing the hash table */
    private Entry<K, V>[] table;
    
    /** The number of key-value mappings in the hash table */
    private int size;
    
    /** The current capacity of the hash table */
    private int capacity;

    /**
     * Represents a key-value pair in the hash table.
     * 
     * @param <K> the type of the key
     * @param <V> the type of the value
     */
    private static class Entry<K, V> {
        /** The key of the entry (final to ensure immutability) */
        final K key;
        
        /** The value associated with the key */
        V value;

        /**
         * Constructs a new entry with the specified key and value.
         * 
         * @param key the entry key
         * @param value the entry value
         */
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Constructs an empty hash table with the default initial capacity (16).
     */
    @SuppressWarnings("unchecked")
    public LinearProbingHashTable() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty hash table with the specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the hash table
     * @throws IllegalArgumentException if the initial capacity is non-positive
     */
    @SuppressWarnings("unchecked")
    public LinearProbingHashTable(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.capacity = initialCapacity;
        this.table = (Entry<K, V>[]) new Entry[capacity];
        this.size = 0;
    }

    /**
     * Associates the specified value with the specified key in this hash table.
     * 
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @throws IllegalArgumentException if the key is null
     */
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        // Resize if the load factor exceeds threshold
        if ((double) size / capacity >= LOAD_FACTOR_THRESHOLD) {
            resize();
        }

        int index = findSlot(key);
        if (table[index] == null || table[index] == DELETED) {
            size++;
        }
        table[index] = new Entry<>(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this hash table
     * contains no mapping for the key.
     * 
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if no mapping exists
     * @throws IllegalArgumentException if the key is null
     */
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = findKeyIndex(key);
        return index == -1 ? null : table[index].value;
    }

    /**
     * Removes the mapping for the specified key from this hash table if present.
     * 
     * @param key the key whose mapping is to be removed from the hash table
     * @throws IllegalArgumentException if the key is null
     */
    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = findKeyIndex(key);
        if (index != -1) {
            // Mark as deleted (tombstone) instead of setting to null
            // to maintain probe sequence integrity
            table[index] = (Entry<K, V>) DELETED;
            size--;
        }
    }

    /**
     * Returns true if this hash table contains a mapping for the specified key.
     * 
     * @param key the key whose presence in this hash table is to be tested
     * @return true if this hash table contains a mapping for the specified key
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /**
     * Returns the number of key-value mappings in this hash table.
     * 
     * @return the number of key-value mappings in this hash table
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this hash table contains no key-value mappings.
     * 
     * @return true if this hash table contains no key-value mappings
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Computes the hash index for the specified key.
     * 
     * @param key the key to hash
     * @return the computed hash index (always non-negative)
     */
    private int hash(K key) {
        // Using absolute value to ensure non-negative index
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * Finds the appropriate slot for the specified key using linear probing.
     * 
     * <p>This method handles three cases:
     * 1. The slot is empty (returns immediately)
     * 2. The slot contains the same key (for update)
     * 3. The slot is occupied by a different key (probes for next slot)</p>
     * 
     * @param key the key to find a slot for
     * @return the index of the appropriate slot
     */
    private int findSlot(K key) {
        int index = hash(key);
        int firstDeleted = -1; // Track first tombstone encountered

        while (table[index] != null) {
            if (table[index] != DELETED) {
                // Found existing entry with same key
                if (table[index].key.equals(key)) {
                    return index;
                }
            } else if (firstDeleted == -1) {
                // Remember first tombstone for potential reuse
                firstDeleted = index;
            }
            // Linear probing: move to next slot (with wrap-around)
            index = (index + 1) % capacity;
        }

        // Return either the first tombstone or the found empty slot
        return firstDeleted != -1 ? firstDeleted : index;
    }

    /**
     * Finds the index of the specified key in the hash table.
     * 
     * @param key the key to search for
     * @return the index of the key, or -1 if not found
     */
    private int findKeyIndex(K key) {
        int index = hash(key);
        int startIndex = index;

        do {
            if (table[index] == null) {
                return -1; // Key not found
            }
            if (table[index] != DELETED && table[index].key.equals(key)) {
                return index; // Key found
            }
            index = (index + 1) % capacity; // Linear probing
        } while (index != startIndex); // Check entire table

        return -1; // Key not found after full traversal
    }

    /**
     * Resizes the hash table to double its current capacity and rehashes all entries.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        Entry<K, V>[] oldTable = table;
        table = (Entry<K, V>[]) new Entry[capacity];
        size = 0; // Reset size, will be recalculated during rehashing

        // Rehash all existing entries (skip nulls and tombstones)
        for (Entry<K, V> entry : oldTable) {
            if (entry != null && entry != DELETED) {
                put(entry.key, entry.value);
            }
        }
    }

    /**
     * Returns a string representation of this hash table.
     * 
     * @return a string representation of the hash table contents
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        for (Entry<K, V> entry : table) {
            if (entry != null && entry != DELETED) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(entry.key).append("=").append(entry.value);
                first = false;
            }
        }
        sb.append("}");
        return sb.toString();
    }
}