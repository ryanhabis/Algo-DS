package data_structures.hash_tables.LinearProbingHashTable;

/**
 * Demonstration class for the LinearProbingHashTable implementation.
 * 
 * <p>This class showcases the functionality of the hash table including
 * insertion, retrieval, deletion, collision handling, and resizing.</p>
 */
public class Main {
    public static void main(String[] args) {
        LinearProbingHashTable<String, Integer> ageTable = new LinearProbingHashTable<>();

        // 1. Basic operations demonstration
        System.out.println("=== Testing Basic Operations ===");
        ageTable.put("Alice", 25);
        ageTable.put("Bob", 30);
        ageTable.put("Charlie", 35);
        System.out.println("Initial table: " + ageTable);

        System.out.println("\nAge of Alice: " + ageTable.get("Alice"));
        System.out.println("Contains 'David': " + ageTable.containsKey("David"));

        // 2. Collision handling demonstration
        System.out.println("\n=== Testing Collision Handling ===");
        // These keys will collide in default Java String hash function
        ageTable.put("Aa", 100);  // Hash collision with "BB"
        ageTable.put("BB", 200);  // in Java's default hash function
        System.out.println("After adding colliding keys: " + ageTable);
        System.out.println("Value for 'Aa': " + ageTable.get("Aa"));
        System.out.println("Value for 'BB': " + ageTable.get("BB"));

        // 3. Removal demonstration
        System.out.println("\n=== Testing Removal ===");
        ageTable.remove("Bob");
        System.out.println("After removing Bob: " + ageTable);
        System.out.println("Size after removal: " + ageTable.size());

        // 4. Resizing demonstration
        System.out.println("\n=== Testing Auto-Resizing ===");
        System.out.println("Adding elements to trigger resize...");
        for (int i = 1; i <= 20; i++) {
            ageTable.put("Person" + i, 20 + i);
        }
        System.out.println("Final table size: " + ageTable.size());
        System.out.println("Sample entries:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Person" + i + ": " + ageTable.get("Person" + i));
        }
    }
}