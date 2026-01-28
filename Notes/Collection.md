## 🔎 Table of Contents
- [📐 Generalized Syntax Template](#generalized-syntax-template)
- [📖 Example Explained](#example-explained)
- [✅ Generics](#generics)
- [🔧 Generic Syntax](#-generic-syntax)
    - [🔷 Generic Class](#-generic-class)
    - [🧠 Generic Method Example](#-generic-method-example)
- [📝 Java List Interface](#-java-list-interface)
    - [📜 ArrayList](#arraylist)
    - [🔗 Java LinkedList](#java-linkedlist)
    - [⚙️ Java Vector](#java-vector)
    - [📊 Vector vs ArrayList in Java](#-vector-vs-arraylist-in-java)
- [🛠️ Stack in Java](#-stack-in-java)
- [🎯 Set in Java](#-set-in-java)

---

## Generalized Syntax Template
```java
InterfaceType<GenericType> variableName = new ImplementationClass<>();
```

## Example Explained:
- **InterfaceType** → like `List`, `Set`, or `Map`
- **GenericType** → the type of data the collection holds (e.g., `String`, `Integer`)
- **variableName** → name of your variable (e.g., `list`)
- **ImplementationClass** → concrete class like `ArrayList`, `HashSet`, `HashMap`


# ✅Generics✅

- Allow you to define classes, interfaces, and methods with type parameters, so you can write code that works with any data type while still being type-safe. Generics provide a way to parameterize types (e.g., `List<String>`, `List<Integer>`), allowing code reusability and type safety at compile time.

## 🔧 Generic Syntax

### 🔷 Generic Class

```java
class Box<T> {
    T value;

    void set(T val) { value = val; }
    T get() { return value; }
}
```

`T` is a type parameter — it could be `String`, `Integer`, etc.  
We can create as: `Box<String> stringBox = new Box<>();`

### 🔷 Generic Method Example

🧠 **Type Inference:** Java looks at the argument you pass to the method (`String[]`) and figures out what `T` should be.

```java
public class Utils {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

// Calling
String[] names = {"Alice", "Bob"};
Utils.printArray(names);  // 👈 Here you pass String[]
```

- `T` becomes `String`
- So internally → `public static void printArray(Integer[] array)`
- **The Java Compiler (at Compile Time):** Java uses type inference to automatically replace `<T>` with the actual type based on what argument you pass to the method.

<a name="java-list-interface"></a>
<h2 align="center">Java List Interface</h2>



`List<E>` is an ordered collection (also known as a sequence) that allows duplicate elements and maintains insertion order. It extends `Collection<E>` and provides positional access, search, and list-iterator operations.

- **Types of List implementations:**
    - `ArrayList` – Resizable-array implementation; provides fast random access but slower inserts/removals in the middle of the list.
    - `LinkedList` – Doubly-linked list implementation; provides fast inserts/removals anywhere but slower random access.
    - `Vector` – Synchronized resizable-array implementation; legacy class with similar performance to `ArrayList`.

## ArrayList

```java
// ArrayList
List<String> myList = new ArrayList<>(); // InterfaceType<GenericType> variableName = new ImplementationClass<>();
// Declare a reference variable myList of interface type List<String> that can store String values only,
// and instantiate it with a concrete implementation ArrayList<String>
myList.add("Apple");
myList.add("mango");
System.out.println(myList);
```

**Q) Why It Looks Like an Array?**  
**A)** Behind the scenes, `ArrayList` overrides the `toString()` method from the `AbstractCollection` class (which it inherits from), and that implementation prints the elements in a comma-separated, bracketed format — similar to an array.


## Java LinkedList

---

### ✅ What is LinkedList?

`LinkedList` is a **linear data structure** that stores elements in **non-contiguous memory locations**. It is a part of the **Java Collection Framework** and implements both `List` and `Deque` interfaces.
 - Note: always first add the value at index 0 otherwise it will throw error
---

### ✅ Key Features

- **Doubly Linked**: Each node contains references to both the previous and the next node.
- **Dynamic Size**: Can grow and shrink at runtime without memory reallocation.
- **Efficient Insertions/Deletions**: Especially useful when frequent addition/removal is needed (except for random access).
- **Implements List, Deque, and Queue interfaces**.

---

### ✅ Syntax

```java
//List<String> list = new LinkedList<>(); 
LinkedList<Integer> linkedList = new LinkedList<>();
linkedList.add(0, 0); // index 0 should be filled first
linkedList.add(1, 1);
linkedList.add(2);
linkedList.remove(2);
System.out.println("linkedList : " + linkedList);
```


<h2 >Java Vector</h2>

---

### ✅ What is Vector?

`Vector` is a **legacy class** in Java that implements a **growable array of objects**. It is **synchronized**, meaning it is **thread-safe**, and is a part of the **Java Collection Framework** as it implements the `List` interface.

---

### ✅ Key Characteristics

- **Thread-safe** (synchronized methods).
- **Resizes automatically** when elements are added.
- Allows **duplicate elements**.
- Maintains **insertion order**.
- **Legacy class**, introduced in Java 1.0.

---

### ✅ Syntax

```java
Vector<String> vector = new Vector<>();
vector.add("5");
vector.add("10");
vector.add("15");
System.out.println("Vector : " + vector);
```

## ✅ Vector vs ArrayList in Java

| Feature           | ArrayList         | Vector           |
|-------------------|-------------------|------------------|
| Thread Safe       | ❌ No             | ✅ Yes           |
| Performance       | ✅ Faster         | ❌ Slower        |
| Synchronization   | Not synchronized  | Synchronized     |
| Growth Rate       | Grows 50%         | Doubles in size  |
| Introduced In     | Java 1.2          | Java 1.0         |
| Use Case          | Single-threaded   | Multi-threaded   |
| Legacy?           | Modern collection | Legacy class     |

🔸 **Which is Faster?**
- `ArrayList` is faster because it doesn’t have the overhead of synchronization.
- Synchronization is a mechanism that ensures only one thread accesses a shared resource at a time, preventing inconsistent or corrupted data when multiple threads are involved.
- **Why is Synchronization Needed?**  
  In multi-threaded programs:
    - Multiple threads may access and modify the same object at the same time.
    - This can cause race conditions, data inconsistency, or unpredictable behavior.
    - 🔒 Synchronization ensures thread safety.

🔸 **When to Use ArrayList:**
- In most modern applications
- When thread safety is not a concern
- Better performance for read/write operations

🔸 **When to Use Vector:**
- When you are working in a multi-threaded environment
- And external synchronization is not being used
- (Rare in modern Java — usually for legacy code)

🔸 **Better Modern Alternative:**  
Use a synchronized wrapper with `ArrayList`:
```java
List<String> safeList = Collections.synchronizedList(new ArrayList<>());
```  
This gives you thread safety **without using Vector**.

🔸 **Example:**
```java
// Using Vector (legacy)
Vector<String> vec = new Vector<>();
vec.add("Item");

// Using ArrayList (preferred)
ArrayList<String> list = new ArrayList<>();
list.add("Item");

// Thread-safe ArrayList
List<String> syncList = Collections.synchronizedList(new ArrayList<>());
syncList.add("Thread-safe Item");
```

📌 **Conclusion:**
- ✔ Use `ArrayList` for most use cases.
- ❌ Avoid `Vector` unless you're working with old codebases that require it.

## ✅ Stack in Java

🚫 **Avoid this:**
```java
List<Integer> stack = new Stack<>();
```

❌ **Reason:**
- `List` doesn't have `push()`, `pop()`, or `peek()` methods.
- Using it like a stack will cause compile-time errors.
- Compilation error if you try to call `stack.push()` or `stack.pop()`.
- Because `List` only has `add()`, `remove()`, `get()`, etc.

✅ **Use this instead:**
```java
Stack<Integer> stack = new Stack<>();
```

📌 **Tip:**  
Always use `Stack` or `Deque` type if you need stack operations.

### 🔸 What is a Stack?
- A stack is a linear data structure that follows the **LIFO** principle:
    - **LIFO** → Last In, First Out
- The last element added is the first one removed.
- Stores duplicate values; ordered.

### 🔸 Real-Life Analogy:
- Stack of plates: You add and remove from the top.

### 🔸 Java `Stack` Class:
- Built-in `Stack` class in `java.util` package.
- Extends `Vector` (thread-safe but considered legacy).

### 🔸 Common Stack Methods:
- `push(E item)` → Adds item to top of stack
- `pop()` → Removes and returns top item
- `peek()` → Returns top item without removing it
- `isEmpty()` → Checks if stack is empty
- `search(Object o)` → Returns 1-based position of element from top

### 🔸 Example:
```java
Stack<String> stack = new Stack<>();
stack.push("A");
stack.push("B");
stack.pop();    // Removes "B"
stack.peek();   // Returns "A"
stack.isEmpty(); // false
```

### 🔸 Modern Alternative:
- `Stack` extends `Vector`, so it’s synchronized but generally not recommended for new code.
- Use `Deque` (e.g., `ArrayDeque`) for stack behavior in modern Java:
```java
Deque<String> stack = new ArrayDeque<>();
stack.push("X");
stack.pop();
```

### 🔸 Use Cases:
- Undo/Redo operations
- Expression evaluation (e.g., postfix)
- Recursion handling
- Browser back button history
- Depth-first search (DFS), maze solving

📌 **Tip:**  
Prefer `ArrayDeque` over `Stack` for non-threaded applications.

### 🔸 Example:
```java
Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
stack.push(30);
stack.pop();
stack.push(10);
System.out.println("Stack : " + stack.peek());
```

## ✅ Set in Java

🔸 **What is a Set?**
- A Set is a Collection that **does not allow duplicate elements**.
- It is an **unordered** collection (no index-based access).

🔸 **Types of Set:**
1. `HashSet` → Fast, no order maintained
2. `LinkedHashSet` → Maintains insertion order
3. `TreeSet` → Sorted set (natural ordering)

🔸 **Common Methods:**
- `add(element)` → Adds element if not already present
- `remove(element)` → Removes the element
- `contains(element)` → Checks if element exists
- `isEmpty()`, `size()`, `clear()`

🔸 **Example:**
```java
Set<String> set = new HashSet<>();
set.add("Apple");
set.add("Apple");   // ❌ Duplicate, won't be added
set.add("Banana");
```

🔸 **Use Cases:**
- Removing duplicates from a list
- Fast lookup of unique values
- Representing sets in math/logic operations

📌 **Tip:**
- Use `TreeSet` when you need elements in sorted order.
- Use `HashSet` for best performance (O(1) operations).
