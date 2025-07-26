# Static Array Implementation

## Overview
A fixed-size array implementation with basic operations.

## Features
- Fixed capacity set at creation time
- Type-safe generic implementation
- Basic get/set operations
- Size tracking
- Bounds checking

## Complexity
| Operation | Time Complexity |
|-----------|-----------------|
| get()     | O(1)            |
| set()     | O(1)            |
| size()    | O(1)            |

## Usage Example
```java
StaticArray<Integer> numbers = new StaticArray<>(10);
numbers.set(0, 42);
int value = numbers.get(0);
```