package data_structures.arrays.DynamicArrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Dynamic Array Demonstration ===");
        
        // 1. Initialize array
        DynamicArray<String> names = new DynamicArray<>();
        System.out.println("\nInitial array:");
        printArrayInfo(names);

        // 2. Add elements
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        System.out.println("\nAfter adding 3 elements:");
        printArrayInfo(names);
        System.out.println("Array contents: " + names);

        // 3. Insert element
        names.insert(1, "David");
        System.out.println("\nAfter inserting 'David' at index 1:");
        System.out.println("Array contents: " + names);

        // 4. Access elements
        System.out.println("\nElement at index 2: " + names.get(2));

        // 5. Update element
        names.set(0, "Alicia");
        System.out.println("\nAfter updating index 0 to 'Alicia':");
        System.out.println("Array contents: " + names);

        // 6. Remove by index
        String removed = names.remove(2);
        System.out.println("\nAfter removing index 2 (" + removed + "):");
        System.out.println("Array contents: " + names);

        // 7. Remove by value
        boolean found = names.remove("Bob");
        System.out.println("\nAfter removing 'Bob' (found: " + found + "):");
        System.out.println("Array contents: " + names);

        // 8. Search operations
        System.out.println("\nSearch results:");
        System.out.println("Contains 'Charlie'? " + names.contains("Charlie"));
        System.out.println("Index of 'David': " + names.indexOf("David"));

        // 9. Demonstrate resizing
        System.out.println("\nAdding elements to demonstrate resizing:");
        for (int i = 0; i < 15; i++) {
            names.add("Name-" + i);
            System.out.printf("Size: %d, Capacity: %d%n", 
                names.size(), names.capacity());
        }

        // 10. Clear the array
        names.clear();
        System.out.println("\nAfter clear():");
        printArrayInfo(names);
    }

    private static void printArrayInfo(DynamicArray<?> array) {
        System.out.println("Size: " + array.size());
        System.out.println("Capacity: " + array.capacity());
        System.out.println("Is empty? " + array.isEmpty());
    }
}