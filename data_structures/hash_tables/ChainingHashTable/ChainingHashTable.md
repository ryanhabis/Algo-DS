# Chaining Hash Table Implementation

## Overview
A hash table that uses chaining (linked lists) to handle collisions. When multiple keys hash to the same index, they're stored in a linked list at that bucket.

## How Chaining Works

### Structure
```
Hash Table
[0] -> null
[1] -> (key1, val1) -> (key2, val2) -> null
[2] -> (key3, val3) -> null
...
[n] -> null
```

### Insertion Process
1. Compute hash code of key
2. Convert hash code to array index
3. If bucket is empty, create new linked list
4. If key exists in chain, update value
5. If key doesn't exist, append to chain

### Search Process
1. Compute hash code of key
2. Locate the bucket
3. Sequentially search the chain for matching key

## Implementation Details

### Key Components
1. **Table Array**: Array of linked lists (buckets)
2. **Entry Class**: Stores key-value pairs
3. **Hash Function**: `hash(key) = abs(key.hashCode()) % capacity`
4. **Load Factor**: When ratio (elements/buckets) > 0.75, table resizes

### Complexity Analysis

| Operation | Average Case | Worst Case |
|-----------|-------------|------------|
| Insert    | O(1)        | O(n)       |
| Search    | O(1)        | O(n)       |
| Delete    | O(1)        | O(n)       |

*Assumes good hash function and proper resizing*

## Usage Example

```java
ChainingHashTable<String, Integer> ages = new ChainingHashTable<>();
ages.put("Alice", 25);
ages.put("Bob", 30);

// Retrieval
int aliceAge = ages.get("Alice"); // 25

// Removal
ages.remove("Bob");
```

## Advantages of Chaining
1. Handles collisions gracefully
2. Simple to implement
3. No clustering issues
4. Efficient for moderate load factors

## Disadvantages
1. Extra memory for linked list pointers
2. Cache performance worse than open addressing
3. Worst-case O(n) operations if all keys collide

## Resizing Strategy
When load factor > 0.75:
1. Create new table with double capacity
2. Rehash all existing entries
3. Maintain same key-value mappings

## Visual Example

Insertion of ("A",1), ("B",2), ("C",3) where hash(A)=1, hash(B)=1, hash(C)=2:

```
Before:
[0] null
[1] null
[2] null

After:
[0] null
[1] (A,1) -> (B,2) -> null
[2] (C,3) -> null
```

## Best Practices
1. Keys should be immutable
2. Implement proper hashCode() for key objects
3. Choose initial capacity based on expected size
4. Consider thread safety if needed