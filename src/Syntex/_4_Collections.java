package Syntex;

import java.util.*;
import java.util.List;
public class _4_Collections {

/*
Generalized syntax template:
->InterfaceType<GenericType> variableName = new ImplementationClass<>();

*Example Explained:
->InterfaceType → like List, Set, or Map
->GenericType → the type of data the collection holds (e.g., String, Integer)
->variableName → name of your variable (e.g., list)
->ImplementationClass → concrete class like ArrayList, HashSet, HashMap

*IMPORTANT TERMS
                                            ✅Generics✅

              Read : https://engineeringdigest.medium.com/generics-b158a743d18f

-> allow you to define classes, interfaces, and methods with type parameters,
  so you can write code that works with any data type, while still being type-safe.
  Generics provide a way to parameterize types (e.g., List<String>, List<Integer>),
  allowing code reusability and type safety at compile time.

->🔧 Generic Syntax:
  🔷 Generic Class
   ```
    class Box<T> {
    T value;

    void set(T val) { value = val; }
    T get() { return value; }
     }
    ```
    T is a type parameter — it could be String, Integer, etc.
    we can create as : Box<String> stringBox = new Box<>();

  🔷 Generic Method Example:
       🧠Type Inference:Java looks at the argument you pass to the method (String[]) and figures out what T should be.
       ```
       public class Utils {
           public static <T> void printArray(T[] array) {
                for (T element : array) {
                    System.out.println(element);
                }
            }
       }

       //calling
       String[] names = {"Alice", "Bob"};
       Utils.printArray(names);  // 👈 Here you pass String[]

       ```
      # T becomes String
      # So internally → public static void printArray(String[] array)
      # The Java Compiler (at Compile Time):Java uses type inference to automatically replace <T> with
                                            the actual type based on what argument you pass to the method.

 */


    public static void main(String[] args) {
        //ArrayList
        List<String> myList = new ArrayList<>(); //InterfaceType<GenericType> variableName = new ImplementationClass<>();
        //Declare a reference variable myList of interface type List<String> that can store String values only,
        // and instantiate it with a concrete implementation ArrayList<String>

        myList.add("Apple");
        myList.add("mango");
        System.out.println(myList);
        /*
         * Q)Why It Looks Like an Array?
         * A)Behind the scenes, ArrayList overrides the toString() method from the AbstractCollection class (which it inherits from),
         *   and that implementation prints the elements in a comma-separated, bracketed format — similar to an array.
         * */

        //ArrayList

        ArrayList<Integer> arrList = new ArrayList<>(10);
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(3, 4);
        arrList.set(3,5);
        boolean isExist = arrList.contains(5);
//        for(int x: arrList){
//            System.out.println(x);
//        }
        System.out.println("ArrayList : " + arrList + " Existence : " +  isExist );

        //LinkedList
        //Note: always first add the value at index 0 otherwise it will throw error
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0, 0); // index 0 should be filled first
        linkedList.add(1, 1);
        linkedList.add(2);
        linkedList.remove(2);
        System.out.println("linkedList : " + linkedList);

        //Vector
        Vector<String> vector = new Vector<>();
        vector.add("5");
        vector.add("10");
        vector.add("15");
        System.out.println("Vector : " + vector);

       /*
            ✅ Vector vs ArrayList in Java

            -----------------------------------------------------------
            | Feature           | ArrayList         | Vector           |
            -----------------------------------------------------------
            | Thread Safe       | ❌ No             | ✅ Yes          |
            | Performance       | ✅ Faster         | ❌ Slower       |
            | Synchronization   | Not synchronized  | Synchronized     |
            | Growth Rate       | Grows 50%         | Doubles in size  |
            | Introduced In     | Java 1.2          | Java 1.0         |
            | Use Case          | Single-threaded   | Multi-threaded   |
            | Legacy?           | Modern collection | Legacy class     |
            -----------------------------------------------------------

            🔸 Which is Faster?
                - ArrayList is faster because it doesn’t have the overhead of synchronization.
                - Synchronization is a mechanism that ensures only one thread accesses a shared resource at a time,
                  preventing inconsistent or corrupted data when multiple threads are involved.
                - Why is Synchronization Needed?
                  In multi-threaded programs:
                        Multiple threads may access and modify the same object at the same time.
                        This can cause race conditions, data inconsistency, or unpredictable behavior.
                        🔒 Synchronization ensures thread safety.

            🔸 When to Use ArrayList:
                - In most modern applications
                - When thread safety is not a concern
                - Better performance for read/write operations

            🔸 When to Use Vector:
                - When you are working in a multi-threaded environment
                - And external synchronization is not being used
                - (Rare in modern Java — usually for legacy code)

            🔸 Better Modern Alternative:
                Use synchronized wrapper with ArrayList:

                    List<String> safeList = Collections.synchronizedList(new ArrayList<>());

                This gives you thread safety **without using Vector**.

            🔸 Example:

                // Using Vector (legacy)
                Vector<String> vec = new Vector<>();
                vec.add("Item");

                // Using ArrayList (preferred)
                ArrayList<String> list = new ArrayList<>();
                list.add("Item");

                // Thread-safe ArrayList
                List<String> syncList = Collections.synchronizedList(new ArrayList<>());
                syncList.add("Thread-safe Item");

            📌 Conclusion:
                ✔ Use ArrayList for most use cases.
                ❌ Avoid Vector unless you're working with old codebases that require it.
         */


        /*
                ✅ Stack in Java

                🚫 Avoid this:
                    List<Integer> stack = new Stack<>();

                ❌ Reason:
                    - List doesn't have push(), pop(), or peek() methods.
                    - Using it like a stack will cause compile-time errors.
                    - Compilation error if you try to call stack.push() or stack.pop()
                    - Because List only has add(), remove(), get(), etc.


                ✅ Use this instead:
                    Stack<Integer> stack = new Stack<>();

                📌 Tip:
                    Always use Stack or Deque type if you need stack operations.

                🔸 What is a Stack?
                    - A stack is a linear data structure that follows the LIFO principle.
                    - LIFO → Last In, First Out.
                    - The last element added is the first one removed.
                    - store duplicate values also  ,ordered

                🔸 Real-Life Analogy:
                    - Stack of plates: You add and remove from the top.

                🔸 Java Stack Class:
                    - Java provides a built-in `Stack` class in java.util package.
                    - It extends Vector (thread-safe but considered legacy).

                🔸 Common Stack Methods:
                    - push(E item)       → Adds item to top of stack
                    - pop()              → Removes and returns top item
                    - peek()             → Returns top item without removing it
                    - isEmpty()          → Checks if stack is empty
                    - search(Object o)   → Returns 1-based position of element from top

                🔸 Example:
                    Stack<String> stack = new Stack<>();
                    stack.push("A");
                    stack.push("B");
                    stack.pop();           // Removes "B"
                    stack.peek();          // Returns "A"
                    stack.isEmpty();       // false

                🔸 Modern Alternative:
                    - Internally, Stack extends Vector, so it's synchronized but generally not recommended for new code.
                    - Instead, use Deque (like ArrayDeque) for stack behavior in modern Java.
                    - Use Deque (ArrayDeque) for better performance:
                        Deque<String> stack = new ArrayDeque<>();
                        stack.push("X");
                        stack.pop();

                🔸 Use Cases:
                    - Undo/Redo operations
                    - Expression evaluation (e.g., postfix)
                    - Recursion handling
                    - Browser back button history
                    - Depth-first search (DFS), maze solving

                📌 Tip:
                    Prefer ArrayDeque over Stack for non-threaded applications.
             */

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        stack.push(10);
        System.out.println("Stack : " + stack.peek());

        /*
            ✅ Set in Java

            🔸 What is a Set?
                - A Set is a Collection that **does not allow duplicate elements**.
                - It is an **unordered** collection (no index-based access).

            🔸 Types of Set:
                1. HashSet      → Fast, no order maintained
                2. LinkedHashSet → Maintains insertion order
                3. TreeSet      → Sorted set (natural ordering)

            🔸 Common Methods:
                - add(element)        → Adds element if not already present
                - remove(element)     → Removes the element
                - contains(element)   → Checks if element exists
                - isEmpty(), size(), clear()

            🔸 Example:
                Set<String> set = new HashSet<>();
                set.add("Apple");
                set.add("Apple");   // ❌ Duplicate, won't be added
                set.add("Banana");

            🔸 Use Cases:
                - Removing duplicates from a list
                - Fast lookup of unique values
                - Representing sets in math/logic operations

            📌 Tip:
                - Use TreeSet when you need elements in sorted order.
                - Use HashSet for best performance (O(1) operations).
        */
        //hashset
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(5);
        set.add(16);
        set.add(10);
        set.add(2);
        set.add(2);
        System.out.println("Set :  " + set);  //no order,only unique values

        // LinkedHashSet: stores unique elements and maintains insertion order
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(5);
        linkedHashSet.add(2);
        linkedHashSet.add(2);
        linkedHashSet.add(10);
        System.out.println("LinkedHashSet : " + linkedHashSet);


        // TreeSet: stores unique elements in their natural sorted order (ascending for integers)
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(2);
        treeSet.add(23);
        treeSet.add(25);
        treeSet.add(25);
        System.out.println("TreeSet : " + treeSet);

        /*
        ✅ Queue in Java

        🔸 What is a Queue?
            - A Queue is a linear data structure that follows **FIFO** (First-In-First-Out).
            - Elements are added from the **rear** and removed from the **front**.
            - It is part of the `java.util` package and defined by the `Queue` interface.

        🔸 Common Implementations:
            1. LinkedList      → Most commonly used for queue operations
            2. PriorityQueue   → Elements are ordered by natural ordering or custom comparator
            3. ArrayDeque      → Resizable-array implementation; better than Stack/LinkedList for queues

        🔸 Common Methods:
            - offer(element)   → Adds element to the rear (returns false if fails)
            - poll()           → Removes and returns the front element (null if empty)
            - peek()           → Returns front element without removing (null if empty)
            - isEmpty()        → Checks if queue is empty
            - size()           → Returns the number of elements
            - remove()         → Like poll(), but throws exception if queue is empty
            - add(element)     → Like offer(), but throws exception if fails

        🔸 Example:
            Queue<String> queue = new LinkedList<>();
            queue.offer("Apple");
            queue.offer("Banana");
            queue.offer("Cherry");

            System.out.println(queue.poll()); // Apple
            System.out.println(queue.peek()); // Banana

        🔸 Use Cases:
            - Order processing systems
            - Task scheduling (e.g., printer queue, job queue)
            - Level-order traversal in trees

        📌 Tip:
            - Use **PriorityQueue** when you want a sorted order.
            - Use **ArrayDeque** if you need a double-ended queue (Deque).
        */
        //Queue : order remain same
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);//add the value at end
        queue.offer(20);//add the value at end   (use this)
        queue.offer(15);
        queue.add(50);

        System.out.println("\nQueue :" + queue);
        System.out.println("removing using remove(): "+ queue.remove());//removes from front
        System.out.println("removing using poll() : "+ queue.poll());//removes from front  (use this)
        System.out.println("element at top after 2 removal: " + queue.peek());

    }
}
