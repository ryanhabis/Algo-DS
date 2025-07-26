package data_structures.arrays.StaticArray;

public class Main {
    public static void main(String[] args) {
        StaticArray<String> names = new StaticArray<>(5);
        
        names.set(0, "Alice");
        names.set(1, "Bob");
        names.set(2, "Charlie");
        
        System.out.println("Array contents: " + names);
        System.out.println("Size: " + names.size());
        System.out.println("Capacity: " + names.capacity());
        System.out.println("Element at index 1: " + names.get(1));
    }
}
