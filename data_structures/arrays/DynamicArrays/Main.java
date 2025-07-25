package data_structures.arrays.DynamicArrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Dynamic Array Demonstration ===");
        
        // 1. Initialize an empty DynamicArray of Strings
        DynamicArray<String> names = new DynamicArray<>();
        System.out.println("\nInitial array:");
        printArrayInfo(names);

        // 2. Add elements to the array
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        System.out.println("\nAfter adding 3 elements:");
        printArrayInfo(names);
        System.out.println("Array contents: " + names);

        // 3. Insert an element at a specific index
        names.insert(1, "David"); // Insert "David" at index 1
        System.out.println("\nAfter inserting 'David' at index 1:");
        System.out.println("Array contents: " + names);

        // 4. Access an element by index
        System.out.println("\nElement at index 2: " + names.get(2));

        // 5. Update an element at a specific index
        names.set(0, "Alicia"); // Change "Alice" to "Alicia"
        System.out.println("\nAfter updating index 0 to 'Alicia':");
        System.out.println("Array contents: " + names);

        // 6. Remove an element by index
        String removed = names.remove(2); // Remove element at index 2
        System.out.println("\nAfter removing index 2 (" + removed + "):");
        System.out.println("Array contents: " + names);

        // 7. Remove an element by value
        boolean found = names.remove("Bob"); // Remove "Bob" if present
        System.out.println("\nAfter removing 'Bob' (found: " + found + "):");
        System.out.println("Array contents: " + names);

        // 8. Search operations
        System.out.println("\nSearch results:");
        System.out.println("Contains 'Charlie'? " + names.contains("Charlie")); // Check if "Charlie" exists
        System.out.println("Index of 'David': " + names.indexOf("David")); // Get index of "David"

        // 9. Demonstrate automatic resizing by adding more elements
        System.out.println("\nAdding elements to demonstrate resizing:");
        for (int i = 0; i < 15; i++) {
            names.add("Name-" + i);
            // Print size and capacity after each addition
            System.out.printf("Size: %d, Capacity: %d%n", 
                names.size(), names.capacity());
        }

        // 10. Clear all elements from the array
        names.clear();
        System.out.println("\nAfter clear():");
        printArrayInfo(names);
    }

    // Helper method to print array information
    private static void printArrayInfo(DynamicArray<?> array) {
        System.out.println("Size: " + array.size());
        System.out.println("Capacity: " + array.capacity());
        System.out.println("Is empty? " + array.isEmpty());
    }
}