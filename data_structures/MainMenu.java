package data_structures;

import data_structures.hash_tables.ChainingHashTable.ChainingHashTable;
import data_structures.hash_tables.LinearProbingHashTable.LinearProbingHashTable;
import data_structures.linked_lists.Doubly_Linked_List.DoubleLinkedList;
import data_structures.linked_lists.Singly_Linked_List.SingleLinkedList;
import data_structures.arrays.DynamicArrays.DynamicArray;

import java.util.Scanner;

/**
 * A console menu system for testing various data structure implementations.
 */
public class MainMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== Data Structures Main Menu ====");
            System.out.println("1. Array Implementations");
            System.out.println("2. Linked List Implementations");
            System.out.println("3. Hash Table Implementations");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    arrayMenu();
                    break;
                case 2:
                    linkedListMenu();
                    break;
                case 3:
                    hashTableMenu();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void arrayMenu() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        
        while (true) {
            System.out.println("\n==== Array Implementations ====");
            System.out.println("1. Add element");
            System.out.println("2. Get element by index");
            System.out.println("3. Remove element by index");
            System.out.println("4. Print array");
            System.out.println("5. Get size");
            System.out.println("6. Back to main menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    int element = scanner.nextInt();
                    dynamicArray.add(element);
                    System.out.println("Element added.");
                    break;
                case 2:
                    System.out.print("Enter index: ");
                    int getIndex = scanner.nextInt();
                    try {
                        System.out.println("Element at index " + getIndex + ": " + dynamicArray.get(getIndex));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 3:
                    System.out.print("Enter index to remove: ");
                    int removeIndex = scanner.nextInt();
                    try {
                        dynamicArray.remove(removeIndex);
                        System.out.println("Element removed.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 4:
                    System.out.println("Array contents: " + dynamicArray);
                    break;
                case 5:
                    System.out.println("Current size: " + dynamicArray.size());
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void linkedListMenu() {
        System.out.println("\n==== Linked List Type ====");
        System.out.println("1. Singly Linked List");
        System.out.println("2. Doubly Linked List");
        System.out.println("3. Back to main menu");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                singleLinkedListMenu();
                break;
            case 2:
                doubleLinkedListMenu();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void singleLinkedListMenu() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        
        while (true) {
            System.out.println("\n==== Singly Linked List Operations ====");
            System.out.println("1. Add to head");
            System.out.println("2. Add to tail");
            System.out.println("3. Remove from head");
            System.out.println("4. Remove from tail");
            System.out.println("5. Search for element");
            System.out.println("6. Print list");
            System.out.println("7. Get size");
            System.out.println("8. Back to linked list menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add to head: ");
                    list.addFirst(scanner.nextInt());
                    System.out.println("Element added.");
                    break;
                case 2:
                    System.out.print("Enter element to add to tail: ");
                    list.addLast(scanner.nextInt());
                    System.out.println("Element added.");
                    break;
                case 3:
                    try {
                        System.out.println("Removed element: " + list.removeFirst());
                    } catch (RuntimeException e) {
                        System.out.println("List is empty!");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Removed element: " + list.removeLast());
                    } catch (RuntimeException e) {
                        System.out.println("List is empty!");
                    }
                    break;
                case 5:
                    System.out.print("Enter element to search: ");
                    int searchVal = scanner.nextInt();
                    System.out.println("Element found: " + list.contains(searchVal));
                    break;
                case 6:
                    System.out.println("List contents: " + list);
                    break;
                case 7:
                    System.out.println("Current size: " + list.size());
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void doubleLinkedListMenu() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        
        while (true) {
            System.out.println("\n==== Doubly Linked List Operations ====");
            System.out.println("1. Add to head");
            System.out.println("2. Add to tail");
            System.out.println("3. Remove from head");
            System.out.println("4. Remove from tail");
            System.out.println("5. Search for element");
            System.out.println("6. Print list forward");
            System.out.println("7. Print list backward");
            System.out.println("8. Get size");
            System.out.println("9. Back to linked list menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add to head: ");
                    list.addFirst(scanner.nextInt());
                    System.out.println("Element added.");
                    break;
                case 2:
                    System.out.print("Enter element to add to tail: ");
                    list.addLast(scanner.nextInt());
                    System.out.println("Element added.");
                    break;
                case 3:
                    try {
                        System.out.println("Removed element: " + list.removeFirst());
                    } catch (RuntimeException e) {
                        System.out.println("List is empty!");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Removed element: " + list.removeLast());
                    } catch (RuntimeException e) {
                        System.out.println("List is empty!");
                    }
                    break;
                case 5:
                    System.out.print("Enter element to search: ");
                    int searchVal = scanner.nextInt();
                    System.out.println("Element found: " + list.contains(searchVal));
                    break;
                case 6:
                    System.out.println("List contents (forward): " + list);
                    break;
                case 7:
                    System.out.println("List contents (backward): " + list.toStringReverse());
                    break;
                case 8:
                    System.out.println("Current size: " + list.size());
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void hashTableMenu() {
        System.out.println("\n==== Hash Table Type ====");
        System.out.println("1. Chaining Hash Table");
        System.out.println("2. Linear Probing Hash Table");
        System.out.println("3. Back to main menu");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                chainingHashTableMenu();
                break;
            case 2:
                linearProbingHashTableMenu();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void chainingHashTableMenu() {
        ChainingHashTable<String, Integer> table = new ChainingHashTable<>();
        
        while (true) {
            System.out.println("\n==== Chaining Hash Table Operations ====");
            System.out.println("1. Put key-value pair");
            System.out.println("2. Get value by key");
            System.out.println("3. Remove by key");
            System.out.println("4. Check if key exists");
            System.out.println("5. Print table");
            System.out.println("6. Get size");
            System.out.println("7. Back to hash table menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    String key = scanner.nextLine();
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    table.put(key, value);
                    System.out.println("Entry added.");
                    break;
                case 2:
                    System.out.print("Enter key to search: ");
                    String searchKey = scanner.nextLine();
                    Integer result = table.get(searchKey);
                    System.out.println(result != null ? "Value: " + result : "Key not found");
                    break;
                case 3:
                    System.out.print("Enter key to remove: ");
                    String removeKey = scanner.nextLine();
                    table.remove(removeKey);
                    System.out.println("Entry removed if it existed.");
                    break;
                case 4:
                    System.out.print("Enter key to check: ");
                    String containsKey = scanner.nextLine();
                    System.out.println("Key exists: " + table.containsKey(containsKey));
                    break;
                case 5:
                    System.out.println("Hash table contents:\n" + table);
                    break;
                case 6:
                    System.out.println("Current size: " + table.size());
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void linearProbingHashTableMenu() {
        LinearProbingHashTable<String, Integer> table = new LinearProbingHashTable<>();
        
        while (true) {
            System.out.println("\n==== Linear Probing Hash Table Operations ====");
            System.out.println("1. Put key-value pair");
            System.out.println("2. Get value by key");
            System.out.println("3. Remove by key");
            System.out.println("4. Check if key exists");
            System.out.println("5. Print table");
            System.out.println("6. Get size");
            System.out.println("7. Back to hash table menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    String key = scanner.nextLine();
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    table.put(key, value);
                    System.out.println("Entry added.");
                    break;
                case 2:
                    System.out.print("Enter key to search: ");
                    String searchKey = scanner.nextLine();
                    Integer result = table.get(searchKey);
                    System.out.println(result != null ? "Value: " + result : "Key not found");
                    break;
                case 3:
                    System.out.print("Enter key to remove: ");
                    String removeKey = scanner.nextLine();
                    table.remove(removeKey);
                    System.out.println("Entry removed if it existed.");
                    break;
                case 4:
                    System.out.print("Enter key to check: ");
                    String containsKey = scanner.nextLine();
                    System.out.println("Key exists: " + table.containsKey(containsKey));
                    break;
                case 5:
                    System.out.println("Hash table contents: " + table);
                    break;
                case 6:
                    System.out.println("Current size: " + table.size());
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}