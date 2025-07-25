# DynamicArray

A generic, resizable array implementation in Java, similar to `ArrayList`, designed for educational purposes and interview preparation.

## Features

- **Generic Type Support:** Store any object type.
- **Automatic Resizing:** Grows and shrinks as elements are added or removed.
- **Exception Handling:** Robust checks for invalid operations.
- **Time Complexity Analysis:** Documented for each method.
- **Core Operations:** Add, insert, remove, get, set, search, clear.

## Usage

```java
DynamicArray<String> names = new DynamicArray<>();
names.add("Alice");
names.add("Bob");
names.insert(1, "Charlie");
System.out.println(names); // [Alice, Charlie, Bob]
names.remove("Charlie");
System.out.println(names.size()); // 2
```

## API Overview

- `add(T element)` – Add to end
- `insert(int index, T element)` – Insert at index
- `remove(int index)` – Remove by index
- `remove(T element)` – Remove by value
- `get(int index)` – Access element
- `set(int index, T element)` – Update element
- `size()` – Number of elements
- `capacity()` – Internal array size
- `isEmpty()` – Check if empty
- `clear()` – Remove all elements
- `contains(T element)` – Search for value
- `indexOf(T element)` – Find index

## Example

See [`Main.java`](./Main.java) for a demonstration of all