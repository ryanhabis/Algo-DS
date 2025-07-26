package data_structures.hash_tables.ChainingHashTable;

/**
 * Demonstration of ChainingHashTable functionality
 */
public class Main {
    public static void main(String[] args) {
        // Initialize hash table
        ChainingHashTable<String, Integer> studentAges = new ChainingHashTable<>();

        // Test basic operations
        System.out.println("=== Testing Basic Operations ===");
        studentAges.put("Alice", 22);
        studentAges.put("Bob", 23);
        studentAges.put("Charlie", 24);
        
        System.out.println("Initial hash table contents:");
        printHashTable(studentAges);
        
        // Test get and containsKey
        System.out.println("\nAge of Alice: " + studentAges.get("Alice"));
        System.out.println("Contains key 'Bob': " + studentAges.containsKey("Bob"));
        System.out.println("Contains key 'David': " + studentAges.containsKey("David"));
        
        // Test update
        System.out.println("\n=== Testing Updates ===");
        studentAges.put("Alice", 23); // Update Alice's age
        System.out.println("Updated Alice's age:");
        printHashTable(studentAges);
        
        // Test remove 
        System.out.println("\n=== Testing Removal ===");
        studentAges.remove("Bob");
        System.out.println("After removing Bob:");
        printHashTable(studentAges);
        
        // Test resizing
        System.out.println("\n=== Testing Resizing ===");
        System.out.println("Adding more elements to trigger resize...");
        for (int i = 1; i <= 20; i++) {
            studentAges.put("Student" + i, 18 + i);
        }
        System.out.println("Final hash table size: " + studentAges.size());
        System.out.println("First few entries:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Student" + i + ": " + studentAges.get("Student" + i));
        }
    }
    
    private static void printHashTable(ChainingHashTable<?, ?> ht) {
        System.out.println(ht);
        System.out.println("Size: " + ht.size());
        System.out.println("Is empty: " + ht.isEmpty());
    }
}
